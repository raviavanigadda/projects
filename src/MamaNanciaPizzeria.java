import java.util.Scanner;

public class MamaNanciaPizzeria {
    private static  Scanner sc = new Scanner(System.in); //declaring scanner object as global
    private static int[] todaysPizzas;
    private static int maxPizzas;
    private static int count=3;
    private static int numPizza;
    private static DeluxePizza[] pizzas;

    public static void Welcome(){
        int option;
        System.out.print("\nMama Nancia, what do you want to do?\n\t1.\tEnter a new pizza order (password required)" +
                "\n\t2.\tChange information of a specific order (password required)\n\t" +
                "3.\tDisplay details for all pizzas of a specific size(s/m/l)\n\t" +
                "4.\tStatistics on today's pizzas\n\t" +
                "5.\tQuit\nPlease enter your choice > ");
        option = sc.nextInt();
        order(option);
    }

    public static void order(int opt)
    {
        switch (opt) {
            case 1:
                option1();
                break;
            case 2:
               //option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                //  option4();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("You entered wrong option. Please try again.\n");
                Welcome();
                break;
        }

    }

    public static void option1()
    {
        password(1);


    }

    public static void option3()
    {
        password(3);



    }

    public static void password(int check) {

        String checkPwd = "deluxepizza";
        String inputPwd;

        System.out.print("\nPlease enter the password to get access: ");
        inputPwd = sc.next();

        if (checkPwd.equals(inputPwd)) {
            if(check==1){

                System.out.println("Adding pizza details");
                addPizza();

            }
            else if(check==2){

                System.out.println("Modifying pizza details");

            }
            else if(check==3){
                System.out.println("Display pizza details");
                displayPizza();
            }
        }

        else {
            if (count == 1) {
                System.out.println("Maximum entries done. Returning to main menu....\n");
                count=3; //resets the count value to 3 again.
                Welcome();
            }
            count--;
            System.out.println("Wrong password entered. Only " + count + " chances left. ");
            password(check);
        }

    }


    public static void addPizza() {
        boolean stuffedD;
        int cheese, pepperoni, mushroom,veggies;
        String size,stuffeD;

        System.out.print("\nEnter no of pizzas: ");
        numPizza = sc.nextInt();

        if (numPizza > todaysPizzas.length) {
            System.out.println("Mama Nancia, you have enough ingredients for " + maxPizzas + " pizzas only.");
            System.out.println("Please try again. Thank you.");
            addPizza();
        } else {

           for(int i=0; i <numPizza; i++) {
                System.out.print("\nEnter size of pizza(small/medium/large): ");
                size= sc.next();
                System.out.print("\nEnter no of cheese toppings: ");
                cheese= sc.nextInt();
                System.out.print("\nEnter no of pepperoni toppings: ");
                pepperoni= sc.nextInt();
                System.out.print("\nEnter no of mushroom toppings: ");
                mushroom= sc.nextInt();
                System.out.print("\nEnter no of veggie toppings: ");
                veggies= sc.nextInt();
               // System.out.print("\nDo you want cheese filled dough?(y/n) ");
               // stuffeD= sc.next();

              //  stuffedD = stuffeD.charAt(0) == 'y' || stuffeD.charAt(0) == 'Y';

                pizzas[i].setSize(size);
               pizzas[i].setCheeseTopping(cheese);
               pizzas[i].setPepperoniTopping(pepperoni);
               pizzas[i].setMushroomTopping(mushroom);
               pizzas[i].setVeggieTopping(veggies);
              // pizzas[i].setStuffedWithCheese(stuffedD);

            }

            count=3;
            Welcome();
        }
    }

    public static void displayPizza(){
    int i;

    pizzas[0].getMushroomTopping();
        pizzas[0].getCheeseTopping();
        System.out.println("Checking here");
        for(i=0;i< numPizza;i++){
            pizzas[i].toString(); }
    Welcome();

    }

    public static void main(String[] args) {


        System.out.println("**********Welcome to Mama Nancia Pizzeria**********");
        System.out.print("\nPlease enter maximum number of pizzas for the day: ");
        maxPizzas = sc.nextInt();
        todaysPizzas = new int[maxPizzas]; //creates a array which contains information about pizza objects.
        pizzas = new DeluxePizza[maxPizzas]; //creates objects for total number of pizzas per day.
        //sets the values in array of objects to null
        for(int i =0;i<pizzas.length;i++)
            pizzas[i] = new DeluxePizza();

        Welcome();
    }

}
