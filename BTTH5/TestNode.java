package BTTH5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        p.readInput("PuzzleMap.txt", "PuzzleGoalState.txt");

        Node initialState = p.getInitialState();
        Node tmp = new Node(initialState);
        System.out.println("Are initial state and its copy equal? " + initialState.equals(tmp));
        Node goalState = p.getGoalState();
        System.out.println("Initial State:");
        System.out.println(initialState);
        System.out.println("Goal State:");
        System.out.println(goalState);

        System.out.println("H: " + initialState.getH());
        System.out.println("White tile position: " + Arrays.toString(initialState.getLocation(0)));
        System.out.println("Goal State:");
        System.out.println(p.getGoalState());
        Node re = p.moveWhiteTile(initialState, 'r');

        System.out.println("After moving right:");
        System.out.println(re);
        System.out.println("H: " + re.getH());
        System.out.println("White tile position after moving right: " + Arrays.toString(re.getLocation(0)));
//
//        System.out.println("Distance between initial and new states: " + p.manhattanDistance(initialState.getLocation(0), re.getLocation(0)));
//        System.out.println("Distance between new and goal states: " + p.manhattanDistance(re.getLocation(0), goalState.getLocation(0)));

        System.out.println("Initial State:");
        System.out.println(p.getInitialState());
        System.out.println("Goal State:");
        System.out.println(p.getGoalState());

        List<Node> children = p.getSuccessors(initialState);
        System.out.println("Number of successors: " + children.size());
        for (Node child : children) {
            System.out.println("H: " + child.getH() + " " + p.computeH2(child));
        }
    }
}
