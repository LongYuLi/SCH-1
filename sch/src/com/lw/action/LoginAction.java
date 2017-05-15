package com.lw.action;

import com.lw.bean.LwOptResource;
import com.lw.serivce.LoginSerivce;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import com.lw.serivce.ResourcesSerivce;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginAction {
    private String name;
    private String password;
    private HttpServletResponse response = ServletActionContext.getResponse();
    @Autowired
    private LoginSerivce loginSerivce;
    @Autowired
    private ResourcesSerivce resourcesSerivce;

    public String tijiao() throws Throwable {
        Thread.sleep(2000);
        response.setContentType("text/html;charset=UTF-8");
        if (null != name || null != password) {
            if (loginSerivce.Login(name, password)) {
                List<LwOptResource> listRoleRes = resourcesSerivce.findAllbyxx(0);
                ActionContext.getContext().getSession().put("listRoleRes",listRoleRes);
                List<LwOptResource> listres = resourcesSerivce.findAll();
                for (int i = 0; i < listres.size(); i++) {
                    LwOptResource listre = listres.get(i);
                    if (listre.getResourceParent() == 0) {
                        listres.remove(i);
                    }
                }
                ActionContext.getContext().getSession().put("listres",listres);
                return "success";
            }else{
                response.getWriter().write("0");
            }
        }
        return "failure";
    }

    public void antijiao() throws Throwable {
        response.setContentType("text/html;charset=UTF-8");
        if (null != name || null != password) {
            if (loginSerivce.Login(name, password)) {
                response.getWriter().write("1");
            }else{
                response.getWriter().write("0");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
