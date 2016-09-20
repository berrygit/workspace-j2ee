package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * 有向图用两个Map标识，一个Map标识每个节点祖先的数量，另一个Map标识所有后继节点。
 * 
 * @author berry
 *
 */
public class TopologicalSort {

	public static void main(String[] args) {

		Map<String, Integer> preNodeCountMap = new HashMap<String, Integer>();

		Map<String, List<String>> successorNodesMap = new HashMap<String, List<String>>();

		preNodeCountMap.put("A", 2);
		preNodeCountMap.put("B", 1);
		preNodeCountMap.put("C", 1);
		preNodeCountMap.put("D", 0);
		List<String> aList = new ArrayList<String>();
		aList.add("B");
		successorNodesMap.put("A", aList);
		List<String> bList = new ArrayList<String>();
		bList.add("C");
		successorNodesMap.put("B", bList);
		List<String> cList = new ArrayList<String>();
		cList.add("A");
		successorNodesMap.put("C", cList);
		List<String> dList = new ArrayList<String>();
		dList.add("A");
		successorNodesMap.put("D", dList);

		new TopologicalSort().sort(preNodeCountMap, successorNodesMap);
	}

	public void sort(Map<String, Integer> preNodeCountMap, Map<String, List<String>> successorNodesMap) {

		if (preNodeCountMap == null || successorNodesMap == null) {
			throw new IllegalArgumentException("countMap or successorsMap argument can't be null.");
		}

		// 队列保存所有入度为0的节点
		Queue<String> outputQueue = new LinkedList<String>();

		for (Entry<String, Integer> entry : preNodeCountMap.entrySet()) {
			if (entry.getValue() == 0) {
				outputQueue.add(entry.getKey());
			}
		}

		int nodeCount = 0;

		// 依次输出入度为0的节点
		while (!outputQueue.isEmpty()) {
			String node = outputQueue.remove();

			System.out.print(node + "->");

			nodeCount++;

			List<String> suceesors = successorNodesMap.get(node);

			if (suceesors == null) {
				return;
			}

			// 更新该节点后继节点的入度
			for (String successor : suceesors) {
				int preNodeCount = preNodeCountMap.get(successor) - 1;

				// 如果为0加入队列
				if (preNodeCount == 0) {
					outputQueue.add(successor);
				}

				preNodeCountMap.put(successor, preNodeCount);
			}
		}

		// 探测是否有环
		if (nodeCount != preNodeCountMap.size()) {
			System.out.println("cicle！");
		}
	}
}
