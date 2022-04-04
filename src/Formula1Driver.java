import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable { //Contains different kind of Statistics of Formula1 Drivers

    private int totalFirstPositions; //Total count of First Positions achieved by a driver
    private int totalSecondPositions; ///Total count of Second Positions achieved by a driver
    private int totalThirdPositions; //Total count of Third Positions achieved by a driver
    private int driverPosition; //To Calculate driver points according to the positions achieved
    private int totalPoints; //Total points achieved by a Driver
    private int totalRacesContested; //Total Races Contested by a Driver

    //Setters and Getters

    public int getTotalFirstPositions() {
        return totalFirstPositions;
    }
    public void setTotalFirstPositions(int p) {
        totalFirstPositions = p;
    }

    public int getTotalSecondPositions() {
        return totalSecondPositions;
    }
    public void setTotalSecondPositions(int p) {
        totalSecondPositions = p;
    }

    public int getTotalThirdPositions() {
        return totalThirdPositions;
    }
    public void setTotalThirdPositions(int p) {
        totalThirdPositions = p;
    }

    public int getDriverPosition() {
        return driverPosition;
    }
    public void setDriverPosition(int p) {
        driverPosition = p;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(int p) {
        totalPoints = p;
    }

    public int getTotalRacesContested() {
        return totalRacesContested;
    }
    public void setTotalRacesContested(int p) {
        totalRacesContested = p;
    }

    //points system for the F1 Driver
    public void updateDriverPoints(int driverPoints){
        switch (driverPosition) {
            case 1:
                this.totalPoints+=25;
                break;
            case 2:
                this.totalPoints+=18;
                break;
            case 3:
                this.totalPoints+=15;
                break;
            case 4:
                this.totalPoints+=12;
                break;
            case 5:
                this.totalPoints+=10;
                break;
            case 6:
                this.totalPoints+=8;
                break;
            case 7:
                this.totalPoints+=6;
                break;
            case 8:
                this.totalPoints+=4;
                break;
            case 9:
                this.totalPoints+=2;
                break;
            case 10:
                this.totalPoints+=1;
                break;
            default:
                break;
        }
        System.out.println("Total Point: "+ driverPoints);
    }
}