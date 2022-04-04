import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager { //Handles all the operations of the Menu

    private final int totalDrivers; //Total drivers in the F1 Championship
    private ArrayList<Formula1Driver> f1DriversList; //Array List for the F1 Drivers
    private final ArrayList<NewRace> f1RaceList; //Array List for the New Races to be added
    private final Scanner sc;

    public Formula1ChampionshipManager(int totalDrivers) throws IOException { //parameterized constructor for the main method
        this.totalDrivers = totalDrivers;
        f1DriversList = new ArrayList<>();
        f1RaceList = new ArrayList<>();
        sc = new Scanner(System.in);
        displayF1Menu(); //calling of Menu method for the program to start
    }

    public void displayF1Menu() { //F1 Menu

        while (true) {
            System.out.println();
            System.out.println("-----Formula1 Championship Menu-----");
            System.out.println("1. Create a New Driver (Enter 1)");
            System.out.println("2. Delete a Existing Driver (Enter 2)");
            System.out.println("3. Change the Driver for an Existing Constructor/Manufacturer Team (Enter 3)");
            System.out.println("4. Display Statistics for a Chosen Driver (Enter 4)");
            System.out.println("5. Display the Formula1 Driver Table (Enter 5)");
            System.out.println("6. Add Details of a Race Completed (Enter 6)");
            System.out.println("7. Exit Application (Press 7)");

            System.out.println();

            //Taking User Input
            System.out.println("Enter Your Choice: ");
            String userInput = sc.nextLine();

            //to catch any user input exceptions
            int select = 0;
            try {
                select = Integer.parseInt(userInput);
            } catch (Exception e) {
                //
            }

            switch (select) {
                case 1:
                    createDriver();
                    break;
                case 2:
                    deleteDriver();
                    break;
                case 3:
                    changeDriver();
                    break;
                case 4:
                    displayStats();
                    break;
                case 5:
                    displayF1Table();
                    break;
                case 6:
                    addCompletedRace();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default: //output if the user enters invalid input
                    System.out.println("Invalid Input. Try again.");
            }
        }
    }

    //Create a new driver
    private void createDriver() {

        //creating a Formula1Driver Instance(Object)
        Formula1Driver f1Driver = new Formula1Driver();

        //Inserting Driver Details
        System.out.println("Enter Driver's Name: ");
        String userInput = sc.nextLine();
        f1Driver.setdName(userInput);

        //check the new driver is only belonging to one manufacturer
        if (f1DriversList.contains(f1Driver)) {
            System.out.println("****Alert**** This Driver is already in another Team");
            return;
        }

        //adding details contd..
        System.out.println("Enter Driver's Location: ");
        userInput = sc.nextLine();
        f1Driver.setdLocation(userInput);

        //f1DriversList.add(f1Driver);
        System.out.println("Enter Driver's Team (Manufacturer): ");
        userInput = sc.nextLine();
        f1Driver.setdTeam(userInput);

        //Adding the driver to the f1Drivers ArrayList
        f1DriversList.add(f1Driver);
    }

    //Delete a existing driver
    private void deleteDriver() {
        System.out.println("Enter the Name of the Driver you want to Withdraw: ");
        String userInput = sc.nextLine();

        //removing the driver from the array list
        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput)) {
                f1DriversList.remove(f1Driver);
                System.out.println("Driver " + f1Driver.getdName() + " is deleted.");
                return;
            }
        }
        System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name");
    }

    //Change the driver of a existing team
    private void changeDriver() {
        System.out.println("Enter the Name of the Driver you want to Replace");
        String userInput = sc.nextLine();

        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput)) {
                System.out.println("Enter the Name of the New Driver: ");
                String newDrivName = sc.nextLine();
                f1Driver.setdName(newDrivName);
                System.out.println("Enter Driver's Location: ");
                String newDrivLocation = sc.nextLine();
                f1Driver.setdLocation(newDrivLocation);
                //letting the user that the change was successfully recorded
                System.out.println("Driver Replaced Successfully.");
                return;
            }
        }
        System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name");
    }

    //Displaying Statistics for a particular driver
    private void displayStats() {
        System.out.println("Enter the Name of the Driver to view Statistics: ");
        String userInput = sc.nextLine();

        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput)) {
                System.out.println("Driver Team: "+ f1Driver.getdTeam());
                System.out.println("Driver " + f1Driver.getdName() + " has achieved 1st Position " + f1Driver.getTotalFirstPositions() + " time(s).");
                System.out.println("Driver " + f1Driver.getdName() + " has achieved 2nd Position " + f1Driver.getTotalSecondPositions() + " time(s).");
                System.out.println("Driver " + f1Driver.getdName() + " has achieved 3rd Position " + f1Driver.getTotalThirdPositions() + " time(s).");
                System.out.println();
                System.out.println("----- Driver's Performance in the Current Championship -----");
                System.out.println("Driver " + f1Driver.getdName() + " 's Championship Points: " + f1Driver.getTotalPoints());
                System.out.println("Driver " + f1Driver.getdName() + " has contested in " + f1Driver.getTotalRacesContested() + " F1 race(s) in this Season.");
                return;
            }
        }
        System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name");
    }

    //Displaying the Formula 1 Driver Table
    private void displayF1Table() {

        f1DriversList.sort(new TableComparator());
        for (Formula1Driver f1Driver : f1DriversList) {
            System.out.println("Driver: " + f1Driver.getdName() +'\n'+ "Driver Team: "+ f1Driver.getdTeam()+'\n'+
                    " Championship Points: " + f1Driver.getTotalPoints() +'\n'+
                    " First Position Count: " + f1Driver.getTotalFirstPositions());
        }

        try {
            // Create the file
            FileOutputStream fos = new FileOutputStream("DriverInfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // write the object to the file
            System.out.println("Saving into file : ");
            oos.writeObject(f1DriversList );
            oos.close();

            // read back the object from the file
            FileInputStream fis = new FileInputStream("DriverInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Formula1ChampionshipManager> f1DriverList = (ArrayList<Formula1ChampionshipManager>) ois.readObject();
            System.out.println("Object read from file: ");
            ois.close();

        } catch (Exception ioEx) {
            ioEx.printStackTrace();
        }
    }

    //Adding a race completed
    private void addCompletedRace() {
        System.out.println("Enter Date which the Race was held. (format MM-dd-yyyy): ");
        String userInput = sc.nextLine();
        Date date;

        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(userInput);

        } catch (ParseException ex) {
            System.out.println("Please Enter the Date in format of MM-dd-yyyy");
            return;
        }

        //Recording Driver1 details to add a race contested
        System.out.println("Enter Driver1 Name: ");
        userInput = sc.nextLine();

        Formula1Driver driv1 = null;
        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput))
                driv1 = f1Driver;
        }
        if (driv1 == null) {
            System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name " +
                    '\n' + "or Start by Adding the driver to the Championship First from the Option 1 from the Menu");
            return;
        }
        System.out.println("Enter the position achieved by Driver1: ");
        userInput = sc.nextLine();
        int driv1Position = -1;
        try {
            driv1Position = Integer.parseInt(userInput);
        } catch (Exception e) {
        }

        if (driv1Position == -1) {
            System.out.println("Please Enter Correct position of the Driver");
            return;
        }

        //Recording Driver2 details to add a race contested
        System.out.println("Enter Driver2 Details: ");
        userInput = sc.nextLine();

        Formula1Driver driv2 = null;
        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput))
                driv2 = f1Driver;
        }
        if (driv2 == null) {
            System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name " +
                    '\n' + "or Start by Adding the driver to the Championship First from the Option 1 from the Menu");
            return;
        }
        System.out.println("Enter the position achieved by Driver2: ");
        userInput = sc.nextLine();
        int driv2Position = -1;
        try {
            driv2Position = Integer.parseInt(userInput);
        } catch (Exception e) {
        }

        if (driv2Position == -1) {
            System.out.println("Please Enter Correct position of the Driver");
            return;
        }

        //Recording Driver3 details to add a race contested
        System.out.println("Enter Driver3 Name: ");
        userInput = sc.nextLine();

        Formula1Driver driv3 = null;
        for (Formula1Driver f1Driver : f1DriversList) {
            if (f1Driver.getdName().equals(userInput))
                driv3 = f1Driver;
        }
        if (driv3 == null) {
            System.out.println("No such Driver was Found. Please try again by Entering correct Driver Name " +
                    '\n' + "or Start by Adding the driver to the Championship First from the Option 1 from the Menu");
            return;
        }
        System.out.println("Enter the position achieved by Driver3: ");
        userInput = sc.nextLine();
        int driv3Position = -1;
        try {
            driv3Position = Integer.parseInt(userInput);
        } catch (Exception e) {
        }

        if (driv3Position == -1) {
            System.out.println("Please Enter Correct position of the Driver");
            return;
        }

        //creating an instance for a new race
        NewRace f1NewRace = new NewRace();

        f1NewRace.setRaceDate(date);

        f1NewRace.setDriver1(driv1);
        f1NewRace.setDriver1Position(driv1Position);

        f1NewRace.setDriver2(driv2);
        f1NewRace.setDriver2Position(driv2Position);

        f1NewRace.setDriver3(driv3);
        f1NewRace.setDriver2Position(driv2Position);

        f1RaceList.add(f1NewRace);

        //Computations of Statistics of the Drivers
        switch (driv1Position) {
            case 1:
                driv1.setTotalFirstPositions(driv1.getTotalFirstPositions() + 1);
                driv1.setTotalRacesContested(driv1.getTotalRacesContested() + 1);
                driv1.setTotalPoints(driv1.getTotalPoints() + 25);
                break;
            case 2:
                driv1.setTotalSecondPositions(driv1.getTotalSecondPositions() + 1);
                driv1.setTotalRacesContested(driv1.getTotalRacesContested() + 1);
                driv1.setTotalPoints(driv1.getTotalPoints() + 18);
                break;
            case 3:
                driv1.setTotalThirdPositions(driv1.getTotalThirdPositions() + 1);
                driv1.setTotalRacesContested(driv1.getTotalRacesContested() + 1);
                driv1.setTotalPoints(driv1.getTotalPoints() + 15);
                break;
        }

        switch (driv2Position) {
            case 1:
                driv2.setTotalFirstPositions(driv2.getTotalFirstPositions() + 1);
                driv2.setTotalRacesContested(driv2.getTotalRacesContested() + 1);
                driv2.setTotalPoints(driv2.getTotalPoints() + 25);
                break;
            case 2:
                driv2.setTotalSecondPositions(driv2.getTotalSecondPositions() + 1);
                driv2.setTotalRacesContested(driv2.getTotalRacesContested() + 1);
                driv2.setTotalPoints(driv2.getTotalPoints() + 18);
                break;
            case 3:
                driv2.setTotalThirdPositions(driv2.getTotalThirdPositions() + 1);
                driv2.setTotalRacesContested(driv2.getTotalRacesContested() + 1);
                driv2.setTotalPoints(driv2.getTotalPoints() + 15);
                break;
        }

        switch (driv3Position) {
            case 1:
                driv3.setTotalFirstPositions(driv3.getTotalFirstPositions() + 1);
                driv3.setTotalRacesContested(driv3.getTotalRacesContested() + 1);
                driv3.setTotalPoints(driv3.getTotalPoints() + 25);
                break;
            case 2:
                driv3.setTotalSecondPositions(driv3.getTotalSecondPositions() + 1);
                driv3.setTotalRacesContested(driv3.getTotalRacesContested() + 1);
                driv3.setTotalPoints(driv3.getTotalPoints() + 18);
                break;
            case 3:
                driv3.setTotalThirdPositions(driv3.getTotalThirdPositions() + 1);
                driv3.setTotalRacesContested(driv3.getTotalRacesContested() + 1);
                driv3.setTotalPoints(driv3.getTotalPoints() + 15);
                break;
        }
    }

}
