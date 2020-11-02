public class Stack<E> {
    private int size = 0;
    private StackNode topNode = new StackNode();

    public Stack(){}

    void push(E data){
        StackNode temp = new StackNode();
        temp.setData(data);
        temp.setLowerNode(topNode);
        topNode = temp;
        size++;
    }

    public Object pop(){
        StackNode temp = topNode;
        if(size == 0) {
            topNode.setData(null);
        }
        else{
            topNode = topNode.getLowerNode();
        }
        size--;
        return temp.getData();
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public Object peek(){
        return topNode.getData();
    }
}
