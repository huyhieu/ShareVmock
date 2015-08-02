package com.viettel.data.query;

/**
 * @author hieunq5
 * 
 */
public class UserQuery {

	public static final String GET_USER_BY_EMAIL_NAME = "getUserByEmail";
	public static final String GET_USER_BY_EMAIL = "{? =  call fn_get_user_by_email(:email) }"; // OK

	public static final String GET_ALL_USERS_NAME = "getAllUsers";
	public static final String GET_ALL_USERS = "{? =  call fn_get_all_user() }"; // OK

	public static final String GET_USER_BY_ID_NAME = "getUserById";
	public static final String GET_USER_BY_ID = "{? =  call fn_get_user_by_userid(:userId) }"; // OK

	public static final String GET_LIST_PARENT_BY_USER_ID_NAME = "get_list_parent_by_user_id";
	public static final String GET_LIST_PARENT_BY_USER_ID = "{? = call get_list_parent_by_user_id(:userId)}";

	public static final String LOGIN_USER_NAME = "loginUserByUsernamePassword";
	public static final String LOGIN_USER = "{? =  call fn_login_user(:email, :password) }"; // OK

	// REMOVE
	public static final String REMOVE_ACCOUNT_BY_ID = "{Call remove_user_by_id(:userId)}"; // OK

	public static final String INSERT_USER_ACCOUNT = "{Call insert_user_account(:userId, :fullName, :birthday, :email, :pass, :activeCode, :sex, :isActive, :regisTime)}"; // ok

}
