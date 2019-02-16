import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GridTest {
    Grid gameBoard;
    Cell cell;
    Ship aircraftCarrier;
    Ship battleship;
    Ship destroyer;

    @Before
    public void before(){
        gameBoard = new Grid();
        cell = new Cell();
        battleship = new Ship(ShipType.BATTLESHIP);
        destroyer = new Ship(ShipType.DESTROYER);
        aircraftCarrier = new Ship(ShipType.AIRCRAFTCARRIER);
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
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 0, 0, false);
        gameBoard.print();
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
        gameBoard.print();
        gameBoard.placeShip(destroyer.getType(), 6, 0, false);
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertFalse(gameBoard.getGrid()[0][6].isEmpty());
        assertFalse(gameBoard.getGrid()[0][7].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically(){

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[1][0].isEmpty());
        assertTrue(gameBoard.getGrid()[2][0].isEmpty());
        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 0, 0, true);
        gameBoard.print();
        assertFalse(gameBoard.getGrid()[0][0].isEmpty());
        assertFalse(gameBoard.getGrid()[1][0].isEmpty());
        assertFalse(gameBoard.getGrid()[2][0].isEmpty());
        assertFalse(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically__2(){

        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        assertTrue(gameBoard.getGrid()[5][0].isEmpty());
        assertTrue(gameBoard.getGrid()[6][0].isEmpty());
        assertTrue(gameBoard.getGrid()[7][0].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 0, 4, true);
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertFalse(gameBoard.getGrid()[4][0].isEmpty());
        assertFalse(gameBoard.getGrid()[5][0].isEmpty());
        assertFalse(gameBoard.getGrid()[6][0].isEmpty());
        assertFalse(gameBoard.getGrid()[7][0].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically__3(){

        assertTrue(gameBoard.getGrid()[2][7].isEmpty());
        assertTrue(gameBoard.getGrid()[3][7].isEmpty());
        assertTrue(gameBoard.getGrid()[4][7].isEmpty());
        assertTrue(gameBoard.getGrid()[5][7].isEmpty());
        assertTrue(gameBoard.getGrid()[6][7].isEmpty());
        assertTrue(gameBoard.getGrid()[7][7].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(aircraftCarrier.getType(), 7, 3, true);
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[2][7].isEmpty());
        assertFalse(gameBoard.getGrid()[3][7].isEmpty());
        assertFalse(gameBoard.getGrid()[4][7].isEmpty());
        assertFalse(gameBoard.getGrid()[5][7].isEmpty());
        assertFalse(gameBoard.getGrid()[6][7].isEmpty());
        assertFalse(gameBoard.getGrid()[7][7].isEmpty());
    }
    @Test

    public void cannotPlaceShipOutOfBounds(){
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 5, 0, false);
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
    }

    @Test
    public void cannotPlaceShipOutOfBoundsVertically(){
        assertTrue(gameBoard.getGrid()[5][3].isEmpty());
        assertTrue(gameBoard.getGrid()[6][3].isEmpty());
        assertTrue(gameBoard.getGrid()[7][3].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 3, 5, true);
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[5][3].isEmpty());
        assertTrue(gameBoard.getGrid()[6][3].isEmpty());
        assertTrue(gameBoard.getGrid()[7][3].isEmpty());
    }

    @Test
    public void canPlaceMultipleShips(){
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        assertTrue(gameBoard.getGrid()[7][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        gameBoard.print();
        gameBoard.placeShip(battleship.getType(), 0, 4, true);
        gameBoard.placeShip(aircraftCarrier.getType(), 1, 7, false);
        gameBoard.placeShip(destroyer.getType(), 7, 0, true);
        assertFalse(gameBoard.getGrid()[4][0].isEmpty());
        assertFalse(gameBoard.getGrid()[7][1].isEmpty());
        assertFalse(gameBoard.getGrid()[0][7].isEmpty());
        gameBoard.print();
    }

    @Test
    public void canCheckForCollisions(){
        gameBoard.placeShip(destroyer.getType(), 7, 0, true);
        gameBoard.print();
        assertFalse(gameBoard.doesNotCollide(4,4,0,false));
        assertTrue(gameBoard.doesNotCollide(3,4,0,false));
        assertTrue(gameBoard.doesNotCollide(4,3,0,false));

    }


}
