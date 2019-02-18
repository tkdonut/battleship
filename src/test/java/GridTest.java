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
    public void before() {
        gameBoard = new Grid();
        cell = new Cell();
        battleship = new Ship(ShipType.BATTLESHIP);
        destroyer = new Ship(ShipType.DESTROYER);
        aircraftCarrier = new Ship(ShipType.AIRCRAFTCARRIER);
    }

    @Test
    public void new_grid_contains_two_dimensional_array_of_cells() {
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
    public void canPlaceShipWithX_Y() {

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 0, 0, false);
        System.out.println("After");
        gameBoard.print();
        assertFalse(gameBoard.getGrid()[0][0].isEmpty());
        assertFalse(gameBoard.getGrid()[0][1].isEmpty());
        assertFalse(gameBoard.getGrid()[0][2].isEmpty());
        assertFalse(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y__2() {

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[0][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][2].isEmpty());
        assertTrue(gameBoard.getGrid()[0][3].isEmpty());
        assertTrue(gameBoard.getGrid()[0][4].isEmpty());
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(destroyer, 6, 0, false);
        System.out.println("After");
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
    public void canPlaceShipWithX_Y_vertically() {

        assertTrue(gameBoard.getGrid()[0][0].isEmpty());
        assertTrue(gameBoard.getGrid()[1][0].isEmpty());
        assertTrue(gameBoard.getGrid()[2][0].isEmpty());
        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 0, 0, true);
        System.out.println("After");
        gameBoard.print();
        assertFalse(gameBoard.getGrid()[0][0].isEmpty());
        assertFalse(gameBoard.getGrid()[1][0].isEmpty());
        assertFalse(gameBoard.getGrid()[2][0].isEmpty());
        assertFalse(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically__2() {

        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        assertTrue(gameBoard.getGrid()[5][0].isEmpty());
        assertTrue(gameBoard.getGrid()[6][0].isEmpty());
        assertTrue(gameBoard.getGrid()[7][0].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 0, 4, true);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[3][0].isEmpty());
        assertFalse(gameBoard.getGrid()[4][0].isEmpty());
        assertFalse(gameBoard.getGrid()[5][0].isEmpty());
        assertFalse(gameBoard.getGrid()[6][0].isEmpty());
        assertFalse(gameBoard.getGrid()[7][0].isEmpty());
    }

    @Test
    public void canPlaceShipWithX_Y_vertically__3() {

        assertTrue(gameBoard.getGrid()[2][7].isEmpty());
        assertTrue(gameBoard.getGrid()[3][7].isEmpty());
        assertTrue(gameBoard.getGrid()[4][7].isEmpty());
        assertTrue(gameBoard.getGrid()[5][7].isEmpty());
        assertTrue(gameBoard.getGrid()[6][7].isEmpty());
        assertTrue(gameBoard.getGrid()[7][7].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(aircraftCarrier, 7, 3, true);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[2][7].isEmpty());
        assertFalse(gameBoard.getGrid()[3][7].isEmpty());
        assertFalse(gameBoard.getGrid()[4][7].isEmpty());
        assertFalse(gameBoard.getGrid()[5][7].isEmpty());
        assertFalse(gameBoard.getGrid()[6][7].isEmpty());
        assertFalse(gameBoard.getGrid()[7][7].isEmpty());
    }

    @Test

    public void cannotPlaceShipOutOfBounds() {
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 5, 0, false);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[0][5].isEmpty());
        assertTrue(gameBoard.getGrid()[0][6].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
    }

    @Test
    public void cannotPlaceShipOutOfBoundsVertically() {
        assertTrue(gameBoard.getGrid()[5][3].isEmpty());
        assertTrue(gameBoard.getGrid()[6][3].isEmpty());
        assertTrue(gameBoard.getGrid()[7][3].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 3, 5, true);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[5][3].isEmpty());
        assertTrue(gameBoard.getGrid()[6][3].isEmpty());
        assertTrue(gameBoard.getGrid()[7][3].isEmpty());
    }

    @Test
    public void canPlaceMultipleShips() {
        assertTrue(gameBoard.getGrid()[4][0].isEmpty());
        assertTrue(gameBoard.getGrid()[7][1].isEmpty());
        assertTrue(gameBoard.getGrid()[0][7].isEmpty());
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(battleship, 0, 4, true);
        gameBoard.placeShip(aircraftCarrier, 1, 7, false);
        gameBoard.placeShip(destroyer, 7, 0, true);
        assertFalse(gameBoard.getGrid()[4][0].isEmpty());
        assertFalse(gameBoard.getGrid()[7][1].isEmpty());
        assertFalse(gameBoard.getGrid()[0][7].isEmpty());
        System.out.println("After");
        gameBoard.print();
    }

    @Test
    public void canCheckForCollisions() {
        gameBoard.placeShip(destroyer, 7, 0, true);
        System.out.println("Before");
        gameBoard.print();
        assertTrue(gameBoard.collides(4, 4, 0, false));
        assertFalse(gameBoard.collides(3, 4, 0, false));
        assertFalse(gameBoard.collides(4, 3, 0, false));
    }

    @Test
    public void cannotPlaceShipsThatCollide() {
        gameBoard.placeShip(aircraftCarrier, 3, 0, true);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(aircraftCarrier, 0, 0, false);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[1][0].isEmpty());
    }

    @Test
    public void cannotPlaceShipsThatCollide__2() {
        gameBoard.placeShip(aircraftCarrier, 3, 0, true);
        gameBoard.placeShip(aircraftCarrier, 2, 0, true);
        gameBoard.placeShip(aircraftCarrier, 1, 0, true);
        gameBoard.placeShip(aircraftCarrier, 0, 0, true);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.placeShip(aircraftCarrier, 3, 4, false);
        gameBoard.placeShip(aircraftCarrier, 3, 5, false);
        gameBoard.placeShip(aircraftCarrier, 3, 6, false);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[4][4].isEmpty());
    }

    @Test

    public void shipsAreSetDeployedUponSuccessfulPlacement(){
        assertFalse(aircraftCarrier.isDeployed());
        gameBoard.placeShip(aircraftCarrier, 3, 4, false);
        assertTrue(aircraftCarrier.isDeployed());

    }

    @Test
    public void canFireAtCell(){
        gameBoard.placeShip(aircraftCarrier, 0, 0, false);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.fireAt(0,0);
        System.out.println("After");
        gameBoard.print();
        assertTrue(gameBoard.getGrid()[0][0].isExploded());
    }

    @Test
    public void firedAtShipsLoseLives(){
        gameBoard.placeShip(aircraftCarrier, 0, 0, false);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(1,0);
        gameBoard.fireAt(2,0);
        System.out.println("After");
        gameBoard.print();
        assertEquals(2,aircraftCarrier.getLives());
    }

    @Test
    public void firedAtShipsCanBeSunk(){
        gameBoard.placeShip(aircraftCarrier, 0, 0, false);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(1,0);
        gameBoard.fireAt(2,0);
        gameBoard.fireAt(3,0);
        gameBoard.fireAt(4,0);
        gameBoard.fireAt(5,0);
        gameBoard.fireAt(6,0);
        System.out.println("After");
        gameBoard.print();
        gameBoard.printHitsAndMisses();
        assertTrue(aircraftCarrier.isSunk());
    }

    @Test
    public void firingAtPreviouslyHitCellsDoesNothing(){
        gameBoard.placeShip(destroyer, 0, 0, false);
        System.out.println("Before");
        gameBoard.print();
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(0,0);
        gameBoard.fireAt(0,0);
        System.out.println("After");
        gameBoard.print();
        assertFalse(destroyer.isSunk());
    }

}
