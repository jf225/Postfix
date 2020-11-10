import java.util.Scanner;

public class PostfixCalculator<E>{
    Scanner s = new Scanner(System.in);
    public Stack main = new Stack();
    public Stack temp = new Stack();
    String[] input;
    boolean isOperator;
    boolean isInt1;
    boolean isInt2;
    Object operatorObj;
    String operatorStr;
    Object int1Obj;
    int int1;
    Object int2Obj;
    int int2;

    public void setEquation(int length, String str){
        input = new String[length];
        input = str.split(" ");
        for(int i = 0; i < input.length; i++){
            main.push(input[i]);
        }
    }

    public PostfixCalculator(){}

    public void doOperation(){
        while(main.size() >= 1){
            System.out.println("doing operation");
            if(main.peek().toString().equals("+") || main.peek().toString().equals("-") || main.peek().toString().equals("*") || main.peek().toString().equals("/")){
                isOperator = true;
                operatorObj = main.peek();
                operatorStr = operatorObj.toString();
                System.out.println("Operator Found");
            }
            temp.push(main.pop());
            try{
                int1Obj = main.peek();
                int1 = (int) int1Obj;
                isInt1 = true;
                System.out.println("first int");
            }
            catch(Exception e){
                isInt1 = false;
            }
            temp.push(main.pop());
            try{
                int2Obj = main.peek();
                int2 = (int) int2Obj;
                isInt2 = true;
                System.out.println("second int");
            }
            catch(Exception e){
                isInt2 = false;
            }
            temp.push(main.pop());
            if(isOperator && isInt1 && isInt2){
                temp.pop();
                temp.pop();
                temp.pop();
                if(operatorStr.equals("+")){
                    temp.push(int1 + int2);
                }
                if(operatorStr.equals("-")){
                    temp.push(int1 - int2);
                }
                if(operatorStr.equals("*")){
                    temp.push(int1 * int2);
                }
                if(operatorStr.equals("/")){
                    temp.push(int1 / int2);
                }
                System.out.println("doign operation");
            }
            else{
                main.push(temp.pop());
                main.push(temp.pop());
            }
        }
        temp.push(main.pop());
        for(int i = 0; i < temp.size(); i++){
            main.push(temp.pop());
        }
    }

    public void Calculate(){
        while(main.size() >= 1){
            doOperation();

            System.out.println("Loop");
        }
        System.out.println((int) main.peek());
    }

}
