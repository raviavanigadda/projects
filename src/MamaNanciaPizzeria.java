import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MamaNanciaPizzeria {
    private static  Scanner sc = new Scanner(System.in); //declaring scanner object as global
    private static int[] todaysPizzas;
    private static int maxPizzas;
    private static int count=3;
    private static int numPizza;
    private static int flag =0;
    //creates a list to maintain different pizzas


    public static  List<DeluxePizza> pizzaList = new ArrayList<DeluxePizza>();

    public static void Welcome(){
        int option;
        System.out.print("\nMama Nancia, what do you want to do?\n\t1.\tEnter a new pizza order (password required)" +
                "\n\t2.\tChange information of a specific order (password required)\n\t" +
                "3.\tDisplay details for all pizzas of a specific size(s/m/l)\n\t" +
                "4.\tStatistics on today's pizzas\n\t" +
                "5.\tQuit\n\nPlease enter your choice > ");
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
               option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
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
        //password(1);
        addPizza();
    }

    public  static  void option2()
    {

        //password(2);
        modifyPizza();
    }

    public static void option3()
    {
       // password(3);
        displayPizza();

    }

    public static void option4()
    {
        pizzaStatistics();
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
                modifyPizza();

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
            password(check);
            System.out.println("Wrong password entered. Only " + count + " chances left. ");
        }

    }


    public static void addPizza() {

        String yN;
        System.out.print("\nEnter no of pizzas: ");
        numPizza = sc.nextInt();



        if (numPizza > todaysPizzas.length) {
            System.out.println("Mama Nancia, you have enough ingredients for " + maxPizzas + " pizzas only.");
            System.out.println("Please try again. Thank you.");
            addPizza();
        } else {

           //todaysPizzas = new int[numPizza]; //creates a array which contains information about pizza objects.
           for(int i=1; i <=numPizza; i++) {
               DeluxePizza pizzaToCreate = new DeluxePizza();
            pizzaToCreate.pizzaIndex=i;
            Scanner sizeInput = new Scanner(System.in);
            System.out.print("\nEnter size of pizza(small/medium/large): ");
            pizzaToCreate.size = sizeInput.next();

            Scanner setCheeseInput = new Scanner(System.in);
            System.out.print("\nEnter no of cheese toppings: ");
            pizzaToCreate.cheeseTopping = setCheeseInput.nextInt();


            Scanner setPepperoniInput = new Scanner(System.in);
            System.out.print("\nEnter no of pepperoni toppings: ");
            pizzaToCreate.pepperoniTopping = setPepperoniInput.nextInt();


            Scanner setMushroomInput = new Scanner(System.in);
            System.out.print("\nEnter no of mushroom toppings: ");
            pizzaToCreate.mushroomTopping = setMushroomInput.nextInt();


            Scanner setVeggieInput = new Scanner(System.in);
            System.out.print("\nEnter no of veggie toppings: ");
            pizzaToCreate.veggieTopping = setVeggieInput.nextInt();

            System.out.print("\nDo you want cheese filled dough?(y/n) ");
            yN = sc.next();
               if (yN.equalsIgnoreCase("Y")||yN.equalsIgnoreCase("y"))
               {
                   pizzaToCreate.stuffedWithCheese = true;
               }
               else
               {
                   pizzaToCreate.stuffedWithCheese = false;
               }
              //pizzaToCreate.stuffedWithCheese = setDoughInput.nextBoolean();

            pizzaList.add(pizzaToCreate);

            }
            System.out.println("\nPizza's information has been stored. Thank you.");
            count=3;
            Welcome();
        }
    }

    public static void modifyPizza(){
         int modPizzaIndex, opt;
         System.out.println("\nDisplaying Pizzas\n");
        for(DeluxePizza pizza: pizzaList)
        {   System.out.println("Pizza "+pizzaList.indexOf(pizza));
            System.out.println(pizza);  // Will invoke `toString()` method
           //System.out.println("Price: $"+pizza.calcCost());
            System.out.println(" ");

        }
        System.out.print("\nWhich pizza you want to change? : ");
        modPizzaIndex = sc.nextInt()-1;

        if((modPizzaIndex+1)>maxPizzas) {
            System.out.println("\nSorry Mama Nancy. You have enough ingredients for " + maxPizzas + " pizzas only.");
            System.out.println("\nGoing back to Modify Menu....");
            modifyPizza();
        }        else {
            flag = 0;
        }
        for(DeluxePizza pizza: pizzaList) {
            if (modPizzaIndex==pizzaList.indexOf(pizza)) {

                System.out.print("\nMama Nancia, what would you like to change?\n" +
                        "1.\tSize\n" +
                        "2.\tCheese filled or not\n" +
                        "3.\tNumber of cheese toppings\n" +
                        "4.\tNumber of pepperoni toppings\n" +
                        "5.\tNumber of mushroom toppings\n" +
                        "6.\tNumber of vegetable toppings\n" +
                        "7.\tQuit Enter choice >");
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        String size;
                        System.out.print("\nEnter the new size: ");
                        size = sc.next();
                        pizzaList.get(modPizzaIndex).size = size;
                        break;
                    case 2:
                        String cheeseFill;
                        System.out.print("\nEnter your option for cheese fill: ");
                        cheeseFill = sc.next();
                        if (cheeseFill.equalsIgnoreCase("Y")||cheeseFill.equalsIgnoreCase("y"))
                        {
                            pizzaList.get(modPizzaIndex).stuffedWithCheese = true;
                        }
                        else
                        {
                            pizzaList.get(modPizzaIndex).stuffedWithCheese = false;
                        }
                        break;
                    case 3:
                        int cheeseT;
                        System.out.print("\nEnter the cheese toppings: ");
                        cheeseT = sc.nextInt();
                        pizzaList.get(modPizzaIndex).cheeseTopping = cheeseT;
                        break;
                    case 4:
                        int pepperoniT;
                        System.out.print("\nEnter the pepperoni toppings: ");
                        pepperoniT = sc.nextInt();
                        pizzaList.get(modPizzaIndex).pepperoniTopping = pepperoniT;
                        break;
                    case 5:
                        int mushroomT;
                        System.out.print("\nEnter the mushroom toppings: ");
                        mushroomT = sc.nextInt();
                        pizzaList.get(modPizzaIndex).mushroomTopping = mushroomT;
                        break;
                    case 6:
                        int vegT;
                        System.out.print("\nEnter the vegetable toppings: ");
                        vegT = sc.nextInt();
                        pizzaList.get(modPizzaIndex).veggieTopping = vegT;
                        break;
                    case 7:
                        Welcome();
                        break;
                    default:
                        break;
                }
                flag=1;
            }
            }
        if(flag==0) {
            String ch;
            System.out.print("\nPizza is not found. Do you want to add one?(Y/N): ");
            ch = sc.next();
            if (ch.equalsIgnoreCase("Y")||ch.equalsIgnoreCase("y")) {
                flag=3;
             addPizza();
            }else
                Welcome();
        }
         else if(flag==1) {
                System.out.println("\nPizza is modified. Use display function to view the pizzas. Thank you.");
                Welcome();
        }
    }

    public static void displayPizza(){
      String searchSize; int cnt=0,index=0;
      System.out.print("\nPlease enter pizza size to search: ");
      searchSize = sc.next();

        for(DeluxePizza pizza: pizzaList) {
            if(pizza.getSize().equals(searchSize))
            {   cnt = cnt+1;
                System.out.println("\nPizza "+pizzaList.indexOf(pizza));
                System.out.println(pizza);  // Will invoke overrided `toString()` method
                System.out.println(" ");
                index=1;
             }else{
                index=0;
            }      }
        if(index==1)
            System.out.println("\nTotal no of pizzas of same size: "+count);
        else
            System.out.println("\nThere are no pizzas of size "+searchSize);
    Welcome();
}

    public static void pizzaStatistics(){
        int choice,i =0;
        int[] arrPrice = new int[maxPizzas];
        System.out.print("\nMama Nancia, what information would you like?\n" +
                "1.\tCost and details of cheapest pizza\n" +
                "2.\tCost and details of most costly pizza\n" +
                "3.\tNumber of pizzas sold today\n" +
                "4.\tNumber of pizzas of a specific size\n" +
                "5.\tAverage cost of pizzas\n" +
                "6.\tQuit\nEnter your choice: ");
        choice=sc.nextInt();
        switch(choice){
            case 1:for(DeluxePizza pizza: pizzaList){
                while(i<pizzaList.size())
                {
                    arrPrice[i] = pizza.calcCost();
                    i++;
                }
            }
            for(i=0;i<maxPizzas;i++)
                System.out.println(arrPrice[i]);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Returning back to main menu...");
                Welcome();
                break;
            default:
                break;
        }

        System.out.println("Returning back to menu...");
        pizzaStatistics();
    }

    public static void main(String[] args) {
System.out.println("\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("**********Welcome to MAMA NANCIA's PIZZERIA**********");
        System.out.println("-----------------------------------------------------");
        System.out.print("\nMama Nancia, How many pizzas do you want to make today? : ");
        maxPizzas = sc.nextInt();
        todaysPizzas = new int[maxPizzas];
        Welcome();
    }

}
