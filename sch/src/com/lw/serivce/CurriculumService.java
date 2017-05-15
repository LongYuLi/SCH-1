package com.lw.serivce;

import com.lw.bean.LwOptCurriculum;
import com.lw.bean.LwOptDepartment;
import com.lw.dao.LwOptCurriculumDAO;
import com.lw.dao.LwOptLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
@Service
public class CurriculumService {
    @Autowired
    private LwOptCurriculumDAO lwOptCurriculum;
    @Autowired
    private LwOptLoginDAO lwOptLoginDAO;

    public List findAll(){
        return lwOptCurriculum.findAll();
    }

    public void save(LwOptCurriculum lwOptDepartment){
        lwOptCurriculum.save(lwOptDepartment);
    }

    public void saveOrUpdate(LwOptCurriculum lwOptDepartment){
        lwOptCurriculum.attachDirty(lwOptDepartment);
    }
    public void delete(LwOptCurriculum lwOptDepartment){
        lwOptCurriculum.delete(lwOptDepartment);
    }

    public List findByHql(String hql){
        return lwOptLoginDAO.findByHql(hql);
    }

    public List findByP(String p,Object s){
        return lwOptCurriculum.findByPropertyLike(p,s);
    }

}
