package sudokusolver;

public class Helper {

    public Helper() {
    }

    private final int[][] sudokuKolay = {
        {9, 0, 0, 0, 7, 0, 0, 5, 0},
        {0, 8, 4, 0, 1, 6, 0, 3, 0},
        {0, 0, 0, 5, 0, 0, 1, 4, 0},
        {1, 0, 3, 0, 0, 0, 9, 2, 0},
        {6, 0, 8, 0, 0, 0, 4, 7, 0},
        {0, 0, 2, 0, 0, 9, 5, 8, 1},
        {8, 0, 7, 9, 0, 2, 0, 1, 4},
        {0, 0, 0, 0, 8, 0, 2, 6, 5},
        {2, 1, 0, 3, 6, 4, 0, 9, 0}
    };

    private final int[][] sudokuZor = {
        {1, 0, 0, 0, 0, 0, 0, 0, 4},
        {0, 5, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 7, 0, 0, 3, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0},
        {5, 0, 0, 0, 0, 0, 0, 0, 3}
    };

    // Tekrarları kontrol ediyoruz yoksa true dönüyoruz.
    public boolean isValid(int row, int col, int num, int[][] state) {
        return isDuplicatedInBox(row, col, num, state) || isDuplicatedInRow(row, num, state)
                || isDuplicatedInCol(col, num, state);
    }

    // Kolon içinde tekrar var mı ?
    private boolean isDuplicatedInCol(int col, int num, int[][] state) {
        for (int row = 0; row < 9; row++) {
            if (state[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Satır içinde tekrar var mı ?
    private boolean isDuplicatedInRow(int row, int num, int[][] state) {
        for (int col = 0; col < 9; col++) {
            if (state[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Kare içinde tekrar var mı ? 
    private boolean isDuplicatedInBox(int row, int col, int num, int[][] state) {
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[r + i][c + j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getSudokuKolay() {
        return this.sudokuKolay;
    }

    public int[][] getSudokuZor() {
        return this.sudokuZor;
    }

    public String printSudoku(int[][] state) {
        String strOutput = "+-----------------------+\n";
        for (int i = 0; i < 9; i++) {
            strOutput = strOutput + "| ";
            for (int j = 0; j < 9; j++) {
                if (state[i][j] != 0) {
                    strOutput = strOutput + state[i][j] + " ";
                } else {
                    strOutput = strOutput + "  ";
                }
                if (j % 3 == 2) {
                    strOutput = strOutput + "| ";
                }
            }
            strOutput = strOutput + "\n";
            if (i % 3 == 2) {
                strOutput = strOutput + "+-----------------------+\n";
            }
        }
        return strOutput;
    }
}
