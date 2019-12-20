package electricalAppliances.units;
import electricalAppliances.logic.interfaces.IPlugIn;

public class ElectricalAppliances implements IPlugIn
{
    private String name;
    private int power;
    private double weight;
    private boolean turnedOn = false;
    private String location;

    public ElectricalAppliances(String name, int power, double weight, String location) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.location = location;
    }

    public ElectricalAppliances() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTurnOn() {
        this.turnedOn = true;
    }

    public void setTurnOff() {
        this.turnedOn = false;
    }

    public boolean isTurnedOn() {
        return this.turnedOn;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Name: " + name +
                "\nPower: " + power + " watt" +
                "\nWeight: " + weight + " kg" +
                "\nRoom: " + location +
                "\nTurned On: " + turnedOn + '\n';
    }


    public void findElectricalAppliancesByPow(int power)
    {
        if(this.power == power) System.out.println(this);
    }
    public void findElectricalAppliancesByName(String s)
    {
        if(s.equals(this.name)) System.out.println(this);
    }
    public void findElectricalAppliancesByRoom(String room)
    {
        if(room.equals(this.location)) System.out.println(this);
    }
    public void printElectricalAppliances()
    {
        System.out.println(this + "-----------------\n");
    }
    public void printTurnedOnAppliance() {if (isTurnedOn()) System.out.println(this);}

    public boolean isCorrectAppliance() {
        return (name != null) && (power > 0) && (weight > 0) && (location != null);
    }

}
