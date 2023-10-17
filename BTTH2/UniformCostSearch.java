package BTTH2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UniformCostSearch implements ISearchAlgo {
	public Node execute(Node root, String goal) {
		root.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {

			// override compare method
			public int compare(Node i, Node j) {
				if (i.pathCost > j.pathCost) {
					return 1;
				}

				else if (i.pathCost < j.pathCost) {
					return -1;
				}

				else {
					return 0;
				}
			}
		}

		);

		queue.add(root);
		Set<Node> explored = new HashSet<Node>();
		boolean found = false;

		// while frontier is not empty
		do {

			Node current = queue.poll();
			explored.add(current);

			if (current.value.equals(goal)) {
				found = true;

			}

			for (Edge e : current.getChildren()) {
				Node child = e.target;
				double cost = e.cost;
				child.pathCost = current.pathCost + cost;

				if (!explored.contains(child) && !queue.contains(child)) {

					child.parent = current;
					queue.add(child);

					System.out.println(child);
					System.out.println(queue);
					System.out.println();

				}

				else if ((queue.contains(child)) && (child.pathCost > current.pathCost)) {

					child.parent = current;
					current = child;

				}

			}
		} while (!queue.isEmpty());

		return root;

	}

	public static List<Node> printPath(Node target) {
		List<Node> path = new ArrayList<Node>();
		for (Node node = target; node != null; node = node.parent) {
			path.add(node);
		}

		Collections.reverse(path);

		return path;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
