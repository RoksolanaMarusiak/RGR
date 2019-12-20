package electricalAppliances.units.command;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.ElectricalAppliances;

public class FindElectricalAppliancesByNameCommand implements ICommand {
    private ElectricalAppliances appliance;
    private String name;

    public FindElectricalAppliancesByNameCommand(ElectricalAppliances newAppliacne, String name) {
        this.appliance = newAppliacne;
        this.name = name;
    }

    public void execute() {
        appliance.findElectricalAppliancesByName(name);
    }
}
