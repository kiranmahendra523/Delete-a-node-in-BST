class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        TreeNode temp = root;
        TreeNode dump = delete(temp,key);
        return root;
    }
    public TreeNode delete(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            if((root.left==null)&&(root.right==null)){
                TreeNode temp = null;
                root=temp;
                return root;
            }
            else if(root.left==null){
                TreeNode temp = root.right;
                root = null;
                return temp;
            }
            else if(root.right==null){
                TreeNode temp = root.left;
                root = null;
                return temp;
            }
            else{
                TreeNode temp = maxNode(root.left);
                root.val = temp.val;
                root.left = delete(root.left,temp.val);
                return root;
            }
        }
        if(root.val<key){
            root.right = delete(root.right,key);
            return root;
        }
        else{
            root.left = delete(root.left,key);
            return root;
        }
    }
    public TreeNode maxNode(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}
