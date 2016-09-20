package zookeeper.api;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

public class Conf {

	private static Conf static_;

	private ZooKeeper zk_;

	private Conf() {
	}

	public static Conf Instance() {
		if (static_ == null) {
			static_ = new Conf();
		}
		return static_;
	}

	public static void waitUntilConnected(ZooKeeper zooKeeper, CountDownLatch connectedLatch) {
		if (States.CONNECTING == zooKeeper.getState()) {
			try {
				connectedLatch.await();
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	public ZooKeeper init() {

		String hostports = "127.0.0.1:2181";

		try {
			CountDownLatch connectedLatch = new CountDownLatch(1);
			Watcher watcher = new ConnectedWatcher(connectedLatch);
			zk_ = new ZooKeeper(hostports, 1000, watcher);
			waitUntilConnected(zk_, connectedLatch);
		} catch (Exception e) {
			System.out.println(e);
		}
		return zk_;
	}

	public String Get(String path) {
		String re = "";
		Stat stat = new Stat();
		try {
			byte[] b = zk_.getData(path, false, stat); // 获取节点的信息及存储的数据
			re = new String(b);
		} catch (Exception e) {
			System.out.println(e);
		}
		return re;
	}

	public static void main(String args[]) {

		String str = Conf.Instance().Get("/test");
		System.out.println(str);

	}

	static class ConnectedWatcher implements Watcher {

		private CountDownLatch connectedLatch;

		ConnectedWatcher(CountDownLatch connectedLatch) {
			this.connectedLatch = connectedLatch;
		}

		@Override
		public void process(WatchedEvent event) {
			System.out.println(event.getState() + ":" + event.getType());
			if (event.getState() == KeeperState.SyncConnected) {
				connectedLatch.countDown();
			}
		}
	}
}
