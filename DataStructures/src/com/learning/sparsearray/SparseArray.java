package com.learning.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        //二维数组创建
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[5][6] = 2;
        int sum = 0;  //确定chessArray1中有几个有效数据（非0数据）
        for (int[] array1 : chessArray1) {
            for (int val : array1) {
                if (val != 0){
                    sum++;
                }
                //System.out.print(val + " ");
            }
            //System.out.println();
        }
        //转换成SparseArray, 第一行表示， 原始数组中，共有多少行，多少列，多少个非0的值
        // 稀疏数组的样子： 转换成SparseArray[3][3]
        //      row   col   value
        // 0    11   11     2
        // 1    1    2      1
        // 2    2    3      2
        //1. 创建数组 -- 确定SparseArray数组有几行，sum+1 行
        int[][] sparseArray = new int[sum+1][3];
        //2. 给数组第一行赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //3. 赋值非0数据给Sparse Array
        //4. 创建count用于计数，记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;  // i 表示该值在chessArray1数组中的第几行
                    sparseArray[count][1] = j;  // j 表示该值在chessArray1数组中的第几列
                    sparseArray[count][2] = chessArray1[i][j]; // sparseArray最后一列存放该值
                }
            }
        }
        for (int[] row: sparseArray) {
            for (int value: row) {
                //System.out.print(value + " ");
            }
            //System.out.println();
        }
        // -----------------------------------------------------------------------------------------
        // Sparse Array 恢复成 二维数组
        //1. 读取稀疏数组第一行，确定二维数组大小
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2. 从第二行开始读取数据，分别赋值给二维数组 i=1表示从第二行开始读取
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row: chessArray2) {
            for (int value: row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
