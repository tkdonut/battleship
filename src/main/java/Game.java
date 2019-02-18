import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        deployShips(player1);
        deployShips(player2);

        while (!player2.hasLost()){
            printLogo();
            player2.getGrid().printHitsAndMisses();
            player1.getGrid().print();
            boolean validInput = false;
            Scanner scanner = new Scanner(System.in);
            int x = -1;
            int y = -1;

            while (!validInput) {
                try {
                    System.out.println("Firing a shot:");
                    System.out.println("Please enter X coord in a range between 0-7");
                    x = Integer.parseInt(scanner.nextLine());
                    if (x >= 0 && x <= 7) {
                        validInput = true;
                    }

                } catch (Exception e) {
                }
            }
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Firing a shot:");
                    System.out.println("Please enter Y coord in a range between 0-7");
                    y = Integer.parseInt(scanner.nextLine());
                    if (y >= 0 && y <= 7) {
                        validInput = true;
                    }

                } catch (Exception e) {
                }
            }
            player2.getGrid().fireAt(x,y);

        }




    }

    public static void deployShips(Player player){
        Scanner scanner = new Scanner(System.in);
        int x = -1;
        int y = -1;
        boolean vertical = false;
        System.out.println();
        printLogo();
        player.getGrid().print();
        for (Ship ship : player.getShips()) {
            while (!ship.isDeployed()) {
                System.out.println();
                System.out.println(player.getName() + "'s turn to deploy");
                System.out.println("You are deploying an " + ship.getType().toString() + " of length " + ship.getType().getLength());
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Please enter X coord in a range between 0-7");
                        x = Integer.parseInt(scanner.nextLine());
                        if (x >= 0 && x <= 7) {
                            validInput = true;
                        }

                    } catch (Exception e) {
                    }
                }
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Please enter Y coord in a range between 0-7");
                        y = Integer.parseInt(scanner.nextLine());
                        if (y >= 0 && y <= 7) {
                            validInput = true;
                        }

                    } catch (Exception e) {
                    }
                }
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Place Vertically (Yy/Nn)");
                        String input = scanner.nextLine();
                        if (input.equals("Y") || input.equals("y")) {
                            vertical = true;
                            validInput = true;
                        }
                        if (input.equals("N") || input.equals("n")) {
                            vertical = false;
                            validInput = true;
                        }

                    } catch (Exception e) {
                    }
                }
                player.getGrid().placeShip(ship, x, y, vertical);
                System.out.println("----------------------------------------");
                printLogo();
                player.getGrid().print();
            }
        }
    }
    public static void printLogo(){
        System.out.println(" .  o ..");
        System.out.println(" o . o o.o");
        System.out.println("      ...oo");
        System.out.println("      ...oo");
        System.out.println("        __[]__");
        System.out.println("     __|_o_o_o\\__");
        System.out.println("     \\\"\"\"\"\"\"\"\"\"\"/");
        System.out.println("      \\. ..  . /");
        System.out.println(" ^^^^^^^^^^^^^^^^^^^^");
    }
}

