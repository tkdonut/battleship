import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    Cell cell;

    @Before

    public void before(){
        cell = new Cell();
    }

    @Test
    public void cellStartsEmpty(){
        assertTrue(cell.isEmpty());
    }

    @Test
    public void cellCanBeSetFull(){
        assertTrue(cell.isEmpty());
        cell.setFull();
        assertFalse(cell.isEmpty());
    }

    @Test

    public void cellCanBeSetToSpecificShip(){
        assertTrue(cell.isEmpty());
        cell.setShip(ShipType.BATTLESHIP);
        assertFalse(cell.isEmpty());
        assertEquals(ShipType.BATTLESHIP, cell.getShipType());
    }
}
