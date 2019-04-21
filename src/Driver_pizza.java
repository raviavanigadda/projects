// -----------------------------------------------------
// Assignment 1 Question 2
// Written by: A.Sai Ravi Teja(1895212), M.Pavani(1895730)
// Short Description: Write a driver function for the given pizza class
// -----------------------------------------------------

import java.util.Scanner;
/*
public class Driver_pizza {

    public static void main(String[] args) {
        int cheese, pepperoni, mushroom,check=0;
        String size;
        Scanner sc = new Scanner(System.in);
        //creating objects for the three pizzas
        DeluxePizza p1 = new DeluxePizza();
        DeluxePizza p3 = new DeluxePizza();
        System.out.println("------------------------------------------");
        System.out.println("Welcome to Fancy Nancy's DeluxePizza Shop ....");
        System.out.println("------------------------------------------");

        System.out.println("\nPlease place order for 1st pizza in the following order:");
        System.out.print("Size:small, medium or large? ");
        size = sc.next();
        System.out.println("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom");
        cheese = sc.nextInt();
        pepperoni = sc.nextInt();
        mushroom = sc.nextInt();
        //takes arguments from the user input and send them as parameters to second pizza
        DeluxePizza p2 = new DeluxePizza(size, cheese, pepperoni, mushroom, );

        System.out.println("Please place order for 2nd pizza in the following order:");
        System.out.print("Size:small, medium or large? ");
        size = sc.next();
        p3.setSize(size); //sets the size of third pizza using mutator functions
        System.out.println("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom");
        cheese = sc.nextInt();
        p3.setCheeseTopping(cheese); //sets no of cheese toppings
        pepperoni = sc.nextInt();
        p3.setPepperoniTopping(pepperoni); //sets no of pepperoni toppings
        mushroom = sc.nextInt();
        p3.setMushroomTopping(mushroom); //sets no of mushroom toppings

        //Displays the output of three using toString method
        System.out.println("\nHere are the three pizzas:");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        System.out.println("\nResults of comparisons:");
        //checks for validation and compare the first two pizzas using objects
        while(check!=1) {
            if(p2.getSize().equals(p3.getSize()))
            if (p1.getSize() == p2.getSize()&&p1.getCheeseTopping()==p2.getCheeseTopping()&&
            p1.getMushroomTopping()==p2.getMushroomTopping()&&p1.getPepperoniTopping()==p2.getPepperoniTopping()) {
                System.out.println("Results of comparisons after changing one of the pizzas ....");
                System.out.println("First and second pizza are the same.");
                System.out.println(p2.toString());
                System.out.println("pizza 3: "+p3.toString());
                check =1;
            } else {
                //if pizzas are different, sets the values of first pizza to that of second pizza.
                System.out.println("None of the pizzas are the same\n");
                p1.setSize(p2.getSize());
                p1.setCheeseTopping(p2.getCheeseTopping()); //passes parameter of second pizza to argument of first pizza by getting the required parameter.
                p1.setMushroomTopping(p2.getMushroomTopping());
                p1.setPepperoniTopping(p2.getPepperoniTopping());
            }
        }
        System.out.println("\nEnjoy the pizzas ... Don't forget your TUMS on the way out.");
    }

}*/