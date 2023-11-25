// MiniMaxSearchAlgo class
package BTTH8;

public class MiniMaxSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int value = maxValue(node);
        System.out.println("Optimal value: " + value);
    }

    public int maxValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MIN_VALUE;
        for (Node child : node.getChildren()) {
            v = Math.max(v, minValue(child));
        }
        return v;
    }

    public int minValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MAX_VALUE;
        for (Node child : node.getChildren()) {
            v = Math.min(v, maxValue(child));
        }
        return v;
    }
}
