import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GridTest {
    Grid gameBoard;

    @Before
    public void before(){
        gameBoard = new Grid();

    }

    @Test
    public void new_grid_contains_two_dimensional_array_of_string_o(){
        assertEquals("o", gameBoard.getGrid()[0][0]);
        assertEquals("o", gameBoard.getGrid()[9][9]);
    }

    @Test
    public void can_place_a_ship_on_the_grid(){


    }
}
