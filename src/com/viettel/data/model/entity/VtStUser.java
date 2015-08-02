package com.viettel.data.model.entity;

// Generated Nov 4, 2014 10:12:27 AM by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import GlobalDefine.Config;

import com.viettel.data.query.UserQuery;

/**
 * 
 * @author hieuph
 *
 */

@Entity
@javax.persistence.NamedNativeQueries({
		@javax.persistence.NamedNativeQuery(name = UserQuery.GET_USER_BY_EMAIL_NAME, query = UserQuery.GET_USER_BY_EMAIL, resultClass = VtStUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = UserQuery.GET_USER_BY_ID_NAME, query = UserQuery.GET_USER_BY_ID, resultClass = VtStUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = UserQuery.LOGIN_USER_NAME, query = UserQuery.LOGIN_USER, resultClass = VtStUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = UserQuery.GET_LIST_PARENT_BY_USER_ID_NAME, query = UserQuery.GET_LIST_PARENT_BY_USER_ID, resultClass = VtStUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = UserQuery.GET_ALL_USERS_NAME, query = UserQuery.GET_ALL_USERS, resultClass = VtStUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")) })
@Table(name = "VT_ST_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_EMAIL"))
@XmlRootElement
public class VtStUser {

	private Long userId;
	private String userName;
	private String userAddress;
	private String userEmail;
	private String userWebsite;
	private String userPhone;
	private String receiveSysEmail;
	private String userPassword;
	private String userFullName;
	private String userBirthday;
	private Long userSex;
	private Long userIsactive;
	private String userActiveCode;
	private Date userRegistTime;
	private Long platformDefault;
	private Long zoneId;
	private Long roleId;

	public VtStUser() {
	}

	public VtStUser(Long userId) {
		this.userId = userId;
	}

	public VtStUser(Long userId, String userName, String userAddress,
			String userEmail, String userWebsite, String userPhone,
			String receiveSysEmail, String userPassword, String userFullName,
			String userBirthday, Long userSex, Long userIsactive,
			String userActiveCode, Date userRegistTime, Long platformDefault) {
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userWebsite = userWebsite;
		this.userPhone = userPhone;
		this.receiveSysEmail = receiveSysEmail;
		this.userPassword = userPassword;
		this.userFullName = userFullName;
		this.userBirthday = userBirthday;
		this.userSex = userSex;
		this.userIsactive = userIsactive;
		this.userActiveCode = userActiveCode;
		this.userRegistTime = userRegistTime;
		this.platformDefault = platformDefault;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_ADDRESS", length = 500)
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "USER_EMAIL", unique = true, length = 100)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_WEBSITE", length = 200)
	public String getUserWebsite() {
		return this.userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	@Column(name = "USER_PHONE", length = 50)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "RECEIVE_SYS_EMAIL", length = 100)
	public String getReceiveSysEmail() {
		return this.receiveSysEmail;
	}

	public void setReceiveSysEmail(String receiveSysEmail) {
		this.receiveSysEmail = receiveSysEmail;
	}

	@Column(name = "USER_PASSWORD", length = 200)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_FULL_NAME", length = 200)
	public String getUserFullName() {
		return this.userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	@Column(name = "USER_BIRTHDAY", length = 200)
	public String getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	@Column(name = "USER_SEX", precision = 22, scale = 0)
	public Long getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Long userSex) {
		this.userSex = userSex;
	}

	@Column(name = "USER_ISACTIVE", precision = 22, scale = 0)
	public Long getUserIsactive() {
		return this.userIsactive;
	}

	public void setUserIsactive(Long userIsactive) {
		this.userIsactive = userIsactive;
	}

	@Column(name = "USER_ACTIVE_CODE", length = 500)
	public String getUserActiveCode() {
		return this.userActiveCode;
	}

	public void setUserActiveCode(String userActiveCode) {
		this.userActiveCode = userActiveCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USER_REGIST_TIME")
	public Date getUserRegistTime() {
		return this.userRegistTime;
	}

	public void setUserRegistTime(Date userRegistTime) {
		this.userRegistTime = userRegistTime;
	}

	@Column(name = "PLATFORM_DEFAULT", precision = 22, scale = 0)
	public Long getPlatformDefault() {
		return platformDefault;
	}

	public void setPlatformDefault(Long platformDefault) {
		this.platformDefault = platformDefault;
	}

	@Column(name = "ROLE_ID", precision = 22, scale = 0)
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ZONE_ID", unique = true, length = 100)
	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

}