/* Dhruv Sharma, Jim Fahey, Jack Greco
10/01/2020
12/15/2020
This is the main file that defines the PostfixCalculator class and solves equations in Postfix notation.
*/

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
    String int1Obj;
    int int1;
    String int2Obj;
    int int2;

    public void setEquation(int length, String str){ //reads in equation and removes spaces
        input = new String[length];
        input = str.split(" ");
        for(int i = 0; i < input.length; i++){
            main.push(input[i]);
        }
    }

    public PostfixCalculator(){}

    public String doOperation(){ //does the Postfix calculations
        String answer = "";
        while(true){
            System.out.println("doing operation");
            System.out.println(main.peek());
            isOperator = false;
            isInt1 = false;
            isInt2 = false;
            if(main.peek().toString().equals("+") || main.peek().toString().equals("-") || main.peek().toString().equals("*") || main.peek().toString().equals("/")){
                isOperator = true;
                operatorObj = main.peek();
                operatorStr = operatorObj.toString();
                System.out.println("Operator Found");
            }
            temp.push(main.pop());
            try{
                int1Obj = main.peek().toString();
                int1 = Integer.parseInt(int1Obj);
                isInt1 = true;
                System.out.println("first int");
            }
            catch(Exception e){
                isInt1 = false;
            }
            temp.push(main.pop());
            try{
                int2Obj = main.peek().toString();
                int2 = Integer.parseInt(int2Obj);
                isInt2 = true;
                System.out.println("second int");
            }
            catch(Exception e){
                isInt2 = false;
            }
            System.out.println(isOperator);
            System.out.println(isInt1);
            System.out.println(isInt2);

            temp.push(main.pop());
            if(isOperator && isInt1 && isInt2){ //if in the order operation int int when popping
                temp.pop();
                temp.pop();
                temp.pop();
                if(operatorStr.equals("+")){
                    temp.push(int1 + int2);
                    System.out.println("did operation");
                }
                if(operatorStr.equals("-")){
                    temp.push(int2 - int1);
                }
                if(operatorStr.equals("*")){
                    temp.push(int1 * int2);
                }
                if(operatorStr.equals("/")){
                    temp.push(int2 / int1);
                }
                System.out.println("doign operation");
                System.out.println(temp.size());
                System.out.println(main.size());


                while(temp.size() > 0){ //push everything from temp back into main
                    main.push(temp.pop());
                }
                System.out.println(main.peek());
            }
            else{ //pop 2 of the 3 elements from temp back into main
                System.out.println("we in else");
                main.push(temp.pop());
                main.push(temp.pop());
            }

            if(main.size() == 1) //operation done
            {
                System.out.println(main.peek());
                answer = main.pop().toString();
                break;
            }

        }
        return answer;
    }

    public String Calculate(){ //a very useful method, don't question it
        String answer = doOperation();
        System.out.println("Answer: " + answer);
        return answer;
    }

}
