import java.util.Date;

public class NewRace { //for the addCompletedRace() method
    //Driver objects contesting in the race
    private Formula1Driver driver1;
    private Formula1Driver driver2;
    private Formula1Driver driver3;

    //variables for storing driver position achieved in the race
    private int driver1Position;
    private int driver2Position;
    private int driver3Position;

    //date
    private Date raceDate;

    //setters and getters for the above variables
    public Formula1Driver getDriver1() {
        return driver1;
    }
    public void setDriver1(Formula1Driver driver1) {
        this.driver1 = driver1;
    }

    public Formula1Driver getDriver2() {
        return driver2;
    }
    public void setDriver2(Formula1Driver driver2) {
        this.driver2 = driver2;
    }

    public Formula1Driver getDriver3() {
        return driver3;
    }
    public void setDriver3(Formula1Driver driver3) {
        this.driver3 = driver3;
    }

    public int getDriver1Position() {
        return driver1Position;
    }
    public void setDriver1Position(int driver1Position) {
        this.driver1Position = driver1Position;
    }

    public int getDriver2Position() {
        return driver2Position;
    }
    public void setDriver2Position(int driver2Position) {
        this.driver2Position = driver2Position;
    }

    public int getDriver3Position() {
        return driver3Position;
    }
    public void setDriver3Position(int driver3Position) {
        this.driver3Position = driver3Position;
    }

    public Date getRaceDate() {
        return raceDate;
    }
    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }
}