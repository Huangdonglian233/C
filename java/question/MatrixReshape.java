package com.huang.question;
/*
在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。

给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。

重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。

如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reshape-the-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixReshape {
    public static void main(String[] args) {
        int[][] mat={{1,2}};
        int[][] result=matrixReshape(mat,1,1);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c)
            return mat;
        int[][] result = new int[r][c];
        int k=0;
        int s=0;
        for(int i=0;i<mat.length;i++) {
            for (int num : mat[i]) {
                result[s][k] = num;
                k++;
                if(k>=c) {
                    k = 0;
                    s++;
                }
                if(s>=r)
                    break;
            }
        }
        return result;
    }
}
