public abstract class Dog implements Animal, Pet{

    public String name;

    public Dog(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("A dog is chasing a frisbee.");
    }

    public void sleep(){
        System.out.println("Dogs usually sleep between 12 and 14 hours a day.");
    }

    public void food(){
        System.out.println("Bones");
    }

    public void sound(){
        System.out.println("Woof");
    }

    public String favoritePetToy(){
        return "frisbee";
    }

}