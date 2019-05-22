import java.util.Random;
import java.util.Scanner;

public class train {

    public static int metroID;

    public static String stationName;
    public static int direction; //1 for left, 0 for right
    public static int passtotal; //no of passengers currrently on train


    public int getMetroID() {
        return metroID;
    }

    public void setMetroID(int metroID) {
        this.metroID = metroID;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public  int getPasstotal() {
        return passtotal;
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public  void setPasstotal(int passtotal) {
        this.passtotal = passtotal;
    }

    //randuom number generator function
    public static int randomNumber(int x,int y) {
        int randomInt;

        Random randomGenerator = new Random();
        if(x==0) {
            randomInt = randomGenerator.nextInt(1000) + 1;
        }
        else if(x==2)
        {
            randomInt = randomGenerator.nextInt(y) + 1;
        }
        else{
            randomInt = randomGenerator.nextInt(300) + 1;
        }
        return randomInt;
    }

    //default constructor
    public train() {
        metroID = randomNumber(0,0);
        direction = 0 ;
        passtotal = 0;
    }

    //constructor with one parameter. only changes the metroID.
    public train(int metro_ID) {
        metro_ID = this.metroID;
        direction = passtotal = 0;
    }


    @Override
    public String toString() {
        return "train{" +
                "metroID=" + metroID +
                ", stationName='" + stationName + '\'' +
                ", direction=" + direction +
                ", passtotal=" + passtotal +
                '}';
    }

    public boolean equals(train t)
    {
        return passtotal == t.passtotal;
    }

}