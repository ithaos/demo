package haos.demo.generic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //GenericFunc.genericFunc(new GenericClass<>("999"));
        //GenericFunc.printMsg("zhang",2,"w",3,"y","zzzz");
        //genericClassTest();
        //genericInterfaceTest();
    }

    static void genericClassTest(){
        GenericClass<Integer> one = new GenericClass<>(123);
        System.out.println(one.getThings());

        GenericClass<Boolean> two = new GenericClass<Boolean>();
        System.out.println(two.getThings());

    }

    static void genericInterfaceTest(){
        GenericInterfaceImpl<Integer> impl = new GenericInterfaceImpl<>();
        impl.calc(9999);
    }

}
