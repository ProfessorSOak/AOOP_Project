
public class ObserverCollection implements BoardObserver{

    @Override
    public void UpdateBoard(int[][] field, String update) {

        if(update.equals("Reset")){
            System.out.println("Game " + update + "\nCurrent Board:");
        }

        else if(update.equals("Cleared Game")){
            System.out.println(update + "\nFinal Board:");
        }
        else {
            System.out.println("Moved: " + update + "\nCurrent Board:");
        }
        StringBuilder Board = new StringBuilder();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                Board.append(field[i][j]).append(", ");
            }
            Board.append("\n");
        }
        System.out.println(Board);
    }
}
