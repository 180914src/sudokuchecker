package net.xoono;

public class SudokuValidator {

    int expectedResult = 45;

    boolean validate(int[][] data) {
      return validateTotalHorizontally(data) && validateTotalVertically(data) && validateCells(data);
    }

    boolean validateTotalHorizontally(int[][] data) {
        for(int i=0; i<9; i++) {
            int lineResult=0;
            for(int j=0; j<9; j++) {
                lineResult += data[i][j];
            }
            if(lineResult != expectedResult) return false;
        }
        return true;
    }

    boolean validateTotalVertically(int[][] data) {
        for(int j=0; j<9; j++) {
            int columnResult=0;
            for(int i=0; i<9; i++) {
                columnResult += data[i][j];
            }
            if(columnResult != expectedResult) return false;
        }
        return true;
    }

    boolean validateCells(int[][] data) {
        for(int xx=0; xx < 9; xx= xx + 3) {
            for(int yy=0; yy < 9 ; yy= yy+ 3) {
                int cellResult = 0;
                for(int x=0; x < 3; x++) {
                    for(int y=0; y<3; y++) {
                        cellResult += data[xx + x][yy + y];
                    }
                }
                if(cellResult!=expectedResult) return false;
            }
        }
        return true;
    }
}
