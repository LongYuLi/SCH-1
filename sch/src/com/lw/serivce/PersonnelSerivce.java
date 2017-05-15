package com.lw.serivce;/**
 * Created by Administrator on 2017/4/27.
 */

import com.lw.dao.LwOptPersonnelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/4/27 22:59
 */
@Service
public class PersonnelSerivce {
    @Autowired
    private LwOptPersonnelDAO lwOptPersonnelDAO;

    public List findAll(){
        return lwOptPersonnelDAO.findAll();
    }

}
