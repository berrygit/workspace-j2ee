package com.berry.business.register.vo;

public class RegisterInfo
{
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String passWord;

	/**
	 * 确认密码
	 */
	private String confirmPassWord;

	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord()
	{
		return passWord;
	}

	/**
	 * @return the confirmPassWord
	 */
	public String getConfirmPassWord()
	{
		return confirmPassWord;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * @param passWord
	 *            the passWord to set
	 */
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	/**
	 * @param confirmPassWord
	 *            the confirmPassWord to set
	 */
	public void setConfirmPassWord(String confirmPassWord)
	{
		this.confirmPassWord = confirmPassWord;
	}
}
