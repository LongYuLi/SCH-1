package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptDepartment;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptDepartment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see LwOptDepartment
 * @author MyEclipse Persistence Tools
 */
public class LwOptDepartmentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptDepartmentDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptDepartment transientInstance) {
		log.debug("saving LwOptDepartment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptDepartment persistentInstance) {
		log.debug("deleting LwOptDepartment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptDepartment findById(Integer id) {
		log.debug("getting LwOptDepartment instance with id: " + id);
		try {
			LwOptDepartment instance = (LwOptDepartment) getHibernateTemplate()
					.get("com.lw.bean.LwOptDepartment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptDepartment instance) {
		log.debug("finding LwOptDepartment instance by example");
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
		log.debug("finding LwOptDepartment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptDepartment as model where model."
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
			String queryString = "from LwOptDepartment as model where model."
					+ propertyName + " like ?";
			return getHibernateTemplate().find(queryString, "%"+value+"%");
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptDepartment instances");
		try {
			String queryString = "from LwOptDepartment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptDepartment merge(LwOptDepartment detachedInstance) {
		log.debug("merging LwOptDepartment instance");
		try {
			LwOptDepartment result = (LwOptDepartment) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptDepartment instance) {
		log.debug("attaching dirty LwOptDepartment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptDepartment instance) {
		log.debug("attaching clean LwOptDepartment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptDepartmentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptDepartmentDAO) ctx.getBean("LwOptDepartmentDAO");
	}
}