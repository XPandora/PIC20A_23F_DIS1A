public class Samoyed extends Dog implements Pet{

    public int age;

    public Samoyed(int age, String name){
        super(name);
        this.age = age;
    }

    public String toString(){
        return "(Samoyed) Name: " + name + ", Age: " + age;
    }

    public void furColor(){
        System.out.println("White.");
    }

    public void whereFrom(){
        System.out.println("Siberia.");
        
    }

    public void feature(){
        System.out.println("Always smiling.");
    }

    public void nameOrigin(){
        System.out.println("Samoyed dog takes its name from the Samoyedic peoples of Siberia");
    }

    


}