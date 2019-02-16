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
}

