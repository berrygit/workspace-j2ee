package structural.bridge;

public class Window
{
	WindowImp imp = null;

	public Window(WindowImp imp)
	{
		this.imp = imp;
	}

	public void drawText()
	{
		imp.devDrawText();
	}

	public void drawRect()
	{
		imp.devDrawLine();
	}
}
