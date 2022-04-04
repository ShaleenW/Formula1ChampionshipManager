public abstract class Driver { // to contain the details of the driver

    private String dName; //initializing variable for driver's name
    private String dLocation; //initializing variable for driver's location
    private String dTeam; //initializing variable for driver's team
    private String dStatistics;


    @Override
    public boolean equals(Object o) {
        return this.dName.equals(((Driver)o).dName);
    }

    public String getdName() { //getter for driver's name
        return dName;
    }
    public void setdName(String s) { //setter for driver's name
        this.dName = s;
    }

    public String getdLocation() { //getter for driver's location
        return dLocation;
    }
    public void setdLocation(String s) { //setter for driver's location
        this.dLocation = s;
    }

    public String getdTeam() { //getter for driver's team
        return dTeam;
    }
    public void setdTeam(String s) { //setter for driver's team
        this.dTeam = s;
    }

    public String getdStatistics() { //getter for the driver statistics
        return dStatistics;
    }
    public void setdStatistics(String s) { //setter for the driver statistics
        this.dStatistics = s;
    }

}
