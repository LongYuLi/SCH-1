package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptCurriculum;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptCurriculum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptCurriculum
 * @author MyEclipse Persistence Tools
 */
public class LwOptCurriculumDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptCurriculumDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptCurriculum transientInstance) {
		log.debug("saving LwOptCurriculum instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptCurriculum persistentInstance) {
		log.debug("deleting LwOptCurriculum instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptCurriculum findById(Integer id) {
		log.debug("getting LwOptCurriculum instance with id: " + id);
		try {
			LwOptCurriculum instance = (LwOptCurriculum) getHibernateTemplate()
					.get("com.lw.bean.LwOptCurriculum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptCurriculum instance) {
		log.debug("finding LwOptCurriculum instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LwOptCurriculum instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptCurriculum as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyLike(String propertyName, Object value) {
		log.debug("finding LwOptDepartment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptCurriculum as model where model."
					+ propertyName + " like ?";
			return getHibernateTemplate().find(queryString, "%"+value+"%");
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptCurriculum instances");
		try {
			String queryString = "from LwOptCurriculum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptCurriculum merge(LwOptCurriculum detachedInstance) {
		log.debug("merging LwOptCurriculum instance");
		try {
			LwOptCurriculum result = (LwOptCurriculum) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptCurriculum instance) {
		log.debug("attaching dirty LwOptCurriculum instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptCurriculum instance) {
		log.debug("attaching clean LwOptCurriculum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptCurriculumDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptCurriculumDAO) ctx.getBean("LwOptCurriculumDAO");
	}
}