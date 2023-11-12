package BTTH6.student;


public class Test {
    public static void main(String[] args) {
        
        Node node = new Node();
        node.generateBoard();
        System.out.println("Initial Board:");
        node.displayBoard();
        System.out.println("Heuristic Value: " + node.getH());


        System.out.println("\nAll Candidates:");
        for (Node candidate : node.generateAllCandidates()) {
            candidate.displayBoard();
            System.out.println("Heuristic Value: " + candidate.getH() + "\n");
        }

       
        System.out.println("Random Candidate:");
        Node randomCandidate = node.selectNextRandomCandidate();
        randomCandidate.displayBoard();
        System.out.println("Heuristic Value: " + randomCandidate.getH());
    }
}
