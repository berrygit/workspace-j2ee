package structural.bridge;

public class TransientWindow extends Window
{
	public TransientWindow(WindowImp imp)
	{
		super(imp);
	}

	public void drawCloseBox()
	{
		drawRect();
	}
}
