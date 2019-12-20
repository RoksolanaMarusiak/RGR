package electricalAppliances.logic;
import electricalAppliances.units.command.*;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.*;
import java.util.*;

public class Menu {
    private List<ElectricalAppliances> electricalAppliancesArrayList = new ArrayList<>();

    public Menu(List<ElectricalAppliances> list) {
        this.electricalAppliancesArrayList.addAll(list);
    }

    public List<ElectricalAppliances> getAllAppliances() {
        return this.electricalAppliancesArrayList;
    }

    public void deleteElement(String S) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getName().equals(S)) electricalAppliancesArrayList.remove(electricalAppliances);
        }
    }

    public void deleteElement(int S) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getPower() == S) electricalAppliancesArrayList.remove(electricalAppliances);
        }
    }
    public void deleteElement(double S) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getWeight() == S) electricalAppliancesArrayList.remove(electricalAppliances);
        }
    }
    public void addNewElement(ElectricalAppliances element) {
        electricalAppliancesArrayList.add(element);
    }

    public void sort() {
        Collections.sort(electricalAppliancesArrayList, new SortByPower());
    }

    public void findByName(String name) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            ICommand findByName = new FindElectricalAppliancesByNameCommand(electricalAppliances, name);
            findByName.execute();
        }
    }

    public void findByPower(int power) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            ICommand findByPower = new FindElectricalAppliancesByPowerCommand(electricalAppliances, power);
            findByPower.execute();
        }
    }

    public void findByRoom(String room) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            ICommand findByRoom = new FindElectricalAppliancesByRoomCommand(electricalAppliances, room);
            findByRoom.execute();
        }
    }

    public void printElectricalAppliances() {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            ICommand printElApp = new PrintElectricalAppliancesCommand(electricalAppliances);
            printElApp.execute();
        }
    }

    public void printTurnedOn() {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            ICommand printTurnOnApl = new PrintTurnedOnApplianceCommand(electricalAppliances);
            printTurnOnApl.execute();
        }
    }

    public void turnOn(String name) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getName().equals(name)) {
                if (electricalAppliances.isTurnedOn()) {
                    System.out.println("Appliance is already turned on.");
                } else electricalAppliances.setTurnOn();
            }
        }
    }

    public void turnOff(String name) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getName().equals(name)) {
                if (!electricalAppliances.isTurnedOn()) {
                    System.out.println("Appliance is already turned off.");
                } else electricalAppliances.setTurnOff();

            }
        }
    }
    public void turnOnAllAppliancesInRoom(String room) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getLocation().equals(room)) {
                electricalAppliances.setTurnOn();
            }
        }
        System.out.println("All appliances in " + room +" were turned on.");
    }

    public void turnOffAllAppliancesInRoom(String room) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getLocation().equals(room)) {
                electricalAppliances.setTurnOff();
            }
        }
        System.out.println("All appliances in " + room +" were turned off.");
    }

    public void changeAppliance(String name, int pow, double weight, String location) {
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if (electricalAppliances.getName().equals(name)) {
                electricalAppliances.setPower(pow);
                electricalAppliances.setWeight(weight);
                electricalAppliances.setLocation(location);
            }
        }
    }

    public int calculateSumPower() {
        int sumPower = 0;
        for (ElectricalAppliances electricalAppliances : electricalAppliancesArrayList) {
            if(electricalAppliances.isTurnedOn())
                sumPower+=electricalAppliances.getPower();
        }
        return sumPower;
    }

}

