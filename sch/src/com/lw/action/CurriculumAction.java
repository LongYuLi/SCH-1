package com.lw.action;

import com.lw.bean.LwOptCurriculum;
import com.lw.bean.LwOptDepartment;
import com.lw.serivce.CurriculumService;
import com.lw.serivce.DepartmentService;
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
public class CurriculumAction {

    @Autowired
    private CurriculumService departmentService;
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();

    public void findAllCurr() throws IOException {
        List list=departmentService.findAll();
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

    public void saveCurr() throws IOException {
        String name=ResporeUtil.getPram(request,"name");
        String credit=ResporeUtil.getPram(request,"credit");
        LwOptCurriculum lw=new LwOptCurriculum();
        lw.setCurriculumName(name);
        lw.setCurriculumCredit(Double.parseDouble(credit));
        departmentService.save(lw);
        ResporeUtil.write(response,"1");
    }

    public void saveOrUpCurr() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        String name=ResporeUtil.getPram(request,"name");
        String credit=ResporeUtil.getPram(request,"credit");
        LwOptCurriculum lw=new LwOptCurriculum();
        lw.setCurriculumName(name);
        lw.setCurriculumCredit(Double.parseDouble(credit));
        lw.setCurriculumId(Integer.parseInt(id));
        departmentService.saveOrUpdate(lw);
        ResporeUtil.write(response,"1");
    }

    public void deleteCurr() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        LwOptCurriculum lw=new LwOptCurriculum();
        lw.setCurriculumId(Integer.parseInt(id));
        departmentService.delete(lw);
        ResporeUtil.write(response,"1");
    }

    public void findCurrByName() throws IOException {
        String name=ResporeUtil.getPram(request,"name");
        List list=departmentService.findByP("curriculumName",name);
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

}
