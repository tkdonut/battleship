public class Ship {
    private ShipType type;
    private int lives;
    private boolean deployed;

    public Ship(ShipType type){
       this.type = type;
       this.lives = this.type.getLength();
       this.deployed = false;
    }

    public ShipType getType(){
        return this.type;
    }

    public int getLives(){
        return this.lives;
    }

    public boolean isDeployed(){
       return deployed;
    }

    public void setDeployed(){
        deployed = true;
    }
}
