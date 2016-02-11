package hashcode2016.tests;

import hashcode2016.Cell;
import hashcode2016.Drone;
import hashcode2016.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 * @since 2016/02/11
 */
public class DroneTests {

    private Product productA;

    private Product productB;

    private Product productC;

    private Drone smallDrone;

    private Drone mediumDrone;

    private Drone largeDrone;

    @Before
    public void setUp() {
        productA = new Product(0, 0.5f);
        productB = new Product(1, 2.5f);
        productC = new Product(2, 5);
        smallDrone = new Drone(0, new Cell(0, 0), 2);
        mediumDrone = new Drone(1, new Cell(0, 0), 8.5f);
        largeDrone = new Drone(2, new Cell(0, 0), 15.3f);
    }

    @Test
    public void loadTest() {
        assertEquals(4, smallDrone.load(productA, 6));
        assertEquals(1, mediumDrone.load(productB, 1));
        assertEquals(2, mediumDrone.load(productB, 3));
        assertEquals(0, smallDrone.load(productC, 1));
    }

    @Test
    public void unloadTest() {
        assertEquals(0, smallDrone.unload(productA, 2));
        smallDrone.load(productA, 5);
        assertEquals(4, smallDrone.unload(productA, 5));
    }

}
