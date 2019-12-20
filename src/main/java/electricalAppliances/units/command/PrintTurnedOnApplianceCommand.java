package electricalAppliances.units.command;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.ElectricalAppliances;

public class PrintTurnedOnApplianceCommand implements ICommand {
    private ElectricalAppliances appliance;

    public PrintTurnedOnApplianceCommand(ElectricalAppliances newAppliance) {
        this.appliance = newAppliance;
    }


    public void execute(){
        appliance.printTurnedOnAppliance();
    }

}
