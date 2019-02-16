import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GridTest {
    Grid gameBoard;
    Cell cell;
    Ship battleship;

    @Before
    public void before(){
        gameBoard = new Grid();
        cell = new Cell();
        battleship = new Ship(ShipType.BATTLESHIP);
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

    @Test
    public void canPlaceShipWithX_Y(){

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
        gameBoard.placeShip(battleship.getType(), 0, 0, false);
        assertFalse(gameBoard.getGrid()[0][0].isEmpty());
        assertFalse(gameBoard.getGrid()[0][1].isEmpty());
        assertFalse(gameBoard.getGrid()[0][2].isEmpty());
        assertFalse(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y__2(){

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        gameBoard.placeShip(battleship.getType(), 4, 0, false);
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertFalse(gameBoard.getGrid()[0][4].isEmpty());
        assertFalse(gameBoard.getGrid()[0][5].isEmpty());
        assertFalse(gameBoard.getGrid()[0][6].isEmpty());
        assertFalse(gameBoard.getGrid()[0][7].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically(){

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        gameBoard.placeShip(battleship.getType(), 0, 0, true);
        assertFalse(gameBoard.getGrid()[0][0].isEmpty());
        assertFalse(gameBoard.getGrid()[1][0].isEmpty());
        assertFalse(gameBoard.getGrid()[2][0].isEmpty());
        assertFalse(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
    }

    @Test

    public void cannotPlaceShipOutOfBounds(){
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        gameBoard.placeShip(battleship.getType(), 5, 0, false);
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
    }




}
