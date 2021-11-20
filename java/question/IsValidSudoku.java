package com.huang.question;


import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku {
    public static void main(String[] args) {
        /*
        [
        [".",".",".",".","5",".",".","1","."],
        [".","4",".","3",".",".",".",".","."],
        [".",".",".",".",".","3",".",".","1"],
        ["8",".",".",".",".",".",".","2","."],
        [".",".","2",".","7",".",".",".","."],
        [".","1","5",".",".",".",".",".","."],
        [".",".",".",".",".","2",".",".","."],
        [".","2",".","9",".",".",".",".","."],
        [".",".","4",".",".",".",".",".","."]]
         */
        char[][] board ={{'.','.','.','.','5','.','.','1','.'}
                        ,{'.','4','.','3','.','.','.','.','.'}
                        ,{'.','.','.','.','.','3','.','.','1'}
                        ,{'8','.','.','.','.','.','.','2','.'}
                        ,{'.','.','2','.','7','.','.','.','.'}
                        ,{'.','1','5','.','.','.','.','.','.'}
                        ,{'.','.','.','.','.','2','.','.','.'}
                        ,{'.','2','.','9','.','.','.','.','.'}
                        ,{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] area = new boolean[9][9];
        for(int i=0;i< 9;i++){
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if(c=='.')
                    continue;
                int u = c - '0';
                int index = i/3*3+j/3;
                if(rows[i][u]||cols[j][u]||area[index][u])
                    return false;
                rows[i][u]=cols[j][u]=area[index][u]=true;
                System.out.println("cols");
                for (boolean[] b:cols) {
                    for (boolean b1:b) {
                        System.out.print(b1+" ");
                    }
                    System.out.println();
                }
                System.out.println("rows");
                for (boolean[] b:rows) {
                    for (boolean b1:b) {
                        System.out.print(b1+" ");
                    }
                    System.out.println();
                }
                System.out.println("area");
                for (boolean[] b:area) {
                    for (boolean b1:b) {
                        System.out.print(b1+" ");
                    }
                    System.out.println();
                }
            }
        }
        return true;
    }
}
