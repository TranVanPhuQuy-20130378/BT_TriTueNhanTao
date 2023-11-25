// AlphaBetaSearchAlgo class
package BTTH8;

import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int value = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Optimal value: " + value);
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MIN_VALUE;
        for (Node child : node.getChildren()) {
            v = Math.max(v, minValue(child, alpha, beta));
            if (v >= beta) {
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MAX_VALUE;
        for (Node child : node.getChildren()) {
            v = Math.min(v, maxValue(child, alpha, beta));
            if (v <= alpha) {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
