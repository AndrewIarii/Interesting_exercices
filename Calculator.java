import java.util.Scanner;

public class Calculator {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int A=in.nextInt();
        System.out.println("Введите знак");
        String C=in.next();
        System.out.println("Введите второе число");
        int B=in.nextInt();


        Calculator(C,A,B);

    }

    public static void Calculator(String C,int A,int B){

        if(C.equals("+")){
            System.out.println(A+B);
        }
        else if(C.equals("-")){
            System.out.println(A-B);
        }
        else if(C.equals("*")){
            System.out.println(A*B);
        }
        else if(C.equals("/") && B==0){
            System.out.println("Деление на ноль");
        }
        else if(C.equals("/")&& B!=0){
            System.out.println(A/B);
        }
        else if(C.equals("mod")||C.equals("%") && B==0){
            System.out.println("Деление на ноль");
        }
        else if(C.equals("mod")||C.equals("%") && B!=0){
            System.out.println(A%B);
        }
        else System.out.println("Error");
    }
}
