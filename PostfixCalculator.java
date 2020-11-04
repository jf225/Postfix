import java.util.Scanner;

public class PostfixCalculator<E>{
    Scanner s = new Scanner(System.in);
    public Stack main = new Stack();
    public Stack temp = new Stack();
    private Stack a;
    private Stack b;
    private boolean isFliped = false;


    public PostfixCalculator(){}

    public void fixOrder(){
        if(a.peek().getClass() == "string".getClass()){
            System.out.println("Order already fixed");
        }
        if(a.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            do{
                b.push(a.pop());
            }while(!a.isEmpty());
        }
        if(isFliped){
            main = b;
            temp = a;
        }
        else{
            main = a;
            temp = b;
        }
    }

    public void setStacks(){
        if(!main.isEmpty()){
            a = main;
            b = temp;
            isFliped = false;
        }
        else{
            a = temp;
            b = main;
            isFliped = true;
        }
    }

    public boolean isEmpty(){
        if(main.isEmpty() && temp.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public void addEquation(){
        System.out.println("Give the length of the equation: ");
        int length = s.nextInt();
        System.out.println("Give Equation: ");
        for(int i = 0; i < length; i++){
            main.push(s.next());
        }
    }

    public int doOperation(){
        boolean foundOperator = false;
        boolean foundInt1 = false;
        boolean foundInt2 = false;

        Object operator;
        Object int1;
        Object int2;

        int answer = 0;
        do{
            if(a.peek() == "+" || a.peek() == "-" || a.peek() == "*" || a.peek() == "/"){
                foundOperator = true;
                operator = a.peek();
            }
            b.push(a.pop());
            if(a.peek().getClass() == int.class){
                foundInt1 = true;
                int1 = a.peek();
            }
            b.push(a.pop());
            if(a.peek().getClass() == int.class){
                foundInt2 = true;
                int2 = a.peek();
            }
            b.push(a.pop());
            if(foundOperator && foundInt1 && foundInt2){
                b.pop();
                b.pop();
                b.pop();
            }
        }while(!foundOperator && !foundInt1 && !foundInt2);
        return answer;
    }

    public int calculate(){
        int answer = 0;
        addEquation();

        return answer;
    }

}
