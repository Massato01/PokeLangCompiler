package Syntactic.GLC;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String data;
    public List<Node> children;
    public String enter;
    public String exit;

    public Node(String data) {
        this.data = data;
        this.children = new ArrayList<>();
        this.enter = "";
        this.exit = "";
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public Node addChild(String data) {
        Node child = new Node(data);
        children.add(child);
        return child;
    }

    public List<Node> getChildren(){
        return children;
    }

    public boolean IsLeaf(){
        return children.size() == 0;
    }
}
