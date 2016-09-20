package spring;

@Component("annotationUserService")
public class AnnotationUserService
{
	private User user;

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

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	@Autowired
	public void setUser(User user)
	{
		this.user = user;
	}

}
