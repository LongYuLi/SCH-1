package com.lw.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.bean.LwOptClass;
import com.lw.bean.LwOptDepartment;
import com.lw.serivce.ClassService;
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
public class ClassAction {

    @Autowired
    private ClassService classService;
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();

    public void findAllCla() throws IOException {
        List list=classService.findAll();
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

    public void saveCla() throws IOException {
        String name=ResporeUtil.getPram(request,"name");
        String number=ResporeUtil.getPram(request,"number");
        String department=ResporeUtil.getPram(request,"department");
        LwOptClass lw=new LwOptClass();
        lw.setClassName(name);
        lw.setClassNumber(Integer.parseInt(number));
        lw.setClassDepartment(department);
        classService.save(lw);
        ResporeUtil.write(response,"1");
    }



    public void saveOrUpCla() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        String name=ResporeUtil.getPram(request,"name");
        String number=ResporeUtil.getPram(request,"number");
        String departmentId=ResporeUtil.getPram(request,"departmentId");
        LwOptClass lw=new LwOptClass();
        lw.setClassId(Integer.parseInt(id));
        lw.setClassName(name);
        lw.setClassNumber(Integer.parseInt(number));
        lw.setClassDepartment(departmentId);
        classService.saveOrUpdate(lw);
        ResporeUtil.write(response,"1");
    }

    public void deleteCla() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        LwOptClass lw=new LwOptClass();
        lw.setClassId(Integer.parseInt(id));
        classService.delete(lw);
        ResporeUtil.write(response,"1");
    }

    public void findClaByKey() throws IOException {
        String key = ResporeUtil.getPram(request,"key");
        List list=classService.findByP("className",key);
        String s = ResporeUtil.gson.toJson(list);
        ResporeUtil.write(response,s);
    }




}
