import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GridTest {
    Grid gameBoard;
    Cell cell;

    @Before
    public void before(){
        gameBoard = new Grid();
        cell = new Cell();

    }

    @Test
    public void new_grid_contains_two_dimensional_array_of_cells(){
        assertEquals(cell.getClass(), gameBoard.getGrid()[0][0].getClass());
        assertEquals(cell.getClass(), gameBoard.getGrid()[7][7].getClass());
    }

    @Test
    public void new_grids_cells_begin_empty() {
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[2][5].isEmpty());
        assertTrue(gameBoard.getGrid()[6][6].isEmpty());
    }

}
