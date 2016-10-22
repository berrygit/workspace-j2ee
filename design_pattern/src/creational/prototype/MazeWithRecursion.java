package creational.prototype;

public class MazeWithRecursion
{
	// 地图
	static int[][] maze =
	{
	{ 1, 1, 1, 1, 1, 1 },
	{ 0, 0, 1, 1, 1, 1 },
	{ 1, 0, 0, 0, 1, 1 },
	{ 1, 0, 1, 1, 0, 1 },
	{ 1, 0, 0, 0, 0, 0 },
	{ 1, 1, 1, 1, 1, 1 } };

	static int[][] visited = new int[6][6]; // 是否访问过
	static int[][] path = new int[6][6];	// 路径

	public static void main(String[] args)
	{
		// 初始化
		initial(visited);
		initial(path);

		// 迷宫起点
		Point p = new Point();
		p.setX(1);
		p.setY(0);

		// 寻找路径穿越迷宫
		passTheMaze(p);

		// 输出答案
		printAnswer();
	}

	/**
	 * 输出答案
	 * 
	 * @param path
	 *            答案所在地
	 */
	private static void printAnswer()
	{
		for (int[] is : path)
		{
			for (int i : is)
			{
				System.out.print(i);
			}

			System.out.println();
		}
	}

	/**
	 * 初始化
	 * 
	 * @param array
	 *            待初始化数组
	 */
	private static void initial(int[][] array)
	{
		for (int[] is : array)
		{
			for (int j = 0; j < is.length; j++)
			{
				is[j] = 0;
			}
		}
	}

	/**
	 * 穿越迷宫
	 * 
	 * @param p
	 *            当前位置
	 * @return 当前位置是否有路可走
	 */
	private static boolean passTheMaze(Point p)
	{
		// 当前位置是否走过
		if (isVisited(p))
		{
			return false;
		}

		// 当前位置是否是出口
		if (isExit(p))
		{
			return true;
		}

		// 标记
		setPath(p);
		setVisited(p);

		// 向不同方向尝试
		Point left = p.clone();
		if (moveLeft(left))
		{
			if (passTheMaze(left))
			{
				return true;
			}
		}

		Point up = p.clone();
		if (moveUp(up))
		{
			if (passTheMaze(up))
			{
				return true;
			}
		}

		Point right = p.clone();
		if (moveRight(right))
		{
			if (passTheMaze(right))
			{
				return true;
			}
		}

		Point down = p.clone();
		if (moveDown(down))
		{
			if (passTheMaze(down))
			{
				return true;
			}
		}

		// 如果四个方向均无法通过，说明是死路，该路径不可走，故清除
		clearPath(p);

		return false;
	}

	/**
	 * 设置路径
	 * 
	 * @param p
	 *            位置
	 */
	private static void setPath(Point p)
	{
		path[p.getX()][p.getY()] = 1;
	}

	/**
	 * 清除路径
	 * 
	 * @param p
	 *            位置
	 */
	private static void clearPath(Point p)
	{
		path[p.getX()][p.getY()] = 0;
	}

	/**
	 * 设置访问标记
	 * 
	 * @param p
	 *            访问位置
	 */
	private static void setVisited(Point p)
	{
		visited[p.getX()][p.getY()] = 1;
	}

	/**
	 * 探测访问是否可以进行
	 * 
	 * @param p
	 *            原位置
	 * @param temp
	 *            待访问位置
	 * @return 是否成功
	 */
	private static boolean testMoveable(Point p)
	{
		// 判断是否越界或是墙壁
		if (isOutBound(p) || isWall(p))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * 向左走
	 * 
	 * @param p位置
	 * @return是否成功
	 */
	private static boolean moveLeft(Point p)
	{
		// 移动
		p.setY(p.getY() - 1);

		return testMoveable(p);
	}

	/**
	 * 向上走
	 * 
	 * @param p位置
	 * @return是否成功
	 */
	private static boolean moveUp(Point p)
	{
		// 移动
		p.setX(p.getX() - 1);

		return testMoveable(p);
	}

	/**
	 * 向右走
	 * 
	 * @param p位置
	 * @return 是否成功
	 */
	private static boolean moveRight(Point p)
	{
		// 移动
		p.setY(p.getY() + 1);

		return testMoveable(p);
	}

	/**
	 * 向下走
	 * 
	 * @param p位置
	 * @return是否成功
	 */
	private static boolean moveDown(Point p)
	{
		// 移动
		p.setX(p.getX() + 1);

		return testMoveable(p);
	}

	/**
	 * 判断是否是墙
	 * 
	 * @param p
	 *            位置
	 * @return 是否是墙
	 */
	private static boolean isWall(Point p)
	{
		if (1 == maze[p.getX()][p.getY()])
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 是否是出口
	 * 
	 * @param p
	 *            位置
	 * @return 是否是出口
	 */
	private static boolean isExit(Point p)
	{
		if (((maze.length - 2) == p.getX()) && ((maze.length - 1) == p.getY()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 是否曾经访问过
	 * 
	 * @param p位置
	 * @return是否曾经访问过
	 */
	private static boolean isVisited(Point p)
	{
		if (1 == visited[p.getX()][p.getY()])
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 是否越界
	 * 
	 * @param p
	 *            位置
	 * @return 是否越界
	 */
	private static boolean isOutBound(Point p)
	{
		if (((0 <= p.getX()) && (p.getX() < maze.length))
				&& ((0 <= p.getY()) && (p.getY() < maze.length)))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
