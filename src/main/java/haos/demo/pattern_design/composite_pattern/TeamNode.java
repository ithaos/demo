package haos.demo.pattern_design.composite_pattern;

import haos.demo.pattern_design.composite_pattern.abs.Node;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TeamNode extends Node {

    List<Node> childColl;

    @Override
    public void display() {
        System.out.println("团队:" + this.name);
        childColl.forEach(child -> child.display());
        System.out.println("\n");
    }

    void add(Node node) {
        childColl.add(node);
    }

    void del(Node node) {
        childColl.remove(node);
    }

    public TeamNode(String name) {
        super(name);
        childColl = new ArrayList();
    }
}
