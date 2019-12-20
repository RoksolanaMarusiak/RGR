package electricalAppliances.units.command;
import electricalAppliances.logic.interfaces.ICommand;
import electricalAppliances.units.ElectricalAppliances;

public class FindElectricalAppliancesByRoomCommand implements ICommand {
    private ElectricalAppliances appliance;
    private String room;

    public FindElectricalAppliancesByRoomCommand(ElectricalAppliances newAppliance, String room) {
        this.appliance = newAppliance;
        this.room = room;
    }

    public void execute() {
        appliance.findElectricalAppliancesByRoom(room);
    }

}
