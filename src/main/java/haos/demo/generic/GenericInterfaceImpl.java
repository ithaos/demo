package haos.demo.generic;

public class GenericInterfaceImpl<D> implements GenericInterface<D> {
    @Override
    public D calc(D param) {
        System.out.println(param);
        return param;
    }
}
