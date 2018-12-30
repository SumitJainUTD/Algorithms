package MacLaptop.ThirdLot.PopulatingNextRightPointers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjain on 9/16/17.
 */
public class PopulatingNextRightPointers {
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList();
        if(root.left!=null)
            queue.add(root.left);
        if(root.right!=null)
            queue.add(root.right);

        while(queue.isEmpty()==false){
            int size = queue.size();
            TreeLinkNode temp = null;
            while(size>0){
                TreeLinkNode current = queue.remove();
                if(temp!=null){
                    temp.next = current;
                }
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
                temp = current;
                size--;
            }
        }

    }
}

class TreeLinkNode {
       int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
