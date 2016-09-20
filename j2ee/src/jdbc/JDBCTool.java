package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTool
{
	private static void inital() throws ClassNotFoundException
	{
		// 注册驱动
		String driver = "org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver);
	}

	/**
	 * getConnection 获取数据库连接
	 *
	 * @return
	 * @throws SQLException
	 */
	private static Connection getConnection() throws SQLException
	{
		// 获取连接
		String url = "jdbc:derby://localhost:1527/firstdb01;create=true";
		Connection conn = DriverManager.getConnection(url);

		return conn;
	}

	public static void main(String[] args) throws SQLException,
	ClassNotFoundException
	{
		inital();
		Connection conn = getConnection();
		// conn.setAutoCommit(false);
		// PreparedStatement preStmt = conn
		// .prepareStatement("insert into t_user values (?,?)");
		// preStmt.setInt(1, 3);
		// preStmt.setString(2, "huahua");
		// preStmt.executeUpdate();
		// Statement stmt = conn.createStatement();
		// stmt.execute("create table t_user(id int primary key, Name varchar(255))");
		// stmt.executeUpdate("INSERT INTO t_user VALUES (2,'Zhang hua')");

		Statement stmt = conn.createStatement();
		// stmt.executeUpdate("INSERT INTO t_user VALUES (2,'Zhang hua')");
		// stmt.executeUpdate("INSERT INTO t_user VALUES (2,'Zhang hua')");
		// conn.rollback();
		// conn.commit();
		// conn.setAutoCommit(true);

		ResultSet rs = stmt.executeQuery("select * from t_user order by id");

		while (rs.next())
		{
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("Name"));
		}

		close(conn, stmt, null);
	}

	/**
	 * close 关闭数据库
	 */
	private static void close(Connection conn, Statement stmt, ResultSet rs)
	{
		try
		{
			// 关闭结果集
			if (rs != null)
			{
				rs.close();
			}

			// 关闭声明
			if (stmt != null)
			{
				stmt.close();
			}

			// 关闭连接
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			rs = null;
			stmt = null;
			conn = null;
		}
	}
}
