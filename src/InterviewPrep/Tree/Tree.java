package InterviewPrep.Tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        // Creating the tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode node1 = root.left.left; // Node 4
        TreeNode node2 = root.right.right; // Node 7

        Tree t = new Tree();
        int distance = t.findDistanceBetweenNodes(root, node1, node2);
        System.out.println("Distance between nodes " + node1.val + " and " + node2.val + " is: " + distance);
    }

    public int findDistance(TreeNode root, TreeNode target, int distance){
        if(root == null){
            return -1;
        }
        if(root == target){
            return distance;
        }

        int leftDistance = findDistance(root.left, target, distance+1);
        if(leftDistance != -1){
            return leftDistance;
        }
        return findDistance(root.right, target, distance+1);
    }

     public int findDistanceBetweenNodes(TreeNode root, TreeNode node1, TreeNode node2){
        TreeAlgorithms treeAlgorithms = new TreeAlgorithms();
        TreeNode lca = treeAlgorithms.findLCA(root, node1, node2);
        int left = findDistance(lca, node1, 0);
        int right = findDistance(lca, node2, 0);

        return left + right;
     }

    public class TreeAlgorithms{
        TreeNode root;

        // Traversals
        // InOrder, PreOrder, PostOrder, LevelOrder
        public void inOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }
            inOrderTraversal(node.left);
            System.out.println(node.val + " --> ");
            inOrderTraversal(node.right);
        }

        public void preOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }
            System.out.println(node.val + " --> ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }

        public void postOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.val + " --> ");
        }

        public void levelOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                System.out.println(cur.val + " --> ");
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }

        public int height(TreeNode node){
            if(node == null){
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // LCA - Lowest common ancestor
        public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2){
            if(root == null){
                return null;
            }
            if(root == node1 || root == node2){
                return root;
            }

            TreeNode leftLCA = findLCA(root.left, node1, node2);
            TreeNode rightLCA = findLCA(root.right, node1, node2);

            if(leftLCA != null && rightLCA != null){
                return root;
            }
            return leftLCA != null ? leftLCA : rightLCA;
        }

        public Boolean isBinaryTreeBalanced(TreeNode root){
            return checkHeight(root) != -1 ? true : false;
        }

        public int checkHeight(TreeNode node){
            if(node == null){
                return 0;
            }

            int leftHeight = checkHeight(node.left);
            int rightHeight = checkHeight(node.right);

            if(leftHeight == -1 || rightHeight == -1){
                return -1;
            }

            if(Math.abs(leftHeight - rightHeight) > 1){
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public String serialize(TreeNode root){
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            System.out.println("Serialized Tree - " + sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode node, StringBuilder sb){
            if(node == null){
                sb.append("null, ");
                return;
            }

            sb.append(node.val).append(", ");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }

        public TreeNode deSerialize(String serializedTree){
            Queue<String> nodes = new LinkedList<>(Arrays.asList(serializedTree.split(", ")));
            return deSerializeHelper(nodes);
        }

        private TreeNode deSerializeHelper(Queue<String> nodes){
            String value = nodes.poll();
            if(value == "null"){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = deSerializeHelper(nodes);
            node.right = deSerializeHelper(nodes);
            return node;
        }
    }
}
