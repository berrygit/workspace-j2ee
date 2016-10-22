package structural.adapter;

public class WildTurkey implements Turkey
{

	@Override
	public void gobble()
	{
		System.out.println("goble, goble!");
	}

}
