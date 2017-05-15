package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptClass;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptClass entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see LwOptClass
 * @author MyEclipse Persistence Tools
 */
public class LwOptClassDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptClassDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptClass transientInstance) {
		log.debug("saving LwOptClass instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptClass persistentInstance) {
		log.debug("deleting LwOptClass instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptClass findById(Integer id) {
		log.debug("getting LwOptClass instance with id: " + id);
		try {
			LwOptClass instance = (LwOptClass) getHibernateTemplate().get(
					"com.lw.bean.LwOptClass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptClass instance) {
		log.debug("finding LwOptClass instance by example");
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
		log.debug("finding LwOptClass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LwOptClass as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyLike(String propertyName, Object value) {
		log.debug("finding LwOptClass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LwOptClass as model where model."
					+ propertyName + " like ?";
			return getHibernateTemplate().find(queryString, "%"+value+"%");
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptClass instances");
		try {
			String queryString = "from LwOptClass";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptClass merge(LwOptClass detachedInstance) {
		log.debug("merging LwOptClass instance");
		try {
			LwOptClass result = (LwOptClass) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptClass instance) {
		log.debug("attaching dirty LwOptClass instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptClass instance) {
		log.debug("attaching clean LwOptClass instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptClassDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LwOptClassDAO) ctx.getBean("LwOptClassDAO");
	}
}