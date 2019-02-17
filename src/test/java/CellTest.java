import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    Cell cell;
    Ship battleship;
    @Before

    public void before(){
        cell = new Cell();
        battleship = new Ship(ShipType.BATTLESHIP);
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
        cell.setShip(battleship);
        assertFalse(cell.isEmpty());
        assertEquals(ShipType.BATTLESHIP, cell.getShipType());
    }

    @Test

    public void cellCanBeSetExploded(){
        cell.setExploded();
        assertTrue(cell.isExploded());
    }
}
