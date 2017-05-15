package com.lw.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
public class ResporeUtil {
        public static void write(HttpServletResponse response,String s) throws IOException {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(s);
        }
        public static String getPram(HttpServletRequest request,String s){
            return  request.getParameter(s);
        }

        public static Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
}
