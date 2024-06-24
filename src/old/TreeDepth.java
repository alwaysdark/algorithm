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

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        TreeNode left = new TreeNode(3);
        root.left = left;
        lowestCommonAncestor(root,left,right);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right != null){
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            return 1 + Math.min(l,r);
        }else if(root.left != null){
            int l = minDepth(root.left);
            int r = Integer.MAX_VALUE;
            return 1 + Math.min(l,r);
        }else {
            int r = minDepth(root.right);
            int l = Integer.MAX_VALUE;
            return 1+ Math.min(l,r);
        }
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
