public class Ox {
    public String player;
    private String[][] table = {
            {" " ,"0" ,"1" ,"2" },
            {"0" ,"-" ,"-" ,"-" },
            {"1" ,"-" ,"-" ,"-" },
            {"2" ,"-" ,"-" ,"-" },
    };


    private int countX;
    private int countO;
    private int countDraw;

    public Ox(){
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;
    }

    public String getTableString() {
        String result = "";
        for(int row=0 ; row<table.length ; row++ ){
            for(int col=0 ; col<table[row].length ; col++ ){
                result = result + table[row][col];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int row, int col) {
        try {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            } else {
                table[row + 1][col + 1] = getCurrentPlayer();
                return true;
            }
        }catch (Exception ex){
            return false;
        }
    }

    public void switchPlayer() {
        Ox ox = new Ox();
        if(player.equals("X")) {
            player = "O";
        }else{
            player = "X";
        }
    }

    public boolean checkWin(int row, int col) {
        int check=1;
        int r=row;
        int c=col;
        int num=1;

        for(r = 0; r < 3; r++) {
            for (c = 0; c < 3; c++) {
                if(table[row + 1][c + 1].equals("O") ||
                   table[row + 1][c + 1].equals("X")){
                    num++;
                }
            }
        }
        if(num==9){
            countDraw++;
            return true;
        }
            if(player.equals("O")) {
                for (c = 0; c < 3; c++) {
                    if(c+1==col+1) {

                    }else {
                        if (table[row + 1][c + 1].equals("O")) {
                            check++;
                        }
                    }
                }
                for (r = 0; r < 3; r++) {
                    if(r+1==row+1) {

                    }else {
                        if (table[r + 1][col + 1].equals("O")) {
                            check++;
                        }
                    }
                }
                for(r = 0; r < 3; r++){
                    if (table[r + 1][r + 1].equals("O") ) {
                        check++;
                    }
                }

                for(r = 0,c = 3; r < 3 && c >= 0; r++,c--){
                    if(table[r+1][c].equals("O")){
                        check++;
                    }
                }
                if(check==5 && num != 9) {
                    countX++;
                    return true;
                }

            }else if(player.equals("X")) {
                for (c = 0; c < 3; c++) {
                    if (c + 1 == col + 1) {

                    } else {
                        if (table[row + 1][c + 1].equals("X")) {
                            check++;
                        }
                    }
                }
                for (r = 0; r < 3; r++) {
                    if (r + 1 == row + 1) {

                    } else {
                        if (table[r + 1][col + 1].equals("X")) {
                            check++;
                        }
                    }
                }
                for (r = 0; r < 3; r++) {
                    if (table[r + 1][r + 1].equals("X")) {
                        check++;
                    }
                }

                for (r = 0, c = 3; r < 3 && c >= 0; r++, c--) {
                    if (table[r + 1][c].equals("X")) {
                        check++;
                    }
                }
                if(check==5 && num != 9) {
                    countO++;
                    return true;
                }
            }

        return false;
    }

}
