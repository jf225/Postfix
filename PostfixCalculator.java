import java.util.Scanner;

public class PostfixCalculator<E>{
    Scanner s = new Scanner(System.in);
    public Stack main = new Stack();
    public Stack temp = new Stack();
    private Stack a;
    private Stack b;
    private boolean isFliped = false;
    private boolean calcFinished = false;
    private int answer;


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

    public void isEmpty(){
        if(main.size() <= 1 && temp.size() <= 1){
            calcFinished = true;
        }
        else{
            calcFinished = false;
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

        Object operator = "temp";
        Object int1 = 0;
        Object int2 = 0;

        int permint1 = (int) int1;
        int permint2 = (int) int2;

        int answer = 0;
        do{
            foundOperator = false;
            foundInt1 = false;
            foundInt2 = false;
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
                operator.toString();
                if ("+".equals(operator)) { answer = permint1 + permint2; }
                if ("-".equals(operator)) { answer = permint1 - permint2;  }
                if ("*".equals(operator)) { answer = permint1 * permint2;  }
                if ("/".equals(operator)) { answer = permint1 / permint2;  }
                b.push(answer);
            }
        }while(!foundOperator && !foundInt1 && !foundInt2);
        isEmpty();
        return answer;
    }

    public void findAnswer(){
        if(calcFinished){
            if(main.isEmpty()){
                answer = (int) temp.peek();
            }
            else{
                answer = (int) main.peek();
            }
        }
    }

    public int calculate(){
        addEquation();
        do {
            setStacks();
            doOperation();
            setStacks();
            fixOrder();
        } while(!calcFinished);
        findAnswer();
        return answer;
    }

}
