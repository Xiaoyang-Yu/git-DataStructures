package com.basics.array;

public class practice01 {
    public static void main(String[] args) {
       // 已知有个升序数组，要求插入一个元素，该数组仍然是升序数组
        // 比如： [10,12 45 90] 添加23后，数组为[10 12 23 45 90]

        int[] arr = {10, 12, 45, 90};
        int num = 2;
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arrNew[0] = num;
            arrNew[i + 1] = arr[i];
        }
        for (int i = 0; i < arrNew.length - 1; i++) {      // 控制总交换次数 = 数组length - 1
            for (int j = 0; j < arrNew.length - 1 - i; j++) {  // 每轮的比较次数。这里条件  - i是为了减少比较次数， 因为排序到后面的时候，后面的顺序是已经排序好了，就不用再比较了.
                int temp;
                if(arrNew[j] > arrNew[j + 1]){
                    temp = arrNew[j + 1];
                    arrNew[j + 1] = arrNew[j];
                    arrNew[j] = temp;
                }
            }
        }

        for (int i = 0; i < arrNew.length; i++) {
            System.out.println(arrNew[i]);
        }
    }
}
