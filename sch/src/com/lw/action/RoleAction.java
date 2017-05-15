package com.lw.action;/**
 * Created by Administrator on 2017/5/8.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.bean.LwOptResource;
import com.lw.bean.LwOptRoleResource;
import com.lw.serivce.ResourcesSerivce;
import com.lw.serivce.RoleSerivce;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/5/8 21:11
 */
public class RoleAction {
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();
    @Autowired
    private RoleSerivce roleSerivce;
    @Autowired
    private ResourcesSerivce resourcesSerivce;

    public String findAll() throws Exception {
        List list = roleSerivce.findAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
        String s = gson.toJson(list);
        List<LwOptResource> listres = resourcesSerivce.findAll();
        for (int i = 0; i < listres.size(); i++) {
            LwOptResource listre = listres.get(i);
            if (listre.getResourceParent() == 0) {
                listres.remove(i);
            }
        }
        ActionContext.getContext().getSession().put("listres",listres);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(s);
        return null;
    }
    public String selectRessourcesByRole() throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        List<LwOptRoleResource> list = roleSerivce.findByProperty(Integer.valueOf(id));
        StringBuffer stringBuffer=new StringBuffer();
        for (LwOptRoleResource roleResource : list) {
            stringBuffer=stringBuffer.append(roleResource.getLwOptResource().getResourceId()+",");
        }
        String s = stringBuffer.toString();
        response.getWriter().write(s);
        return null;
    }
    public void attachDirty() throws Exception {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String select = request.getParameter("select");
        String dizi = request.getParameter("obj");
        System.out.println(id);
        System.out.println(name);
        System.out.println(select);
        System.out.println(dizi);
        //if(id==null || "".equals(id)){
        //    LwOptResource lwOptResource = new LwOptResource();
        //    lwOptResource.setResourceName(name);
        //    lwOptResource.setResourceParent(Integer.valueOf(select));
        //    lwOptResource.setResourcePath(dizi);
        //    resourcesSerivce.updateResource(lwOptResource);
        //    response.getWriter().write("2");
        //    return;
        //}
        //LwOptResource lwOptResource = resourcesSerivce.findById(Integer.valueOf(id));
        //lwOptResource.setResourceName(name);
        //lwOptResource.setResourceParent(Integer.valueOf(select));
        //lwOptResource.setResourcePath(dizi);
        //resourcesSerivce.updateResource(lwOptResource);
        response.getWriter().write("1");
    }
}
