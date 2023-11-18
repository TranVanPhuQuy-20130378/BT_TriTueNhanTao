// Class 3
package BTTH7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueen {
    public static final int POP_SIZE = 100;// Population size
    public static final double MUTATION_RATE = 0.03;
    public static final int MAX_ITERATIONS = 1000;
    List<Node> population = new ArrayList<Node>();
    Random rd = new Random();

 
    public void initPopulation() {
        for (int i = 0; i < POP_SIZE; i++) {
            Node ni = new Node();
            ni.generateBoard();
            population.add(ni);
        }
    }

    public Node execute() {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            List<Node> newPopulation = new ArrayList<Node>();

           
            Collections.sort(population);
            newPopulation.add(population.get(0));

            
            while (newPopulation.size() < POP_SIZE) {
                Node parent1 = getParentByTournamentSelection();
                Node parent2 = getParentByTournamentSelection();

                Node child = reproduce(parent1, parent2);

                if (Math.random() < MUTATION_RATE) {
                    mutate(child);
                }

                newPopulation.add(child);
            }

            population = newPopulation;
        }

        
        Collections.sort(population);
        return population.get(0);
    }

    public void mutate(Node node) {
        int queenIndex = rd.nextInt(Node.N);
        int newRow = rd.nextInt(Node.N);
        node.setRow(queenIndex, newRow);
    }

    
    public Node reproduce(Node x, Node y) {
        int crossoverPoint = rd.nextInt(Node.N);
        

        Queen[] childState = new Queen[Node.N];
        for (int i = 0; i < crossoverPoint; i++) {
            childState[i] = new Queen(x.getRow(i), x.getState()[i].getColumn());
        }
        for (int i = crossoverPoint; i < Node.N; i++) {
            childState[i] = new Queen(y.getRow(i), y.getState()[i].getColumn());
        }

        return new Node(childState);
    }

    
    public Node getParentByTournamentSelection() {
        int tournamentSize = 5;
        List<Node> tournamentParticipants = new ArrayList<Node>();

        for (int i = 0; i < tournamentSize; i++) {
            tournamentParticipants.add(population.get(rd.nextInt(POP_SIZE)));
        }

        Collections.sort(tournamentParticipants);
        return tournamentParticipants.get(0);
    }

    
    public Node getParentByRandomSelection() {
        return population.get(rd.nextInt(POP_SIZE));
    }

    // Test class
    public static void main(String[] args) {
        GA_NQueen ga = new GA_NQueen();
        ga.initPopulation();

        Node solution = ga.execute();

        System.out.println("Solution Board:");
        solution.displayBoard();
        System.out.println("Solution Heuristic: " + solution.getH());
    }
}
