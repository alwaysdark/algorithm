package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/24 15:04
 * @Description:
 **************************************/
public class TreeDepth {

    public static void main(String[] args) {

    }


    public static int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        if(root.left != null || root.right != null){
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            if( l >= r){
                return 1 + l;
            }else{
                return 1 + r;
            }
        }
        return 1;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
