package haos.demo.pattern_design.composite_pattern;


/**
 * 组合模式
 * 适用于组织结构类型的数据结构
 */
public class Client {
    public static void main(String[] args) {
        TeamNode zr = new TeamNode("zr");

        PersonNode zky = new PersonNode("zky");
        PersonNode dgq = new PersonNode("dgq");
        TeamNode jc = new TeamNode("JC");

        zr.add(zky);
        zr.add(dgq);
        zr.add(jc);

        PersonNode zl = new PersonNode("zl");
        PersonNode lsb = new PersonNode("lsb");

        jc.add(zl);
        jc.add(lsb);


        zr.display();
    }
}
