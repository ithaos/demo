package haos.demo.spring_event;


public class MyModel {
    private String name;

    public MyModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHi(){
        System.out.println("Hi~ Go");
    }
}
