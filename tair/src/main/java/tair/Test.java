package tair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.impl.DefaultTairManager;

public class Test {

	private static DefaultTairManager tairManager = null;

	private static Serializable serial = new Exception();

	public static void init() {
		// 创建config server列表
		List<String> confServers = new ArrayList<String>();
		confServers.add("CONFIG_SERVER_ADDREEE:PORT");
		confServers.add("CONFIG_SERVER_ADDREEE_2:PORT"); // 可选

		// 创建客户端实例
		tairManager = new DefaultTairManager();
		tairManager.setConfigServerList(confServers);

		// 设置组名
		tairManager.setGroupName("GROUP_NAME");
		// 初始化客户端
		tairManager.init();
	}

	public static void testGet() {
		Result<DataEntry> result = tairManager.get(1, serial);

		if (result.isSuccess()) {
			DataEntry entry = result.getValue();
			if (entry != null) {
				// 数据存在
				entry.getValue();
			}
			else {
				// 数据不存在
			}
		}
		else {
			// 异常处理
		}
	}

	public static void testPut() {
		ResultCode rc = tairManager.put(1, serial, serial);
		if (rc.isSuccess()) {
			// put成功
		}
		else if (ResultCode.VERERROR.equals(rc)) {
			// 版本错误的处理代码
		}
		else {
			// 其他失败的处理代码
		}

		// version应该从get返回的DataEntry对象中获取
		// 出给使用0强制更新，否则不推荐随意指定版本
		rc = tairManager.put(1, serial, serial, 1);

		// 使用全参数版本的put
		rc = tairManager.put(1, serial, serial, 1, 1);
	}

	public static void testDelete() {
		// 使用删除接口
		ResultCode rc = tairManager.delete(1, serial);
		if (rc.isSuccess()) {
			// 删除成功
		}
		else {
			// 删除失败
		}
	}

	public static void testMdelete() {
		// 使用批量删除接口
		ResultCode rc = tairManager.mdelete(1, new ArrayList<Serializable>());
		if (rc.isSuccess()) {
			// 删除成功
		}
		else {
			// 部分成功处理代码
		}
	}

	public static void testIncr() {
		Result<Integer> result = tairManager.incr(1, serial, 1, 0, 0);
		if (result.isSuccess()) {
			int rv = result.getValue(); // 这里是1
		}
		else {
			// 错误处理
		}

		// 将返回4
		result = tairManager.incr(1, serial, 3, 0, 0);

		// 将返回2
		result = tairManager.decr(1, serial, 2, 0, 0);
	}

	public static void testItem() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);

		// 添加新的itmes
		ResultCode rc = tairManager.addItems(1, serial, intList, 50, 0, 0);

		// 获取item的总条数
		Result<Integer> ic = tairManager.getItemCount(1, serial);
		int totalCount = ic.getValue();

		// 获取所有items
		Result<DataEntry> rets = tairManager.getItems(1, serial, 0, totalCount);

		// 获取第一个item，并将其从系统中删除
		rets = tairManager.getAndRemove(1, serial, 0, 1);
	}
}
