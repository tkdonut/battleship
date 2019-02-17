import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Ship> ships;
    private Grid grid;
    private String name;

    public Player(String name){
       this.ships = new ArrayList<>();
       ships.add(new Ship(ShipType.AIRCRAFTCARRIER));
       ships.add(new Ship(ShipType.BATTLESHIP));
       ships.add(new Ship(ShipType.CRUISER));
       ships.add(new Ship(ShipType.SUBMARINE));
       ships.add(new Ship(ShipType.DESTROYER));
       this.grid = new Grid();
       this.name = name;
    }
    public ArrayList<Ship> getShips(){
        return ships;
    }

    public boolean hasLost(){
        for (Ship ship : ships){
            if (!ship.isSunk()) {
               return false;
            }
        }
        return true;
    }

    public Grid getGrid(){
        return grid;
    }

    public String getName(){
        return name;
    }

}
