package zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class Test {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

		ZooKeeper zk = Conf.Instance().init();
		// ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",
		// 1000,null);

		// 创建节点(可以带或不带数据)
		zk.create("/root", "root data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

		// 查询节点内容
		Stat stat = new Stat();
		System.out.println(new String(zk.getData("/root", true, stat)));// true其实是在注册默认watcher(new
																		// zookeeper时指定的那个)

		// 设置节点内容。version为datanode的version，本方法默认返回Stat
		zk.setData("/root", "hello".getBytes(), -1);
		System.out.println(new String(zk.getData("/root", true, stat)));

		// 创建子节点(必须一级一级的创建)
		zk.create("/root/child", "root data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		// 删除节点
		zk.delete("/root/child", -1);
		zk.delete("/root", -1);

		// 判断节点是否存在
		stat = zk.exists("/root", true);
		if (stat == null) {
			System.out.println("节点root不存在");
		}
		else {
			System.out.println("节点root仍然存在");
		}

		// 注册watcher，可以有多个，watcher为一次性的，想要使用必须提前注册，注册只对指定节点有效，
		// 对子节点的变化是无感知的；在watcher失效后和下次注册前的这段时间内是有事件监听的真空期的。
		// zk.register(new Watcher(){
		// @Override
		// public void process(WatchedEvent event) {
		// // TODO Auto-generated method stub
		//
		// }});
		// }

		// 关闭session
		zk.close();
	}
}
