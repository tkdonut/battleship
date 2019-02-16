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
    }


