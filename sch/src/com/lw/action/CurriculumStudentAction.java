package com.lw.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lw.bean.LwOptCurriculum;
import com.lw.bean.LwOptCurriculumStudents;
import com.lw.bean.LwOptPersonnel;
import com.lw.serivce.CurriculumService;
import com.lw.serivce.CurriculumStudentService;
import com.lw.util.ResporeUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
public class CurriculumStudentAction {

    @Autowired
    private CurriculumStudentService departmentService;
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();

    public void findAllCurrStu() throws IOException {
        List list=departmentService.findAll();
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

    public void saveCurrStu() throws IOException {
        String personnel=ResporeUtil.getPram(request,"personnel");
        String curriculum=ResporeUtil.getPram(request,"curriculum");
        LwOptPersonnel s=ResporeUtil.gson.fromJson(personnel,LwOptPersonnel.class);
        LwOptCurriculum b=ResporeUtil.gson.fromJson(curriculum,LwOptCurriculum.class);
        LwOptCurriculumStudents lw=new LwOptCurriculumStudents();
        lw.setLwOptCurriculum(b);
        lw.setLwOptPersonnel(s);
        if (check(lw)){
            ResporeUtil.write(response,"0");
            return;
        }
        departmentService.save(lw);
        ResporeUtil.write(response,"1");
    }

    public void saveOrUpCurrStu() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        String personnel=ResporeUtil.getPram(request,"personnel");
        String curriculum=ResporeUtil.getPram(request,"curriculum");
        LwOptPersonnel s=ResporeUtil.gson.fromJson(personnel,LwOptPersonnel.class);
        LwOptCurriculum b=ResporeUtil.gson.fromJson(curriculum,LwOptCurriculum.class);
        LwOptCurriculumStudents lw=new LwOptCurriculumStudents();
        lw.setCurriculumPersonnelId(Integer.parseInt(id));
        lw.setLwOptCurriculum(b);
        lw.setLwOptPersonnel(s);
        if (check(lw)){
            ResporeUtil.write(response,"0");
            return;
        }
        departmentService.saveOrUpdate(lw);
        ResporeUtil.write(response,"1");
    }

    public void deleteCurrStu() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        LwOptCurriculumStudents lw=new LwOptCurriculumStudents();
        lw=ResporeUtil.gson.fromJson(id,LwOptCurriculumStudents.class);
        departmentService.delete(lw);
        ResporeUtil.write(response,"1");
    }

    public boolean check(LwOptCurriculumStudents l){
        String hql="from LwOptCurriculumStudents where lwOptCurriculum.curriculumId="+l.getLwOptCurriculum().getCurriculumId()+" and lwOptPersonnel.personnelId="+l.getLwOptPersonnel().getPersonnelId();
        List ls=departmentService.findByHql(hql);
        if (ls!=null&&ls.size()>0){
            return true;
        }else {
            return false;
        }
    }

    public void findCurrStuByKey() throws IOException {

        String key =ResporeUtil.getPram(request,"key");
        String hql="from LwOptCurriculumStudents as a where 1=1 and a.lwOptPersonnel.personnelName like '%"+key+"%' or a.lwOptCurriculum.curriculumName like '%"+key+"%'";
        List list=departmentService.findByHql(hql);
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));

    }



}
