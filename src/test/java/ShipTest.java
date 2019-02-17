import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShipTest {
    Ship aircraftCarrier;
    Ship battleship;
    Ship cruiser;
    Ship submarine;
    Ship destroyer;

    @Before

    public void before(){
        aircraftCarrier = new Ship(ShipType.AIRCRAFTCARRIER);
        battleship = new Ship(ShipType.BATTLESHIP);
        cruiser = new Ship(ShipType.CRUISER);
        submarine = new Ship(ShipType.SUBMARINE);
        destroyer = new Ship(ShipType.DESTROYER);
    }

    @Test

    public void canGetShipType(){
        assertEquals(ShipType.BATTLESHIP, battleship.getType());
    }

    @Test

    public void shipHasLivesBasedOnType(){
        assertEquals(5, aircraftCarrier.getLives());
        assertEquals(4, battleship.getLives());
        assertEquals(3, cruiser.getLives());
        assertEquals(3, submarine.getLives());
        assertEquals(2, destroyer.getLives());
    }

    @Test

    public void shipHasFalseDeployedFlag(){
        assertEquals(false, aircraftCarrier.isDeployed());
    }

    @Test
    public void canSetDeployedFlagTrue(){
        assertFalse(aircraftCarrier.isDeployed());
        aircraftCarrier.setDeployed();
        assertTrue(aircraftCarrier.isDeployed());
    }

    @Test
    public void shipCanLoseLife(){
        assertEquals(5, aircraftCarrier.getLives());
        aircraftCarrier.loseLife();
        assertEquals(4, aircraftCarrier.getLives());
    }

    @Test
    public void shipStartsNotSunk(){
        assertFalse(aircraftCarrier.isSunk());
    }

    @Test
    public void losingAllLivesSinksShip(){
        assertFalse(aircraftCarrier.isSunk());
        aircraftCarrier.loseLife();
        aircraftCarrier.loseLife();
        aircraftCarrier.loseLife();
        aircraftCarrier.loseLife();
        assertFalse(aircraftCarrier.isSunk());
        aircraftCarrier.loseLife();
        assertTrue(aircraftCarrier.isSunk());
    }

    @Test
    public void losingAllLivesSinksShip__2(){
        assertFalse(destroyer.isSunk());
        destroyer.loseLife();
        assertFalse(destroyer.isSunk());
        destroyer.loseLife();
        assertTrue(destroyer.isSunk());

    }
}
