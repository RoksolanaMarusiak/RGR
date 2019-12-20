import electricalAppliances.units.*;
import electricalAppliances.logic.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger log = LogManager.getLogger("Main");
        List<ElectricalAppliances> Appliances = new ArrayList<ElectricalAppliances>();
        System.out.println("1.Input data from keyboard\n2.Read data from file");
        int choice = 9;
            do {
                choice = sc.nextInt();
                if (choice != 1 && choice != 2)
                    System.out.println("Incorrect value. Try again.");
            } while (choice != 1 && choice != 2);
        sc.nextLine();
        if(choice == 1) {
            System.out.println("Input appliances(quit - exit):");
            int i = 1;
            while (true) {
                System.out.print(i++ + ". ");
                System.out.println("Enter name:");
                String name = sc.nextLine();
                if (name.equals("quit"))
                    break;
                int power = 0; double weight = 0;
                try {
                    System.out.println("Enter power:");
                    power = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter weight:");
                    weight = sc.nextDouble();
                } catch (InputMismatchException error)
                {
                    log.warn("Incorrect value. Try again."); i--;
                    sc.nextLine();
                    continue;
                }
                System.out.println("Enter room:");
                sc.nextLine();
                String location = sc.nextLine();
                ElectricalAppliances elap = new ElectricalAppliances(name, power, weight, location);

                if (elap.isCorrectAppliance())
                    Appliances.add(elap);
                else {
                    log.warn("Incorrect data. Try again."); i--;
                }
            }
        }
        if(choice == 2) {
            BufferedReader inputFile = null;
            try {
                inputFile = new BufferedReader(new FileReader("D:\\RGR\\src\\main\\java\\power.txt"));
            } catch (FileNotFoundException e) {
                log.error("File not found.");
            }
            String currentFileString = "";
            while(currentFileString != null) {
                try {
                    currentFileString = inputFile.readLine();
                } catch (IOException e) {
                    log.error("Can't read the file");
                } catch (NullPointerException error) {
                    System.exit(0);
                }
                String[] stringData;
                try {
                    stringData = currentFileString.split("_");
                }catch (NullPointerException r) {break;}
                ElectricalAppliances newApl = new ElectricalAppliances();
                newApl.setName(stringData[0]);
                try {
                    newApl.setPower(Integer.parseInt(stringData[1]));
                    newApl.setWeight(Double.parseDouble(stringData[2]));
                    newApl.setLocation(stringData[3]);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                if (newApl.isCorrectAppliance()) {
                    Appliances.add(newApl);
                }
            }
            try {
                inputFile.close();
            } catch (IOException w) {
                log.warn("Can't close the file");
            }
        }
        System.out.println("Appliances:");
        for (ElectricalAppliances el : Appliances) {
            System.out.println(el);
        }
        System.out.println("Menu:\n1.Print information about all appliances\n2.Delete appliance\n3.Add new appliance" +
                "\n4.Change properties of appliance\n5.Search for appliances by name\n6.Search for appliances by power\n" +
                "7.Search for appliances by room\n8.Sort appliances by power" +
                "\n9.Turn on appliance\n10.Turn off appliance\n11.Print all turned on appliances\n12.Turn on all appliances in the room\n" +
                "13.Turn off all appliances in the room\n14.Show power consumption\n0.Exit");
        Menu menu = new Menu(Appliances);
        int idOfCommand = -1;
        while (idOfCommand != 0) {
            System.out.print("Enter command: ");
            idOfCommand = sc.nextInt();
            switch (idOfCommand) {
                case (1):
                    log.info("Print all information");
                    menu.printElectricalAppliances();
                    break;
                case (2):
                    log.info("Deleting appliance");
                    sc.nextLine();
                    System.out.println("Enter name, power or weight:");
                    String s = sc.nextLine();
                    menu.deleteElement(s);
                    try {
                        menu.deleteElement(Integer.valueOf(s));
                        menu.deleteElement(Double.valueOf(s));
                    } catch (NumberFormatException ignored) {
                    }
                    break;
                case (3):
                    sc.nextLine();
                    log.info("Adding new element");
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    int power = 0; double weight = 0;
                    try {
                        System.out.println("Enter power:");
                        power = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter weight:");
                        weight = sc.nextDouble();
                    } catch (InputMismatchException error)
                    {
                        log.warn("Incorrect value. Try again.");
                        sc.nextLine();
                        break;
                    }
                    System.out.println("Enter room:");
                    sc.nextLine();
                    String location = sc.nextLine();
                    ElectricalAppliances elap = new ElectricalAppliances(name, power, weight, location);
                    if (elap.isCorrectAppliance())
                        menu.addNewElement(elap);
                    else {
                        log.warn("Incorrect data. Try again.");
                    }
                    break;
                case(4):
                    sc.nextLine();
                    log.info("Changing properties of appliance");
                    System.out.println("Enter name:");
                    String name1 = sc.nextLine();
                    int power3 = 0; double weight3 = 0;
                    try {
                        System.out.println("Enter power:");
                        power3 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter weight:");
                        weight3 = sc.nextDouble();
                    } catch (InputMismatchException error)
                    {
                        log.warn("Incorrect value. Try again.");
                        sc.nextLine();
                        break;
                    }
                    System.out.println("Enter room:");
                    sc.nextLine();
                    String location1 = sc.nextLine();
                    menu.changeAppliance(name1, power3, weight3, location1);
                    break;
                case (5):
                    log.info("Searching appliance by name");
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name5 = sc.nextLine();
                    menu.findByName(name5);
                    break;
                case (6):
                    log.info("Searching appliance by power");
                    System.out.println("Enter power:");
                    sc.nextLine();
                    int power1 = 0;
                    try {
                       power1 = sc.nextInt();
                    } catch (InputMismatchException error) {
                        log.warn("Incorrect value");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    menu.findByPower(power1);
                    break;
                case (7):
                    log.info("Searching appliance by room");
                    sc.nextLine();
                    System.out.println("Enter room:");
                    String room = sc.nextLine();
                    menu.findByRoom(room);
                    break;
                case (8):
                    log.info("Sorting by power");
                    menu.sort();
                    break;
                case (9):
                    log.info("Turning on appliance");
                    sc.nextLine();
                    System.out.println("Input name of appliance to turn on:");
                    String name2 = sc.nextLine();
                    menu.turnOn(name2);
                    break;
                case (10):
                    log.info("Turning off appliance");
                    sc.nextLine();
                    System.out.println("Input name of appliance to turn off:");
                    String name3 = sc.nextLine();
                    menu.turnOff(name3);
                    break;
                case (11):
                    log.info("Print all information");
                    menu.printTurnedOn();
                    break;
                case (12):
                    log.info("Turning on all appliances in the room");
                    sc.nextLine();
                    System.out.println("Enter room:");
                    String room1 = sc.nextLine();
                    menu.turnOnAllAppliancesInRoom(room1);
                    break;
                case (13):
                    log.info("Turning off all appliances in the room");
                    sc.nextLine();
                    System.out.println("Enter room:");
                    String room2 = sc.nextLine();
                    menu.turnOffAllAppliancesInRoom(room2);
                    break;
                case (14):
                    log.info("Calculating power consumption");
                    System.out.println(menu.calculateSumPower() + " watt");
                    break;
                default:
                    idOfCommand = 0;
                    break;
            }
        }
    }
}
