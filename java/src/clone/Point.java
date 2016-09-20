package clone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Point implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8637531176468759362L;

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Point clone() {
		// 克隆
		Point o = null;
		try {
			o = (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return o;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	public void save() throws IOException {
		// 将对象写到流里
		FileOutputStream bos = new FileOutputStream("tst.txt");
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
	}

	public Point deepClone() throws IOException, ClassNotFoundException {

		// 从流里读回来
		FileInputStream bis = new FileInputStream("tst.txt");
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (Point) ois.readObject();
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Point(10, 20).deepClone();
		// System.out.println(new Point(10, 20).save());
	}
}
