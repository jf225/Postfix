import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Stack Stack = new Stack();
        Scanner s = new Scanner(System.in);

        //This adds the initial Node in the stack
        System.out.println("Enter the first number in the stack:");
        Stack.push(s.next());

        //This checks to see if the Node was correctly placed at the top of the stack
        System.out.println("This should be the first number in the stack: " + Stack.peek());

        //Adds a second and third node to the stack
        System.out.println("Enter a second input:");
        Stack.push(s.next());

        System.out.println("Enter a third input:");
        Stack.push(s.next());

        //Gets rid of the top node and returns it along with the size of the stack after the node is removed
        System.out.println("This should be the last input you entered: " + Stack.pop());
        System.out.println("This should be the size (2): " + Stack.size());

        System.out.println("This should be the second input you entered: " + Stack.pop());
        System.out.println("This should be the size (1): " + Stack.size());

        System.out.println("This should be the first input you entered: " + Stack.pop());
        System.out.println("This should be the size (0): " + Stack.size());

        //This shows that the stack is empty after all the nodes are removed
        System.out.println("This will display true to show that the stack is empty: " + Stack.isEmpty());
    }
}
