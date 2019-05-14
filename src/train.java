import java.util.Random;
import java.util.Scanner;

public class train {

    public int metroID;
    public int stationNum;
    public int direction; //1 for left, 0 for right
    public int passtotal; //no of passengers currrently on train


    public int getMetroID() {
        return metroID;
    }

    public void setMetroID(int metroID) {
        this.metroID = metroID;
    }

    public  int getStationNum() {
        return stationNum;
    }

    public  void setStationNum(int stationNum) {
        this.stationNum = stationNum;
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

    public  void setPasstotal(int passtotal) {
        this.passtotal = passtotal;
    }

    //randuom number generator function
    public static int randomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000) + 1;
        return randomInt;
    }

    //default constructor
    public train() {
        metroID = randomNumber();
        stationNum = 0;
        direction = passtotal = 0;
    }

    //constructor with one parameter. only changes the metroID.
    public train(int metro_ID) {
        metro_ID = this.metroID;
        stationNum = 0;
        direction = passtotal = 0;
    }

    public int nextStation(int lastStation)
    {
        direction = 1;
        while(stationNum!=0)
        if(direction==1){
            stationNum += 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Details: " +
                "metroID=" + metroID +
                ", stationNum=" + stationNum +
                ", direction=" + direction +
                ", passtotal=" + passtotal;
    }

    public boolean equals(train t)
    {
        return passtotal == t.passtotal;
    }

}