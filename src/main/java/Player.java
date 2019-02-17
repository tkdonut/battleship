import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    ArrayList<Ship> ships;

    public Player(){
       this.ships = new ArrayList<>();
       ships.add(new Ship(ShipType.AIRCRAFTCARRIER));
       ships.add(new Ship(ShipType.BATTLESHIP));
       ships.add(new Ship(ShipType.CRUISER));
       ships.add(new Ship(ShipType.SUBMARINE));
       ships.add(new Ship(ShipType.DESTROYER));
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
}
