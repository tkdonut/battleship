public class Cell {
    private boolean empty;
    private ShipType shipType;
    private boolean explosion;

    public Cell(){
        empty = true;
        explosion = false;
        shipType = null;
    }

    public boolean isEmpty(){
        return empty;
    }

    public void setFull(){
        empty = false;
    }

    public ShipType getShipType(){
        return shipType;
    }

    public void setShip(ShipType newShip){
        this.shipType = newShip;
        this.setFull();
    }

    public boolean isExploded(){
        return explosion;
    };

}
