// -----------------------------------------------------
// Project Metro
// Written by: Sai Ravi Teja A(1895212), M.Pavani
// which controls a metro train and that keeps track of stations and who gets on and off.
// -----------------------------------------------------

import  java.util.Scanner;
public class Metro {

 private static int flag=1;
 private static int metroStn;
public static train tob;
 public static Scanner sc = new Scanner(System.in);
int [][]arrTrack;
    public static void main(String[] args) {
        System.out.print("\nWelcome to Metro Manager - Enjoy your metro experience" +
                "\n -----------------------------------------");
    welcome();
    }

 public static void welcome(){

     System.out.print("\nEnter number of metro stations(minimum 3): ");
     metroStn = sc.nextInt();
     while (metroStn<3)
     {
         System.out.println("Please enter atleast 3 stations.");
         welcome();

     }

     System.out.println("\nThis Metro line has "+ metroStn +" stations.");
     System.out.println("---------------------------------------------------------------");
     nextStation();
 }

    public static void nextStation(){


        //System.exit(0);

    }
}
