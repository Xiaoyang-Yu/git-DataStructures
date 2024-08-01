package com.learning.binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListMediumLeetCode102 {

    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    /**
     * 给定二叉树的根，返回其节点值的层序遍历。 （即从左到右，逐级）。<br/>
     * 例如：<br/>
     * Input: root = [3,9,20,null,null,15,7]<br/>
     * Output: [[3],[9,20],[15,7]]<br/>
     * @param root --树的root节点
     * @return -- 集合
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list1 = new ArrayList<>();
        if (root == null){
            return list1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //1. 先把root节点加入到队列中
        int num1 = 1;   //默认root是当前节点，节点数 = 1

        while (!queue.isEmpty()){  //循环不断进行出队和入队操作
            List<Integer> list2 = new ArrayList<>();
            int num2 = 0; //下一层节点数 ： 每一层节点数不能确定，所以在下面进行入队操作的时候，入队成功就记录1个节点
            for (int i = 0; i < num1; i++){ //根据当前层节点数，循环把节点加入到队列 和 集合中。
                TreeNode node = queue.poll();  //获取当前队列头节点，
                list2.add(node.val);            //头节点加入结合
                if (node.left != null){       //判断当前节点下是否存在left子节点
                    queue.offer(node.left);   //加入队列
                    num2++;                   //统计下一层节点数： +1
                }
                if (node.right != null){        //判断当前节点下是否存在right子节点
                    queue.offer(node.right);
                    num2++;
                }
            }
            num1 = num2;                //把下一层的节点数赋值给当前层的节点数
            list1.add(list2);           //加入外层集合
        }
        return list1;
    }
}
