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
