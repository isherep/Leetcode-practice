package Strings;

public class MultiplyStringNumbers {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length < 1) return num2;
        if(num2 == null || num2.length < 1) return num1;
        int i, j = 0;
        StringBuilder res = new StringBuilder();
        // need to store intermediate result somewhere
        /*
         756
          32
         ---
        1512
       2268
      -------
       24192


     32 = 30 and 2

     756 * 30 = 22680
     +
     756 * 5




        Karatsuba’s method gets away with only nine.

        */
        while( i < num1.length && j < num2.length){


            i++;
            j++;
        }

        return res.toString();
    }
}

public static void main(String[] args){
    def serialize(self, root: TreeNode) -> str:
    """Encodes a tree to a single string.
    """
    def ser_tree(node):
    nonlocal s
    if node:
    s+=f'{node.val} '
    ser_tree(node.left)
    ser_tree(node.right)
            else:
    s+='$ '

    s=""
    ser_tree(root)
    return s


    def deserialize(self, data: str) -> TreeNode:
    """Decodes your encoded data to tree.
    """

    t=iter(data.split())

    def des_tree():
    v=next(t)
    if v == '$':
    return None

    node = TreeNode(int(v))
    node.left=des_tree()
    node.right=des_tree()

    return node

    return des_tree()
}
