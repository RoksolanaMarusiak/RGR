package electricalAppliances.tests;
import electricalAppliances.logic.Menu;
import electricalAppliances.units.ElectricalAppliances;
import electricalAppliances.logic.SortByPower;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuTest {
    @Test
    public void sort() {
        List<ElectricalAppliances> expectedList = new ArrayList<ElectricalAppliances>();
        List<ElectricalAppliances> actualList = new ArrayList<ElectricalAppliances>();

        ElectricalAppliances unit1 = new ElectricalAppliances("Mixer", 30, 0.5, "Kitchen");
        ElectricalAppliances unit2 = new ElectricalAppliances("Hair dryer", 20, 1, "Bathroom");
        ElectricalAppliances unit3 = new ElectricalAppliances("TV", 100, 8, "Living room");

        actualList.add(unit1); actualList.add(unit2); actualList.add(unit3);
        expectedList.add(unit1); expectedList.add(unit2); expectedList.add(unit3);

        Menu testMenu1 = new Menu(expectedList);
        testMenu1.sort();
        expectedList.clear();
        expectedList.addAll(testMenu1.getAllAppliances());

        Collections.sort(actualList, new SortByPower());
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void getAllAppliances() {
        List<ElectricalAppliances> expectedList = new ArrayList<ElectricalAppliances>();
        List<ElectricalAppliances> actualList = new ArrayList<ElectricalAppliances>();

        ElectricalAppliances unit1 = new ElectricalAppliances("Mixer", 30, 0.5, "Kitchen");
        ElectricalAppliances unit2 = new ElectricalAppliances("Hair dryer", 20, 1, "Bathroom");
        ElectricalAppliances unit3 = new ElectricalAppliances("TV", 100, 8, "Living room");

        Menu menu = new Menu(expectedList);
        menu.addNewElement(unit1);menu.addNewElement(unit2);menu.addNewElement(unit3);
        expectedList.addAll(menu.getAllAppliances());

        actualList.add(unit1); actualList.add(unit2); actualList.add(unit3);
    }

}
