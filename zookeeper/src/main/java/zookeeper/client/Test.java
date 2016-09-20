package zookeeper.client;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class Test {
	public static void main(String[] args) {

		ZkClient zkClient = new ZkClient("127.0.0.1:2181");

		zkClient.createPersistent("/root");

		zkClient.create("/root/child", "data", CreateMode.EPHEMERAL);

		List<String> children = zkClient.getChildren("/root");

		for (String child : children) {
			System.out.println(child);
		}

		int count = zkClient.countChildren("/root");
		System.out.println(count);

		System.out.println(zkClient.exists("/root"));

		zkClient.writeData("/root/child", "hello everyone");

		System.out.println((String) zkClient.readData("/root/child"));

		zkClient.delete("/root/child");

	}
}
