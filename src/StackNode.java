/* Dhruv Sharma
10/01/2020
12/15/2020
This is the file that arranges the node structure to be used by Stack.java.
*/

public class StackNode<E> {
    private E data;
    private StackNode lowerStack;

    public StackNode(){}

    public void setData(E Data){ data = Data; }

    public void setLowerNode(StackNode node){
        lowerStack = node;
    }

    public E getData() {
        return data;
    }

    public StackNode getLowerNode(){
        return lowerStack;
    }

}
