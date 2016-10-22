package structural.bridge;

public class IconWindow extends Window
{

	public IconWindow(WindowImp imp)
	{
		super(imp);
	}

	public void drawBorder()
	{
		drawText();
		drawRect();
	}

}
