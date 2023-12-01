package BTTH9;

public class MinimaxAlgo {
    public void execute(Node node) {
        int v = minValue(node);
        System.out.println("Best Move Pairs: " + v);
    }

    public int maxValue(Node node) {
        if (node.isTerminal()) {
            return node.getUtility();
        }
        int v = Integer.MIN_VALUE;
        for (Node s : node.getSuccessors()) {
            v = Math.max(v, minValue(s));
        }
        return v;
    }

    public int minValue(Node node) {
        if (node.isTerminal()) {
            return node.getUtility();
        }
        int v = Integer.MAX_VALUE;
        for (Node s : node.getSuccessors()) {
            v = Math.min(v, maxValue(s));
        }
        return v;
    }
}
