
package BTTH7;

public class Test {
    public static void main(String[] args) {
        // Test Node class
        Node initialNode = new Node();
        System.out.println("Initial Board:");
        initialNode.displayBoard();
        System.out.println("Initial Heuristic: " + initialNode.getH());

        Node bestCandidate = initialNode.getBestCandidate();
        System.out.println("\nBest Candidate Board:");
        bestCandidate.displayBoard();
        System.out.println("Best Candidate Heuristic: " + bestCandidate.getH());

        Node randomCandidate = initialNode.selectNextRandomCandidate();
        System.out.println("\nRandom Candidate Board:");
        randomCandidate.displayBoard();
        System.out.println("Random Candidate Heuristic: " + randomCandidate.getH());

        // Test Queen class
        Queen queen1 = new Queen(0, 0);
        Queen queen2 = new Queen(1, 1);

        System.out.println("\nQueen 1: " + queen1);
        System.out.println("Queen 2: " + queen2);

        System.out.println("Is Conflict: " + queen1.isConflict(queen2));

        // Test GA_NQueen class
        GA_NQueen ga = new GA_NQueen();
        ga.initPopulation();

        Node solution = ga.execute();

        System.out.println("\nSolution Board:");
        solution.displayBoard();
        System.out.println("Solution Heuristic: " + solution.getH());
    }
}
