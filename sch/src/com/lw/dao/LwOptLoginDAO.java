package com.lw.dao;

import com.lw.bean.LwOptLogin;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;
import java.util.Objects;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptLogin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptLogin
 * @author MyEclipse Persistence Tools
 */
public class LwOptLoginDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptLoginDAO.class);

	protected void initDao() {
		// do nothing
	}
	public boolean login(String name, String paw) {
		Session session = getSession();
		String hql = "from LwOptLogin where loginName=? and loginPaw=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		query.setParameter(1, paw);
		List list = query.list();
		if (!list.isEmpty() && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	public void save(LwOptLogin transientInstance) {
		log.debug("saving LwOptLogin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptLogin persistentInstance) {
		log.debug("deleting LwOptLogin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptLogin findById(Integer id) {
		log.debug("getting LwOptLogin instance with id: " + id);
		try {
			LwOptLogin instance = (LwOptLogin) getHibernateTemplate().get(
					"com.lw.bean.LwOptLogin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptLogin instance) {
		log.debug("finding LwOptLogin instance by example");
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
		log.debug("finding LwOptLogin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LwOptLogin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHql(String hql){
		return getHibernateTemplate().find(hql);
	}

	public List findAll() {
		log.debug("finding all LwOptLogin instances");
		try {
			String queryString = "from LwOptLogin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptLogin merge(LwOptLogin detachedInstance) {
		log.debug("merging LwOptLogin instance");
		try {
			LwOptLogin result = (LwOptLogin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptLogin instance) {
		log.debug("attaching dirty LwOptLogin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptLogin instance) {
		log.debug("attaching clean LwOptLogin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptLoginDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LwOptLoginDAO) ctx.getBean("LwOptLoginDAO");
	}
}