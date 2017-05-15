package com.lw.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.bean.LwOptDepartment;
import com.lw.serivce.DepartmentService;
import com.lw.util.ResporeUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
public class DepartmentAction {

    @Autowired
    private DepartmentService departmentService;
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();

    public void findAllDe() throws IOException {
        List list=departmentService.findAll();
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

    public void saveDe() throws IOException {
        String name=ResporeUtil.getPram(request,"name");
        LwOptDepartment lw=new LwOptDepartment();
        lw.setDepartmentName(name);
        departmentService.save(lw);
        ResporeUtil.write(response,"1");
    }

    public void saveOrUpDe() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        String name=ResporeUtil.getPram(request,"name");
        LwOptDepartment lw=new LwOptDepartment();
        lw.setDepartmentName(name);
        lw.setDepartmentId(Integer.parseInt(id));
        departmentService.saveOrUpdate(lw);
        ResporeUtil.write(response,"1");
    }

    public void deleteDe() throws IOException {
        String id=ResporeUtil.getPram(request,"id");
        LwOptDepartment lw=new LwOptDepartment();
        lw.setDepartmentId(Integer.parseInt(id));
        departmentService.delete(lw);
        ResporeUtil.write(response,"1");
    }

    public void findByName() throws IOException {
        String name=ResporeUtil.getPram(request,"name");
        List list=departmentService.findByP("departmentName",name);
        ResporeUtil.write(response,ResporeUtil.gson.toJson(list));
    }

}
