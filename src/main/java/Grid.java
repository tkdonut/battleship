public class Grid {
    Cell[][] gridArray;
    int cols;
    int rows;

    public Grid(){
        this.cols = 8;
        this.rows = 8;

        gridArray = new Cell[cols][rows];


        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                gridArray[i][j] = new Cell();
            }
        }
    }


    public Cell[][]getGrid(){
        return gridArray;
    }

    public void placeShip(Ship ship, int x, int y, boolean vertical){
        ShipType shipToPlace = ship.getType();
        int length = shipToPlace.getLength();

        if (!vertical) {
            if (x + length > 8) return;
            if (collides(length,x,y,vertical)) return;
            for (int i = x; i < x + length; i++) {
                this.gridArray[y][i].setShip(ship);
            }
            ship.setDeployed();
        }else{
            if (y + length > 8) return;
            if (collides(length,x,y,vertical)) return;
            for (int i = y; i < y + length; i++ ){
                this.gridArray[i][x].setShip(ship);
            }
            ship.setDeployed();
        }
    }

    public boolean collides(int length, int x, int y, boolean vertical){

        if (!vertical) {
            if (x + length > 8) return true;
            for (int i = x; i < x + length; i++) {
                if (!this.gridArray[y][i].isEmpty()){
                    return true;
                }
            }
        }else {
            if (y + length > 8) return true;
            for (int i = y; i < y + length; i++) {
                if (!this.gridArray[i][x].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < cols; i++){
            System.out.println();
            for (int j = 0; j < rows; j++){
                if (gridArray[i][j].isEmpty()){
                    System.out.print(".");
                } else {
                    System.out.printf(gridArray[i][j].getShipType().getSymbol());
                }

            }
        }
        System.out.println();
    }
}


