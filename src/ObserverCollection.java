public class ObserverCollection implements BoardObserver{

    @Override
    public void UpdateBoard(int[][] field, String update) {//method for when we update an observer

        switch (update) {
            case "Game Started" -> System.out.println(update + "\nCurrent Board:");
            case "Reset" -> // checks if the board was reset
                    System.out.println("Game " + update + "\nCurrent Board:");
            case "Cleared Game" ->  //check if game was cleared
                    System.out.println(update + "\nFinal Board:");
            default ->  //otherwise, prints out the direction that was pressed
                    System.out.println("Moved: " + update + "\nCurrent Board:");
        }
        StringBuilder Board = new StringBuilder();//makes a string of the field to print out how the game looks in a text based fashion
        for (int[] ints : field) {
            for (int j = 0; j < field[0].length; j++) {
                Board.append(ints[j]).append(", ");
            }
            Board.append("\n");
        }
        System.out.println(Board);
    }
}
