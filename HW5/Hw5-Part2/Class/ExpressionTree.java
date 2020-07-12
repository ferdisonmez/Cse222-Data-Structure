public class ExpressionTree extends BinaryTree<Character>{
    /***
     * I wanted to send it to the add function to clear the spaces in the string and add them to the tree structure respectively
     * @param str The statement taken from the user
     */
    public ExpressionTree(String str){
        str=str.trim();
        System.out.println(str);
        String[] karakter=str.split(" ");
        for (int i=0;i<karakter.length;i++){
            add(karakter[i].charAt(0));
        }
        preOrder(root);
        System.out.println();

    }
    /***
     * I wanted to split the expression taken as a string into pieces according to the spaces and create a tree structure with this function
     * @param value  is expression part to be added
     */
    public void add(char value) {
        root = addRecursive(root, value);
    }

    private Node<Character> addRecursive(Node<Character> current, char value) {
        if(current!=null && isOperator(current.data)) {
             current.left=addRecursive(current.left,value);
             current.right=addRecursive(current.right,value);
            return current;
        }
        else {
            return new Node<Character>(value) ;
        }
    }

    /***
     * Decides whether the expression is a digit
     * @param ch is the character to be looked after
     * @return if expression is number function is returned 1
     */
    private boolean isDigit(char ch)
    {
        return ch >= '0' && ch <= '9';
    }

    /***
     * function to check if operator
     * @param ch is the character to be looked after
     * @return is decided operator
     */
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /***
     * function to convert character to digit
     * @param ch is the character to be looked after
     * @return  the number value
     */
    private int toDigit(char ch)
    {
        return ch - '0';
    }

    /***
     * Function to evaluate tree
     * @param ptr is the starting node of the tree structure
     * @return  the calculated expression
     */
    public double evaluate(Node<Character> ptr)
    {
        if (ptr.left == null && ptr.right == null)
            return toDigit(ptr.data);
        else
        {
            double result = 0.0;
            double left = evaluate(ptr.left);
            double right = evaluate(ptr.right);
            char operator = ptr.data;

            switch (operator)
            {
                case '+' : result = left + right; break;
                case '-' : result = left - right; break;
                case '*' : result = left * right; break;
                case '/' : result = left / right; break;
                default  : result = left + right; break;
            }
            return result;
        }
    }

    /***
     * Postorder traversal
     * @param ptr is the starting node of the tree structure
     */
    private void postOrder(Node<Character> ptr)
    {
        if (ptr != null)
        {
            postOrder(ptr.left);
            postOrder(ptr.right);
            System.out.print(ptr.data);
        }
    }

    /***
     * inorder traversal
     * @param ptr is the starting node of the tree structure
     */
    private void inOrder(Node<Character> ptr)
    {
        if (ptr != null)
        {
            inOrder(ptr.left);
            System.out.print(ptr.data);
            inOrder(ptr.right);
        }
    }

    /***
     * Preorder traversal
     * @param ptr is the starting node of the tree structure
     */
    private void preOrder(Node<Character> ptr)
    {
        if (ptr != null)
        {
            System.out.print(ptr.data);
            preOrder(ptr.left);
            preOrder(ptr.right);
        }
    }

}//ExpressionTree
