// -----------------------------------------------------
// Project Metro
// Written by: Sai Ravi Teja A(1895212), M.Pavani
// which controls a metro train and that keeps track of stations and who gets on and off.
// -----------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Metro extends train {

    private static int i,c, flag;
    private static int metroStations, capacity = 300;
    private static int NewPassengers;
    private static int WaitPassengers;
    private static int gotoff;
    private static int goton;
    private static int stationIndex = 0;
private  static String[] metroInfo;

    private static String Direction = "east";

    public static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.print("\nWelcome to Metro Manager - Enjoy your metro experience" +
                "\n -----------------------------------------");
        welcome();
    }

    public static void welcome() {

        System.out.print("\nEnter number of metro stations(minimum 3): ");
        metroStations = sc.nextInt();
        metroInfo = new String[metroStations];
        //repeat till user enters atleast 3 stations
        while (metroStations < 3) {
            System.out.println("Please enter atleast 3 stations.");
            welcome();
        }


        //Adds metro station names and number to the metro list
        for (int i = 0; i < metroStations; i++) {

            System.out.print("Enter the station name: ");
            metroInfo[i] = sc.next();

        }
        System.out.println("\nThis Metro line has " + metroStations + " stations. From the direction \"east\" to \"west\"");
        System.out.println("---------------------------------------------------------------");
        flag = 0; //sets direction from starting
        nextStation(flag);
    }

    //

    public static void setStation(int x, int y, int flag) {

        //Starting station
        if (flag == 0 || flag ==3) {
            i=0;
            System.out.println("\nOnly in\n(New Passengers waiting " + x + ")");
            System.out.println("(Passengers left from last time " + y + ")");
            System.out.println("-------------------");
            System.out.println("Metro " + metroID + "(new Train) leaving station " + (stationIndex + 1) +" "+ metroInfo[i]+" "+ Direction
                    + " bound with " + NewPassengers + " passengers(s).");
            stationIndex++;
            i++;

        }
        //middle stations
        else if (flag == 1) {
            System.out.println("\nIn the middle");
            System.out.println("(Passengers left from last time " + y + ")");
            System.out.println("-------------------");
            stationIndex++;

        }
        //last station
        else if (flag == 2) {
            System.out.println("\nAll out");
            System.out.println("-------------------");
            flag = 3;
            stationIndex =0;
        }

    }

    public static void nextStation(int flag) {
        //flag==0 because the application is initialized and starting from station1.
        if (flag == 0 || flag == 3) {
            NewPassengers = train.randomNumber(1, 0);
            WaitPassengers = 0;
            setStation(NewPassengers, WaitPassengers, flag);
            gotoff = 0;
            goton = NewPassengers;
        } else if (flag == 1) {

            NewPassengers = train.randomNumber(1, 0);
            gotoff = capacity - randomNumber(2, goton);

            WaitPassengers = NewPassengers - gotoff;
            if(WaitPassengers < 0)
                WaitPassengers = (-1) * WaitPassengers;
            setStation(NewPassengers, WaitPassengers, flag);


            goton = NewPassengers;
            System.out.println("Metro " + metroID + " leaving station " + stationIndex +" "+ metroInfo[i]+" "+ Direction
                    +" bound with " + NewPassengers + " passengers(s).");
            i++;
        } else if (flag == 2) {
            //NewPassengers = train.randomNumber(1, 0);
            setStation(NewPassengers, WaitPassengers, flag);
            //getPassengerDetails(NewPassengers,WaitPassengers,flag);
            gotoff = NewPassengers;
            NewPassengers = 0;
            goton = 0;
            WaitPassengers = 0;
            flag=3;
            System.out.println("Metro " + metroID + " leaving station " + stationIndex +" "+ metroInfo[i]+" "+ Direction
                    +" bound with " + NewPassengers + " passengers(s).");
            Direction = "west";
            i=0;

        }
        System.out.println("Passenger(s) got off: " + gotoff +
                "\nPassenger(s) new passengers waiting to board: " + NewPassengers +
                "\nPassenger(s) got on: " + goton +
                "\nPassenger(s) left behind waiting for next train: " + WaitPassengers);

        repeat();
    }

    public static void repeat() {
        String ch;
        //System.out.println(metroStations);
        //System.out.println(c);

        System.out.print("\nDo you want to continue following Metro train " + metroID + " ?");
        System.out.print("\nType \"y\" or \"Y\" for yes, anything else for no: ");
        ch = sc.next();
        if (ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y")) {
            if (flag == 2)
                flag = 0;
            else
                flag = 1;
            c++;
            if (c == (metroStations)) {
                flag = 2;
                c = 0;
            }
            nextStation(flag);

        } else
            System.exit(0);

    }

}