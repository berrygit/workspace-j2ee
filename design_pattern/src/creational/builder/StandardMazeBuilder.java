package creational.builder;

import creational.Maze;
import creational.abstract_factory.Door;
import creational.abstract_factory.Room;
import creational.abstract_factory.Wall;

public class StandardMazeBuilder extends MazeBuilder
{
	private Maze _currentMaze;

	@Override
	public void buildMaze()
	{
		_currentMaze = new Maze();
	}

	@Override
	public void buildRoom(int n)
	{
		if (_currentMaze.getRoomByNo(n) == null)
		{
			Room room = new Room(n);
			_currentMaze.addRoom(room);

			room.setSide("north", new Wall());
			room.setSide("south", new Wall());
			room.setSide("east", new Wall());
			room.setSide("weast", new Wall());

		}
	}

	@SuppressWarnings("unused")
	@Override
	public void buildDoor(int roomFrom, int roomTo)
	{
		Room r1 = _currentMaze.getRoomByNo(roomFrom);
		Room r2 = _currentMaze.getRoomByNo(roomTo);
		Door door = new Door(roomFrom, roomTo);

		// TODO r1.setSide("", door);

	}

	@Override
	public Maze getMaze()
	{
		return _currentMaze;
	}

}
