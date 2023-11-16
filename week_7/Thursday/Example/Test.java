public class Test{
    public static void main(String[] args){
        
        PersianCat myKitten = new PersianCat(2, "Kitten");
        Samoyed myPuppy = new Samoyed(4, "Puppy");
        
        Animal[] listOfAnimals = new Animal[] {myKitten, myPuppy};
        
        Cat cat = myKitten;
        Dog dog = myPuppy;

        Pet[] listOfPets = new Pet[] {myKitten, myPuppy};

        System.out.println(myKitten);
        System.out.println(myPuppy);

        // You may check the topic on "Object class" for the reason
        // why you can call toString method which seems not defined 
        // in Cat or Dog classes.
        System.out.println(cat);
        System.out.println(dog);

        cat.sound();
        dog.sound();

        // dog.nameOrigin();  // cannot call

        ((Samoyed) dog).nameOrigin();

        listOfAnimals[0].whereFrom();
        listOfAnimals[1].whereFrom();

        // listOfAnimals[0].furcolor();  // cannot call
        // listOfAnimals[1].furcolor();  // cannot call


        // Try more methods on your own...




        

    }

}