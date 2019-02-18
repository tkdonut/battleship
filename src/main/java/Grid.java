public class Grid {
    Cell[][] gridArray;
    int cols;
    int rows;
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLUE = "\u001B[34m";

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
        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.print("  ------------------------");
        for (int i = 0; i < cols; i++){
            System.out.println();
            System.out.print(i + " |");
            for (int j = 0; j < rows; j++){
                if (gridArray[i][j].isEmpty()){
                    System.out.print(ANSI_BLUE + " . " + ANSI_RESET);
                } else if (gridArray[i][j].isExploded()) {
                    System.out.printf(ANSI_RED + " ! " + ANSI_RESET);
                } else {

                    System.out.printf(ANSI_YELLOW +" " + gridArray[i][j].getShipType().getSymbol() + " " + ANSI_RESET);
                }

            }
        }
        System.out.println();
    }

    public void printHitsAndMisses(){
        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.print("  ------------------------");
        for (int i = 0; i < cols; i++){
            System.out.println();
            System.out.print(i + " |");
            for (int j = 0; j < rows; j++){
                if (gridArray[i][j].isExploded()){
                    System.out.print(ANSI_RED + " X " + ANSI_RESET);
                } else if (gridArray[i][j].getMiss()) {
                    System.out.printf(" O ");
                } else {

                    System.out.print(ANSI_BLUE + " . " + ANSI_RESET);
                }

            }
        }
        System.out.println();
    }

    public void fireAt(int x, int y){
       Cell targetCell = this.gridArray[y][x];
       if (targetCell.isExploded()){ return;}
       if (!targetCell.isEmpty()) {
           targetCell.setExploded();
           targetCell.getShip().loseLife();
       } else {
          targetCell.setMiss();
       }
    }
}


