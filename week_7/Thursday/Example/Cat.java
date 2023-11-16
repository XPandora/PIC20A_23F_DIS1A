public abstract class Cat implements Animal, Pet{

    public String name;

    public Cat(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("A cat is chasing a mouse.");
    }

    public void sleep(){
        System.out.println("Cats usually sleep between 12 and 18 hours a day.");
    }

    public void food(){
        System.out.println("Fish");
    }

    public void sound(){
        System.out.println("Meow");
    }

    public String favoritePetToy(){
        return "yarn ball";
    }

}