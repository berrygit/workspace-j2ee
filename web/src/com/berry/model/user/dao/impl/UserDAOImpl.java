package com.berry.model.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.berry.model.user.bean.UserBean;
import com.berry.model.user.dao.UserDAO;

@Component("userDAO")
// bean的name
public class UserDAOImpl implements UserDAO {
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<UserBean> queryUser(UserBean user) {

		String hql = "from UserBean as user where user.name=:name";

		@SuppressWarnings("unchecked")
		List<UserBean> list = (List<UserBean>) hibernateTemplate.findByNamedParam(hql, "name", user.getName());

		return list;
	}

	@Override
	public boolean addUser(UserBean user) {
		hibernateTemplate.save(user);

		return true;
	}

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate
	 *            the hibernateTemplate to set
	 */
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
