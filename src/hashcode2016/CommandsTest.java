package hashcode2016;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pierre on 11/02/2016.
 */
public class CommandsTest extends TestCase {

    private Commands dataoutput;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.dataoutput = new Commands();
    }


    @Test
    public void test(){
        dataoutput.droneLoad(new Drone(0,100), new Warehouse(0,0, 0),new Product(0,50),2);
        assertTrue(dataoutput.outputFile("truc"));
    }
}