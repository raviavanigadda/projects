// -----------------------------------------------------
// Project Metro
// Written by: Sai Ravi Teja A(1895212), M.Pavani
// which controls a metro train and that keeps track of stations and who gets on and off.
// -----------------------------------------------------


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;


public class Metro extends train {

    private static int i = 0, c, flag;
    private static int metroStations, capacity = 300;
    private static int NewPassengers;
    private static int WaitPassengers;
    private static int gotoff;
    private static int goton;
    private static int stationIndex = 0;
    private static String[] metroInfo;
    private static String Direction = "east";
    private static String trains[] = {
            "Angrignon",
            "LaSalle",
            "Peel",
            "Beaudry",
            "Pie-IX",
            "Côte-Vertu",
            "Côte-Sainte-Catherine",
            "Georges-Vanier"
    };
    public static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.println("\t\t\t\t  _-====-__-======-__-========-_____-============-__\n" +
                "               _(                                                   _)\n" +
                "            OO(                                                      _)\n" +
                "           0  (_ Welcome to Metro Manager - Enjoy your metro journey_)\n" +
                "         o0     (_                                                _)\n" +
                "        o         '=-___-===-_____-========-___________-===-----='\n" +
                "      .o                                _________\n" +
                "     . ______          ______________  |         |      _____\n" +
                "   _()_||__|| ________ |            |  |_________|   __||___||__\n" +
                "  (MONT 2019| |      | |            | __Y______00_| |_         _|\n" +
                " /-OO----OO\"\"=\"OO--OO\"=\"OO--------OO\"=\"OO-------OO\"=\"OO-------OO\"==\n" +
                "#####################################################################\n");
        mainMenu();
    }


    public static void welcome(int x) {
        if (x != 1) {
            System.out.print("\nEnter number of metro stations(minimum 3): ");
            metroStations = sc.nextInt();
            metroID = randomNumber(0, 0);
            metroInfo = new String[metroStations];
            //repeat till user enters atleast 3 stations
        } else {

            metroStations = trains.length;
            metroID = randomNumber(0, 0);
            metroInfo = new String[trains.length + 1];
            for (i = 0; i < trains.length; i++) {
                metroInfo[i] = trains[i];
            }
        }
        while (metroStations < 3) {
            System.out.println("Please enter atleast 3 stations.");
            welcome(0);
        }

        //Adds metro station names and number to the metro list
        if (x != 1) {
            for (int i = 0; i < metroStations; i++) {

                System.out.print("Enter the station name: ");
                metroInfo[i] = sc.next();
            }
        }
        System.out.println("\nThis Metro line has " + metroStations + " stations. From the direction \"east\" to \"west\"");
        System.out.println("#####################################################################");
        flag = 0; //sets direction from starting
        nextStation(flag);
    }

    //show time on arrival
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static void displayTime() {
        System.out.println("Metro arrived the station at: " + getCurrentTimeStamp());
    }

    public static void displayTrain(String stationName) {
        System.out.println("   _____                 . . . . . o o o o o\n" +
                "  __|[_]|__ ___" + stationName + "________ _______    ____      o\n" +
                " |[] [] []| [] [] [] [] [_____(__  ][]]_n_n__][.\n" +
                "_|________|_[_________]_[________]_|__|________)<\n" +
                "  oo    oo 'oo      oo ' oo    oo 'oo 0000---oo\\_\n" +
                " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void setStation(int x, int y, int flag, String metroInfo) {

        //Starting station
        if (flag == 0 || flag == 3) {
            System.out.println("\nOnly in\n(New Passengers waiting " + x + ")");
            System.out.println("(Passengers left from last time " + y + ")");
            System.out.println("#####################################################################");
            displayTime();
            displayTrain(metroInfo);
        }
        //middle stations
        else if (flag == 1) {
            System.out.println("\nIn the middle");
            System.out.println("(Passengers left from last time " + y + ")");
            System.out.println("#####################################################################");
            displayTime();
            displayTrain(metroInfo);
        }
        //last station
        else if (flag == 2) {
            System.out.println("\nAll out");
            System.out.println("#####################################################################");
            displayTime();
            displayTrain(metroInfo);
        }

    }

    public static void nextStation(int flag) {
        //flag==0 because the application is initialized and starting from station1.
        if (flag == 0 || flag == 3) {
            i = 0;
            NewPassengers = train.randomNumber(1, 0);
            WaitPassengers = 0;
            setStation(NewPassengers, WaitPassengers, flag, metroInfo[i]);
            gotoff = 0;
            goton = NewPassengers;
            System.out.println("Metro " + metroID + "(new Train) leaving station " + (stationIndex + 1) + " " + metroInfo[i] + " " + Direction +
                    " bound with " + NewPassengers + " passengers(s).");

            stationIndex++;

        } else if (flag == 1) {

            NewPassengers = train.randomNumber(1, 0);
            gotoff = capacity - randomNumber(2, goton);

            WaitPassengers = NewPassengers - gotoff;
            if (WaitPassengers < 0)
                WaitPassengers = (-1) * WaitPassengers;
            setStation(NewPassengers, WaitPassengers, flag, metroInfo[i]);
            goton = NewPassengers;
            System.out.println("Metro " + metroID + " leaving station " + (stationIndex + 1) + " " + metroInfo[i] + " " + Direction +
                    " bound with " + NewPassengers + " passengers(s).");
            stationIndex++;


        } else if (flag == 2) {
            setStation(NewPassengers, WaitPassengers, flag, metroInfo[i]);
            gotoff = NewPassengers;
            NewPassengers = 0;
            goton = 0;
            WaitPassengers = 0;
            Direction = "west";
            System.out.println("Metro " + metroID + " leaving station " + (stationIndex + 1) + " " + metroInfo[i] + " " + Direction +
                    " bound with " + NewPassengers + " passengers(s).");
            System.out.println("Metrowill reach the starting station again. Please proceed for future actions");
            stationIndex = 0;

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
            if (flag == 2) {
                flag = 0;
                i = 0;
            } else {
                flag = 1;
                if (i == metroStations - 1)
                    flag = 2;
                i++;
            }

            c++;
            if (c == (metroStations)) {
                flag = 2;
                c = 0;
                i = metroStations - 1;
            }
            nextStation(flag);

        } else {
            System.out.println("O o\n" +
                    "    .\n" +
                    "   __\n" +
                    "  _||_\n" +
                    "  ||||\n" +
                    " .----.\n" +
                    " |o<>o|\n" +
                    "////\\\\\\\\\n" +
                    "  /--\\   - Thanks for using our application...@RT & @PA-\n" +
                    " /----\\");
            System.exit(0);
        }
    }

    public static void repeatMenu() {
        String ch;
        //System.out.println(metroStations);
        //System.out.println(c);

        System.out.print("\nDo you want to continue the program ? ");
        System.out.print("\nType \"y\" or \"Y\" for yes, anything else for no: ");
        ch = sc.next();
        if (ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y")) {
            System.out.println("");
            mainMenu();

        } else {
            System.out.println("\nHappy Journey");
            System.out.println("O o\n" +
                    "    .\n" +
                    "   __\n" +
                    "  _||_\n" +
                    "  ||||\n" +
                    " .----.\n" +
                    " |o<>o|\n" +
                    "////\\\\\\\\\n" +
                    "  /--\\   - Thanks for using our metro application...@RT & @PA-\n" +
                    " /----\\");
            System.exit(0);
        }
    }

    public static void mainMenu() {
        int x;
        System.out.print("1.Travel throught the default list of stations with time stamps\n" +
                "2.Display the list of stations available\n" +
                "3.Travel throught a custom list of stations\n" +
                "4.Exit" +
                "\n\nPlease select an option to proceed: ");
        x = sc.nextInt();
        switch (x) {
            case 1:
                welcome(1);
                repeatMenu();
                break;
            case 2:

                for (i = 0; i < trains.length; i++) {
                    System.out.println("Station " + (i + 1) + ": " + trains[i]);
                }
                repeatMenu();
                break;
            case 3:
                welcome(0);
                repeatMenu();
                break;
            case 4:
                break;
        }
    }
}