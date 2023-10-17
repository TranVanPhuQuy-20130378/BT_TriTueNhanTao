package BTTH2;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A"); 
        Node nodeB = new Node("B");
        Node nodeC = new Node("C"); 
        Node nodeD = new Node("D");
        Node nodeE = new Node("E"); 
        Node nodeF = new Node("F");
        Node nodeG = new Node("G"); 
        Node nodeH = new Node("H");
        
        nodeS.addEdge(nodeA, 5); 
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4); 
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4); 
        nodeB.addEdge(nodeG, 6);
        
        nodeC.addEdge(nodeF, 2); 
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6); 
        nodeF.addEdge(nodeG, 1);
        
        ISearchAlgo algo1 = new BFS();
        ISearchAlgo algo2= new UniformCostSearch();

        // Chọn nút gốc là "nodeS" và nút mục tiêu là "nodeG"
        Node result = algo1.execute(nodeS,"G");
        Node result1 = algo2.execute(nodeA, "G");
        
        // In kết quả tìm kiếm
        if (result != null) {
            System.out.println("Tìm thấy nút đích: " + result.getLabel());
            
            // In đường đi từ nút gốc đến nút đích
            List<Node> path = result.getPath();
            System.out.print("Đường đi: ");
            for (Node node : path) {
                System.out.print(node.getLabel() + " -> ");
            }
            System.out.println("Kết thúc");
        } else {
            System.out.println("Không tìm thấy nút đích.");
        }
    }
}
