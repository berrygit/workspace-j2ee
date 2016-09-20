package spring;

public class ConstructorUserService
{
	private User user;

	public ConstructorUserService(User user)
	{
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConstructorUserService [user=" + user + "]";
	}

}
