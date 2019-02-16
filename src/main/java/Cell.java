public class Cell {
    private boolean empty;
    private Ship ship;
    private boolean explosion;

    public Cell(){
        empty = true;
        explosion = false;
    }

    public boolean isEmpty(){
        return empty;
    }

    public void setFull(){
        empty = false;
    }

    public ShipType getShipType(){
        return ship.getType();
    }

    public void setShip(Ship newShip){
        this.ship = newShip;
        this.setFull();
    }

    public Ship getShip(){
       return ship;
    }

    public boolean isExploded(){
        return explosion;
    };

}
