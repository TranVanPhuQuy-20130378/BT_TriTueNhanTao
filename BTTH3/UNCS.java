package BTTH3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UNCS implements ISearchAlgo{

	
	public Node execute(Node root, String goal) {
		
		 PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparing(Node::getPathCost));
	        Set<Node> explored = new HashSet<>();
	        frontier.add(root);

	        while (!frontier.isEmpty()) {
	            Node node = frontier.poll();
	            if (node.getLabel().equals(goal)) {
	                return node;
	            }
	            explored.add(node);
	            for (Edge edge : node.getChildren()) {
	                Node child = edge.getDest();
	                int newCost = (int) (node.getPathCost() + (int) edge.getCost());
	                if (!explored.contains(child) && !frontier.contains(child)) {
	                    child.setPathCost(newCost);
	                    child.setParent(node);
	                    frontier.add(child);
	                } else if (frontier.contains(child) && newCost < child.getPathCost()) {
	                    frontier.remove(child);
	                    child.setPathCost(newCost);
	                    child.setParent(node);
	                    frontier.add(child);
	                }
	            }
	        }

	        return null;
	    }
	
		

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
