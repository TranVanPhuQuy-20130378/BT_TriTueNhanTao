package BTTH9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private List<Integer> data = new ArrayList<Integer>();

    public void add(Integer val) {
        this.data.add(val);
    }

    public void addAll(List<Integer> data) {
        this.data.addAll(data);
    }

    public List<Node> getSuccessors() {
        List<Node> successors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 1; j <= data.get(i) / 2; j++) {
                int remaining = data.get(i) - j;
                Node child = new Node();
                List<Integer> childData = new ArrayList<>(data);
                childData.set(i, remaining);
                childData.add(j);
                child.addAll(childData);
                successors.add(child);
            }
        }
        return successors;
    }

    public boolean isTerminal() {
        for (Integer val : data) {
            if (val > 1) {
                return false;
            }
        }
        return true;
    }

    public int getUtility() {
        if (isTerminal()) {
            return 1; // MAX wins
        }
        return 0; // MIN wins
    }

    public List<String> getMovePairs() {
        List<String> movePairs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 1; j <= data.get(i) / 2; j++) {
                int remaining = data.get(i) - j;
                String movePair = "(" + remaining + ", " + j + ")";
                movePairs.add(movePair);
            }
        }
        return movePairs;
    }

    public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    @Override
    public String toString() {
        Collections.sort(this.data, DESCOMPARATOR);
        return this.data.toString();
    }
}
