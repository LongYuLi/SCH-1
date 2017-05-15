package com.lw.serivce;

import com.lw.bean.LwOptClass;
import com.lw.bean.LwOptDepartment;
import com.lw.dao.LwOptClassDAO;
import com.lw.dao.LwOptDepartmentDAO;
import com.lw.dao.LwOptLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
@Service
public class ClassService {
    @Autowired
    private LwOptClassDAO lwOptClassDAO;
    @Autowired
    private LwOptLoginDAO lwOptLoginDAO;

    public List findAll(){
        return lwOptClassDAO.findAll();
    }

    public void save(LwOptClass lwOptDepartment){
        lwOptClassDAO.save(lwOptDepartment);
    }

    public void saveOrUpdate(LwOptClass lwOptDepartment){
        lwOptClassDAO.attachDirty(lwOptDepartment);
    }
    public void delete(LwOptClass lwOptDepartment){
        lwOptClassDAO.delete(lwOptDepartment);
    }

    public List findByHql(String hql){
        return lwOptLoginDAO.findByHql(hql);
    }

    public List findByP(String s,Object o){
        return lwOptClassDAO.findByPropertyLike(s,o);
    }

}
