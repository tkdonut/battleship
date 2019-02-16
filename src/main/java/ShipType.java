public enum ShipType {
    AIRCRAFTCARRIER(5, "A"),
    BATTLESHIP(4, "B"),
    SUBMARINE(3, "S"),
    CRUISER(3, "C"),
    DESTROYER(2, "D");

    private final int length;
    private final String symbol;

    ShipType(int length, String symbol){
        this.length =length;
        this.symbol = symbol;
    }

    public int getLength(){
       return length;
    }
}
