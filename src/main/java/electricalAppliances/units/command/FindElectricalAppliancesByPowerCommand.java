package electricalAppliances.units.command;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.ElectricalAppliances;

public class FindElectricalAppliancesByPowerCommand implements ICommand {
    private ElectricalAppliances appliance;
    private int power;

    public FindElectricalAppliancesByPowerCommand(ElectricalAppliances newAplliance, int power) {
        this.appliance = newAplliance;
        this.power = power;
    }

    public void execute() {
        appliance.findElectricalAppliancesByPow(power);
    }
}
