package electricalAppliances.units.command;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.ElectricalAppliances;

public class PrintElectricalAppliancesCommand implements ICommand {
    private ElectricalAppliances appliance;

    public PrintElectricalAppliancesCommand(ElectricalAppliances newAppliance) {
        this.appliance = newAppliance;
    }

    public void execute(){
        appliance.printElectricalAppliances();
    }

}

