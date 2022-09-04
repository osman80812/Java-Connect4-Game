public class Board {
    private int rows;
    private int cols;
    private char board[][];
    //private int turns = 0;

    public Board(int row, int column){
        rows = row;
        cols = column;
        board = new char[rows][cols];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '-';
            }
        }
    }

    public void debug(int num) {
        if(num == 7) {
            System.out.println("0  1  2  3  4  5  6");
        } else if(num == 9){
            System.out.println("0  1  2  3  4  5  6  7  8");
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    public int checkFor3(char player){
        //for row
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 2; j++) {
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player
                        && (j+3) < board[0].length){
                    return j+3;
                }
            }
        }
        //for column
        for(int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player) {
                    return j;
                }
            }
        }
        //for upward diagonal
        for(int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 2; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player
                    && (j+3) < board[0].length && (i - 3) >= 0) {
                    return j + 3;
                }
            }
        }
        //for downward diagonal
        for(int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board[0].length - 2; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
                    && (j + 3) < board[0].length && (i + 3) < board.length) {
                    return j - 3;
                }
            }
        }
        return 0;
    }

    public int checkFor4(char player){
        //for row
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player
                        && (j+4) < board[0].length){
                    return j+4;
                }
            }
        }
        //for column
        for(int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player) {
                    return j;
                }
            }
        }
        //for upward diagonal
        for(int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player
                        && (j+4) < board[0].length && (i - 4) >= 0) {
                    return j + 4;
                }
            }
        }
        //for downward diagonal
        for(int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player
                        && (j + 4) < board[0].length && (i + 4) < board.length) {
                    return j - 4;
                }
            }
        }
        return 0;
    }

    public boolean dropNormal(int col, char player){
        int blockCol;
        int winCol;
        //check if there is 3 in a row
        if(player == 'O'){
            blockCol = checkFor3('X');
            winCol = checkFor3('O');
            if(winCol != 0 && board[0][winCol] == '-'){
                col = winCol;
            } else if(blockCol != 0 && board[0][blockCol] == '-'){
                col = blockCol;
            }
        }
        if(col < 0 || col >= board[0].length) {
            return false;
        } else {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][col] == '-') {
                    this.board[i][col] = player;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dropExpert(int col, char player){
        int blockCol;
        int winCol;
        //check if there is 3 in a row
        if(player == 'O'){
            blockCol = checkFor4('X');
            winCol = checkFor4('O');
            if(winCol != 0 && board[0][winCol] == '-'){
                col = winCol;
            } else if(blockCol != 0 && board[0][blockCol] == '-'){
                col = blockCol;
            }
        }
        //loop to place a player in the column
        if(col < 0 || col >= board[0].length) {
            return false;
        } else {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][col] == '-') {
                    this.board[i][col] = player;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean connectsFour(char player){
        //for row
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player) {
                    return true;
                }
            }
        }
        //for column
        for(int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player) {
                    return true;
                }
            }
        }
        //for upward diagonal
        for(int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i-3][j+3] == player) {
                    return true;
                }
            }
        }
        //for downward diagonal
        for(int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean connectsFive(char player){
        //for row
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 4; j++) {
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player && board[i][j+4] == player) {
                    return true;
                }
            }
        }
        //for column
        for(int i = 0; i < board.length - 4; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player && board[i+4][j] == player) {
                    return true;
                }
            }
        }
        //for upward diagonal
        for(int i = 4; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 4; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i-3][j+3] == player && board[i-4][j+4] == player) {
                    return true;
                }
            }
        }
        //for downward diagonal
        for(int i = 0; i < board.length - 4; i++) {
            for (int j = 0; j < board[i].length - 4; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player && board[i+4][j+4] == player) {
                    return true;
                }
            }
        }
        return false;
    }

}
