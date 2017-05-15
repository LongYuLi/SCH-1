package com.lw.serivce;

import com.lw.bean.LwOptCurriculum;
import com.lw.bean.LwOptCurriculumStudents;
import com.lw.dao.LwOptCurriculumDAO;
import com.lw.dao.LwOptCurriculumStudentsDAO;
import com.lw.dao.LwOptLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
@Service
public class CurriculumStudentService {
    @Autowired
    private LwOptCurriculumStudentsDAO lwOptCurriculumStudentsDAO;
    @Autowired
    private LwOptLoginDAO lwOptLoginDAO;

    public List findAll(){
        return lwOptCurriculumStudentsDAO.findAll();
    }

    public void save(LwOptCurriculumStudents lwOptDepartment){
        lwOptCurriculumStudentsDAO.save(lwOptDepartment);
    }

    public void saveOrUpdate(LwOptCurriculumStudents lwOptDepartment){
        lwOptCurriculumStudentsDAO.attachDirty(lwOptDepartment);
    }
    public void delete(LwOptCurriculumStudents lwOptDepartment){
        lwOptCurriculumStudentsDAO.delete(lwOptDepartment);
    }

    public List findByHql(String hql){
        return lwOptLoginDAO.findByHql(hql);
    }


}
