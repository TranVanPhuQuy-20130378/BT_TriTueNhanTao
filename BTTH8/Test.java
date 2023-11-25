
package BTTH8;

public class Test {

    public static void main(String[] args) {
        Node root = buildTree(); 

        // Test AlphaBetaSearchAlgo
        System.out.println("Alpha-Beta Pruning:");
        ISearchAlgo alphaBetaSearch = new AlphaBetaSearchAlgo();
        alphaBetaSearch.execute(root);

        // Test MiniMaxSearchAlgo
        System.out.println("\nMinimax Search:");
        ISearchAlgo miniMaxSearch = new MiniMaxSearchAlgo();
        miniMaxSearch.execute(root);
    }

    private static Node buildTree() {
        
        Node root = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E",3);
        Node f= new Node("F",12);
        
        Node  g= new Node("G",8);
        Node h= new Node("H",2);
        Node i = new Node("I",4);
        Node j = new Node("J", 8);
        Node k= new Node("K",14);
        
        Node l = new Node("L",5);
        Node m = new Node("M",2);
       
        
        

        root.addChild(b);
        root.addChild(c);
        root.addChild(d);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        c.addChild(h);
        c.addChild(i);
        c.addChild(j);
        d.addChild(k);
        d.addChild(l);
        d.addChild(m);
        

        return root;
    }
}
