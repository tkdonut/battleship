public class Ship {
    private ShipType type;
    private int lives;

    public Ship(ShipType type){
       this.type = type;
       this.lives = this.type.getLength();
    }

    public ShipType getType(){
        return this.type;
    }

    public int getLives(){
        return this.lives;
    }
}
