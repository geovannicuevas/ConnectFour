
import java.util.Scanner;

public ConnectFour {
    static final char[] player = {'X', 'O'};
    static final char empty = ' ';
    static final int rows= 4;
    static final int columns = 4;

    static void printArray(String[][] array) {
        for(int row = 0; row < array.length; row++) {
            for(int column = 0; column < array[row].length; column++) {
                System.out.print("|" + array[row][column]);
            }
            System.out.println("|");
        }
    }
    static boolean isBoardFull(String[][] array) {
        for(int row = 0; row < array.length; row++) {
            for(int column = 0; column < array[row].length; column++) {
                if (array[row][column].equals("" + empty)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void addDisc(String[][] array, int column, char player) {
        for(int row = array.length-1; row >= 0 ; row--) {
            if(array[row][column] == "" + empty) {
                array[row][column] = "" + player;
                break;
            }
        }
    }

    static boolean winVertical(String[][] array, char player) {
        for(int row = 0; row < array.length; row++) {
            int count = 0;
            for(int column = 0; column < array[row].length; column++) {
                if(array[row][column].equals(""+player)) {
                    count++;
                }
                else {
                    break;
                }
            }
            if(count == 4) {
                return true;
            }
        }
        return false;
    }

    static boolean winHorizontal(String[][] array, char player) {
        for(int column = 0; column < array[0].length; column++) {
            int count = 0;
            for(int row = 0; row < array.length; row++) {
                if(array[row][column].equals(""+player)) {
                    count++;
                }
                else {
                    break;
                }
            }
            if(count == 4) {
                return true;
            }
        }
        return false;
    }

    static boolean winDiagonal(String[][] array, char player) {

        int count = 0;
        for(int row = 0; row < array.length; row++) {
            if(array[row][row].equals(""+player)) {
                count++;
            }
        }
        if(count == 4) {
            return true;
        }

        count = 0;
        for(int row = 0; row < array.length; row++) {
            if(array[row][array.length - 1 - row].equals(""+player)) {
                count++;
            }
        }
        if(count == 4) {
            return true;
        }
        else {
            return false;
        }


    }

    public static void main(String[] args) {
        System.out.println("[Connect Four]");
        String[][] array = new String[rows][columns];
        for(int row = 0; row < array.length; row++) {
            for(int column = 0; column < array[row].length; column++) {
                array[row][column] = "" + empty;
            }
        }
        int current_player = 0;

        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Player " + (current_player+1) + ", enter a column: ");
            int column = keyboard.nextInt();

            addDisc(array, column, player[current_player]);

            System.out.println();
            printArray(array);
            System.out.println();

            if(winHorizontal(array, player[current_player])
                    || winVertical(array, player[current_player])
                    || winDiagonal(array, player[current_player])) {
                System.out.println("Player " + (current_player +1) + " wins!");
                break;
            }

            else if(isBoardFull(array)) {
                System.out.println("No one wins!");
                break;
            }
              current_player = (current_player +1) % 2;
        }while(true);

        keyboard.close();
    }

}
