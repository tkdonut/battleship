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

    public void placeShip(ShipType shipToPlace, int x, int y, boolean vertical){
        int length = shipToPlace.getLength();

        if (!vertical) {
            if (x + length > 8) return;
            for (int i = x; i < x + length; i++) {
                this.gridArray[y][i].setShip(shipToPlace);
            }
        }else{
            if (y + length > 8) return;
            for (int i = y; i < y + length; i++ ){
                this.gridArray[i][x].setShip(shipToPlace);
            }
        }
    }

    public boolean doesNotCollide(int length, int x, int y, boolean vertical){

        if (!vertical) {
            if (x + length > 8) return false;
            for (int i = x; i < x + length; i++) {
                if (!this.gridArray[y][i].isEmpty()){
                    return false;
                }
            }
        }else {
            if (y + length > 8) return false;
            for (int i = y; i < y + length; i++) {
                if (!this.gridArray[i][x].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
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


