package electricalAppliances.logic;
import electricalAppliances.units.ElectricalAppliances;

import java.util.Comparator;

public class SortByPower implements Comparator<ElectricalAppliances>
{
    public int compare(ElectricalAppliances a, ElectricalAppliances b)
    {
        return a.getPower() - b.getPower();
    }
}