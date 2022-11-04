package haos.demo.pattern_design.composite_pattern;

import haos.demo.pattern_design.composite_pattern.abs.Node;

public class PersonNode extends Node {
    @Override
    public void display() {
        System.out.println("我是" + name);
    }

    public PersonNode(String name) {
        super(name);
    }
}
