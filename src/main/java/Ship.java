public class Ship {
    private ShipType type;
    private int lives;
    private boolean deployed;
    private boolean sunk;

    public Ship(ShipType type){
       this.type = type;
       this.lives = this.type.getLength();
       this.deployed = false;
       this.sunk = false;
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

    public void loseLife(){
        lives--;
        if (lives == 0){
            this.sunk = true;
        }
    }

    public boolean isSunk(){
        return sunk;
    }

}
