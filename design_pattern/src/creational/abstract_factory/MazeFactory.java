package creational.abstract_factory;

import creational.Maze;

public class MazeFactory
{
	public Maze makeMaze()
	{
		return new Maze();
	}

	public Wall makeWall()
	{
		return new Wall();
	}

	public Room makeRoom(int n)
	{
		return new Room(n);
	}

	public Door makeDoor()
	{
		return new Door();
	}
}
