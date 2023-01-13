package haos.demo.generic;

public class GenericFunc {
    public static <R> R genericFunc(GenericClass<R> r){
        System.out.println(r);
        return r.getThings();
    }

    public static <T> void printMsg(T... args){
        for(T t : args){
            System.out.println(t);
        }
    }
}
