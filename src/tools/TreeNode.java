package tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static TreeNode input(int[] arrs){
        if(arrs.length==0)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (int a : arrs) 
            nodes.add(new TreeNode(a));
        for (int i = 0; i < arrs.length/2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i*2 + 1);
            node.right = nodes.get(i*2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arrs.length/2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex*2 + 1);
        if (arrs.length%2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex*2 + 2);
        }
        return nodes.get(0);
    }

    public static void output(TreeNode pRoot){
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        if(pRoot != null) {
            queue1.add(pRoot);
            while(!queue1.isEmpty()) {
                LinkedList<TreeNode> queue2 = new LinkedList<>();
                while(!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    System.out.print(node.val+" ");
                    if(node.left != null)
                        queue2.add(node.left);
                    if(node.right != null)
                        queue2.add(node.right); 
                }
                System.out.println();
                queue1 = queue2;
            }
        }
    }
}