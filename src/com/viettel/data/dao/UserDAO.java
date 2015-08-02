package com.viettel.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.viettel.data.model.entity.VtStUser;
import com.viettel.data.query.UserQuery;
import com.viettel.util.HibernateUtil;

/**
 * @author hieunq5
 * 
 */

public class UserDAO {

	public static UserDAO instance = null;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("VT_ST_USER_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	/**
	 * @param userId
	 * @param fullName
	 * @param birthday
	 * @param email
	 * @param pass
	 * @param activeCode
	 * @param sex
	 * @param isActive
	 * @param regisTime
	 * @return
	 */
	public boolean register(Long userId, String fullName, String birthday,
			String email, String pass, String activeCode, Long sex,
			Long isActive, Long regisTime) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		try {
			Query query = session.createSQLQuery(UserQuery.INSERT_USER_ACCOUNT);
			query.setParameter("userId", userId);
			query.setParameter("fullName", fullName);
			query.setParameter("birthday", birthday);
			query.setParameter("email", email);
			query.setParameter("pass", pass);
			query.setParameter("activeCode", activeCode);
			query.setParameter("sex", sex);
			query.setParameter("isActive", isActive);
			query.setParameter("regisTime", regisTime);
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * @return list of user accounts from database
	 */
	@SuppressWarnings("unchecked")
	public List<VtStUser> getAllUserAccount() {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		Query query = session.getNamedQuery(UserQuery.GET_ALL_USERS_NAME);
		List<VtStUser> lstAccount = query.list();
		session.close();
		return lstAccount;
	}

	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VtStUser> getListParentByUserId(Long userId) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		Query query = session
				.getNamedQuery(UserQuery.GET_LIST_PARENT_BY_USER_ID_NAME);
		query.setParameter("userId", userId);
		List<VtStUser> lstAccount = query.list();
		session.close();
		return lstAccount;
	}

	/**
	 * @param email
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public VtStUser getUserByEmail(String email) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		Query query = session.getNamedQuery(UserQuery.GET_USER_BY_EMAIL_NAME);
		query.setParameter("email", email);
		List<VtStUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty())
			return null;
		return lstAccount.get(0);
	}

	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public VtStUser getUserByUserId(Long userId) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		Query query = session.getNamedQuery(UserQuery.GET_USER_BY_ID_NAME);
		query.setParameter("userId", userId);
		List<VtStUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty())
			return null;
		return lstAccount.get(0);
	}

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public VtStUser loginUser(String email, String password) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		Query query = session.getNamedQuery(UserQuery.LOGIN_USER_NAME);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<VtStUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty()) {
			return null;
		}
		return lstAccount.get(0);
	}

	/**
	 * @param userId
	 * @return
	 */
	public boolean removeUserAccountbyId(Long userId) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		try {
			Query query = session
					.createSQLQuery(UserQuery.REMOVE_ACCOUNT_BY_ID);
			query.setParameter("userId", userId);
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * @param account
	 * @return
	 */
	public boolean updateAccount(VtStUser stUser) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(stUser);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			// session.close();
		}
		return true;
	}

	/**
	 * @param account
	 * @return
	 */
	public boolean removeUserAccount(VtStUser account) {
		Session session = HibernateUtil.getSession();session.beginTransaction();
		try {
			session.delete(account);
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean insertUser(VtStUser stUser) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(stUser);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			// session.close();
		}
		return true;
	}
}
