package com.basics.array;

public class Yanghui {
    /*
    使用二维数组打印一个十行的杨辉三角形（int[i][j], i表示行，j表示列）
    1
    1   1
    1   2   1
    1   3   3   1
    1   4   6   4   1
    1   5   10  10  5   1
    规律是： yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
    1. 第一行有一个元素，第n行有n个元素
    2. 每一行的的第一个元素和最后一个元素都是1
    3. 从第三行开始，对于非第一个元素和最后一个元素的值. = arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
    * */
    public static void main(String[] args) {
        int[][] yangHui = new int[10][];
        for (int i = 0; i < yangHui.length; i++) { //遍历二维数组
            //给每一行赋值
            yangHui[i] = new int[i+1];
            for (int j = 0; j < yangHui[i].length; j++) {
                if( j == 0 || j == yangHui[i].length - 1){
                    yangHui[i][j] = 1;  //每一行的第一个和最后一个元素的值
                }else{
                    yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];   //中间的 值
                }
            }
        }
        //遍历
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
