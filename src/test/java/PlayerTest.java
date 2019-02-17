import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    @Before

    public void before(){
        player = new Player();
    }

    @Test
    public void playerHasAShipOfEachType(){
        assertEquals(5, player.getShips().size());
    }

    @Test
    public void playerCanLose(){
        assertFalse(player.hasLost());
        for (Ship ship: player.getShips()){
            ship.loseLife();
            ship.loseLife();
            ship.loseLife();
            ship.loseLife();
            ship.loseLife();
        }
        assertTrue(player.hasLost());
    }



}
