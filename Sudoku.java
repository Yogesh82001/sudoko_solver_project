

public class Sudoku {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        {
        
             
       int sudoku[][] = { 
            
            {6,8,5,0,0,4,0,0,0},
            {0,9,0,1,0,0,3,0,2},
            {0,0,0,7,0,0,0,0,4},
            {0,0,3,0,9,0,5,0,0},
            {2,0,4,0,0,0,0,0,0},
            {1,0,0,5,0,0,6,0,8},
            {7,0,0,0,0,5,0,0,0},
            {0,0,6,0,0,2,9,0,1},
            {0,1,0,0,3,8,0,7,0}
        };
        
        
        if (sudokuSolver(sudoku, 0, 0)) {
            printSudoku(sudoku);          
        }
    }   }
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver (int sudoku[][],int row,int col){
        if(row==9){
            return true;
        }
        int nextRow = row,nextCol=col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol); 
        }
        for (int digit = 1; digit <= 9; digit++) {
                if (isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    } 
    public static boolean isSafe(int sudoku[][],int row,int col,int digit) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}
