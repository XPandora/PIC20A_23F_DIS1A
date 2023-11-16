public class PersianCat extends Cat implements Pet{

    public int age;

    public PersianCat(int age, String name){
        super(name);
        this.age = age;
    }

    public String toString(){
        return "(Persian cat) Name: " + name + ", Age: " + age;
    }

    public void furColor(){
        System.out.println("Many different colors.");
    }

    public void whereFrom(){
        System.out.println("Khorasan (eastern region in the Iranian Plateau).");
        
    }

    public void feature(){
        System.out.println("Long-haired");
    }


}