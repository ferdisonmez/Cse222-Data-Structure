import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        System.out.println("*******Reversing-String********");
        String array="This function writes the sentence in reverse";
        System.out.println("Current String: "+array);
        System.out.print("Reverse String: ");
        reverse(array);


        System.out.println("\n**********Sorting-An-Array**************");
        int arr[] = {3, 1, 5, 2, 7, 0};
        System.out.print("Current Array: ");
        printArray(arr,0);
        System.out.println();
        System.out.print("Sorted Array: ");
        Sort(arr, arr.length, 0);
        printArray(arr,0);


        System.out.println("\n**********Spiral-Print**************");
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17,18,19,20}};

        SpiralArray(a, 0, 0, 5, 4);

        System.out.println("\n***********************Evaluating-Postfix-Expression********************************");

        Stack<String> stack=new Stack<>();
        String exp="32+";
        System.out.println("PostFix Expression: "+exp);
        System.out.println("PostFix evaluation: "+evaluatePostfix(stack,exp,0,exp.length()-1));

        System.out.println("\n******************************Elfish--Word*********************************************");
        String arrx="whiteleaf";
        System.out.print(arrx+":");
        Olustur(arrx);
        String arr1x="Gebze Teknik";
        System.out.print(arr1x+":");
        Olustur(arr1x);
        String arr2x="unfriendly";
        System.out.print(arr2x+":");
        Olustur(arr2x);

        System.out.println("\n****************Evaluating-Prefix-Expression*********************");

        try {

            Scanner console = new Scanner(System.in);
            System.out.println("This program evaluates prefix expressions");
            System.out.println("Operators +, -, *, / and %");
            System.out.print("Expression: ");
            System.out.println("Value = " + calculatePrefix(console));
        }
        catch (RuntimeException e){
            System.out.println("İllegal Operator:" +e.getMessage());
        }
        System.out.println("*******************************************************");
    }

    /***
     *Calculates the postfix result
     * @param stack is a data structure
     * @param exp is a string
     * @param len beginning of the string
     * @param size size of the string
     * @return result of postfix expression
     */
    public static int evaluatePostfix(Stack<String> stack,String exp,int len,int size)
    {
        int sayi=0;
        char c=exp.charAt(len);

        if (len>size)
            return 1;

        if(Character.isDigit(c)){
            stack.push(String.valueOf(c - 48));
        }

        else
        {
            int val1 = Integer.parseInt(stack.pop());
            int val2 = Integer.parseInt(stack.pop());

            switch(c)
            {
                case '+':
                    stack.push(String.valueOf(val2+val1));
                    break;

                case '-':
                    stack.push(String.valueOf(val2- val1));
                    break;

                case '/':
                    stack.push(String.valueOf(val2/val1));
                    break;

                case '*':
                    stack.push(String.valueOf(val2*val1));
                    break;
            }
            return Integer.parseInt(stack.pop());
        }

        return evaluatePostfix(stack,exp,len+1,size);
    }

    /***
     *Convert infix and calculate result
     * @param input
     * @return  returns the calculated result
     */
    public static double calculatePrefix(Scanner input) {
        if (input.hasNextDouble()) { ///if a number is integer this number is recorded
            return input.nextDouble();
        }
        else {     ///an operator
            String operator = input.next();
            double operand1 = calculatePrefix(input);
            double operand2 = calculatePrefix(input);
            return calculatePrefix(operator, operand1, operand2);
        }
    }

    /***
     * Calculates the result according to the given operands and operators
     * @param operator (+, -, *, / and %)
     * @param operand1 is number
     * @param operand2 is number
     * @return the result of the statement
     */
    public static double calculatePrefix(String operator, double operand1, double operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else if (operator.equals("%")) {
            return operand1 % operand2;
        } else {
            throw new RuntimeException(operator);
        }
    }

    /***
     * Prints the array recursive
     * @param arr is a one-dimensional integer array
     * @param x is the size of the array
     */
    public static void printArray(int[] arr, int x) {
        if (x >= arr.length)
        {
            return;
        }
        System.out.print(arr[x]+" ");
        printArray(arr,++x);
    }

    /***
     * Prints the given array in reverse according to the spaces
     * @param str is string
     */
   public static void reverse(String str)
    {
        int boslukIndex = str.lastIndexOf(" ");
        if(boslukIndex == -1){
            System.out.print(str);
            return;
        }
        System.out.print(str.substring(boslukIndex+1) + " ");
        reverse(str.substring(0,boslukIndex));
    }

    /***
     *Compares numbers in an integer array
     * @param a is integer array
     * @param i is a index
     * @param j is the element of the integer array
     * @return Returns the smallest element
     */
    public static int min(int a[], int i, int j)
    {
        if (i == j)
            return i;
        int k = min(a, i + 1, j);
        if (a[i]<a[k]){
            return i;
        }
        else
            return k;
    }

    /***
     * Sequencing recursive array of integers
     * @param a is integer array
     * @param n size of intger array
     * @param index is beginning of integer array
     */
    public static void Sort(int a[], int n, int index)
    {
        if (index == n)
            return;
        int k = min(a, index, n-1);
        if (k != index){
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        Sort(a, n, index + 1);
    }

    /***
     *Prints a two-dimensional array spirally in a single line
     * @param arr is a two-dimensional array
     * @param rowstart Start index of matrix
     * @param colstart Start index of matrix
     * @param rowend End index of matrix
     * @param colend End index of matrix
     */
    public static void SpiralArray(int arr[][], int rowstart, int colstart, int rowend, int colend)
    {
        if (rowstart >= rowend || colstart >= colend)
        {
            return;
        }
        for (int ax = rowstart; ax < colend; ax++)
        {
            System.out.print(arr[rowstart][ax] + " ");
        }

        for (int by = rowstart + 1; by < rowend; by++)
        {
            System.out.print(arr[by][colend - 1] + " ");
        }
        if ((rowend - 1) != rowstart)
        {
            for (int cz = colend - 2; cz >= colstart; cz--)
            {
                System.out.print(arr[rowend - 1][cz] + " ");
            }
        }
        if ((colend - 1) != colstart)
        {
            for (int dw = rowend - 2; dw > rowstart; dw--)
            {
                System.out.print(arr[dw][colstart] + " ");
            }
        }
        SpiralArray(arr, rowstart + 1, colstart + 1, rowend - 1, colend - 1);
    }
    /***
     *Searches for the character in the given string as recursion
     * @param someString is String
     * @param searchedChar is searched character
     * @param index is the starting place
     * @return number of characters
     */
    public static int countOccurences(String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }
        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(
                someString, searchedChar, index + 1);
    }

    /***
     *Decides if there is elfish word for word given
     * @param arr is String
     */
    public static void Olustur(String arr){
        int flag=-1;
        int count=0;
        char[] ara={'l','f','e'};
        for (int i = 0; i < ara.length; i++) {
            if(countOccurences(arr,ara[i],0)==0){
                flag=1;
                break;
            }
            else{
                count++;
            }
        }
        if (flag==1){
            System.out.println("Not elfish words");
        }
        else if (count==3){
            System.out.println("Elfish words");
        }
    }

}
