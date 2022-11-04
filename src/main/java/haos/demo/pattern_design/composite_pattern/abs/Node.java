package haos.demo.pattern_design.composite_pattern.abs;

/**
 * 容器、叶子的抽象类
 */
public abstract class Node {

    protected String name;

    public abstract void display();

    public Node(String name) {
        this.name = name;
    }
}
