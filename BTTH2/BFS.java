package BTTH2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<>();
        Set<Node> explored = new HashSet<>();

        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

          
            if (current.getLabel().equals(goal)) {
                return current;
            }
            for (Node child : current.getChildrenNodes()) {

                if (!explored.contains(child) && !frontier.contains(child)) {
              
                    child.setPath(current.getPath());
                    child.getPath().add(child); 
                    frontier.add(child);
                }
            }

        
            explored.add(current);
        }

        
        return null;
    }

	
	public Node execute(Node root, String start, String goal) {
	    Queue<Node> frontier = new LinkedList<>();
	    Set<Node> explored = new HashSet<>();

	    // Tìm nút bắt đầu trong cây tìm kiếm
	    Node startNode = findNode(root, start);
	    
	    if (startNode == null) {
	        System.out.println("Không tìm thấy nút bắt đầu.");
	        return null;
	    }

	    frontier.add(startNode);

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();

	        // Kiểm tra xem nút hiện tại có phải là nút đích không
	        if (current.getLabel().equals(goal)) {
	            return current;
	        }

	        // Lặp qua các nút con của nút hiện tại
	        for (Node child : current.getChildrenNodes()) {
	            // Kiểm tra xem nút con đã được khám phá chưa
	            if (!explored.contains(child) && !frontier.contains(child)) {
	                // Sao chép đường đi từ nút bắt đầu đến nút hiện tại
	                child.setPath(startNode.getPath());
	                child.getPath().add(child); // Thêm nút con vào đường đi
	                frontier.add(child);
	            }
	        }

	        // Đánh dấu nút hiện tại là đã khám phá
	        explored.add(current);
	    }

	    // Trả về null nếu không tìm thấy đích
	    return null;
	}

	// Phương thức để tìm nút có nhãn bằng 'label' trong cây tìm kiếm
	private Node findNode(Node root, String label) {
	    if (root == null) {
	        return null;
	    }

	    if (root.getLabel().equals(label)) {
	        return root;
	    }

	    for (Node child : root.getChildrenNodes()) {
	        Node foundNode = findNode(child, label);
	        if (foundNode != null) {
	            return foundNode;
	        }
	    }

	    return null;
	}


}
