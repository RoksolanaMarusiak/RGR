package electricalAppliances.tests;

import electricalAppliances.units.ElectricalAppliances;
import org.junit.Assert;
import org.junit.Test;

public class ElectricalAppliancesTest {

    @Test
    public void isCorrectAppliance() {
        ElectricalAppliances TestAppliance = new ElectricalAppliances("Mixer", 30, 0.5, "Kitchen");
        boolean expected = TestAppliance.isCorrectAppliance();
        boolean actual = ((TestAppliance.getName()!=null) && (TestAppliance.getPower()!=0) &&(TestAppliance.getLocation()!=null) && (TestAppliance.getWeight() !=0));
        Assert.assertEquals(expected, actual);
    }
}
