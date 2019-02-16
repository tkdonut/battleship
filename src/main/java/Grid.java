public class Grid {
    String[][] gridArray;

    public Grid(){
        gridArray = new String[][]
                {
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                        {"o", "o", "o", "o", "o", "o", "o", "o", "o", "o"},
                };
    }


    public String[][]getGrid(){
       return gridArray;
    }

    public void logGrid(){
        for (String [] row : gridArray){
            System.out.println();
            for (String cell : row){
                System.out.print(cell);
            }
        }
    }

}

