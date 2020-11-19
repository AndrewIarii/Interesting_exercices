import java.util.ArrayList;
import java.util.List;

public class isSimple {

    public static void main(String[] args){

        System.out.println(isPrime(17));

        System.out.println(CountOfPrimes(100));
    }

    //простое ли число
    public static boolean isPrime(int a){
        boolean flag=false;
        for (int i=2; i<a;i++){
            if (a%i==0){
                flag = true;
                break;
            }
                flag=false;
        }
        return flag;
    }

    //количество простых чисел до переданного значения
    //вывод простых чисел до заданного значения
    public static int CountOfPrimes(int a){
        List<Integer> ListOfPrimes=new ArrayList<Integer>();
        boolean flag=false;
        int countPrime=0;//количество простых

        for (int i=2;i<a;i++){
            flag=true;//изначально считает что число простое
            for (int j=2;j<i;j++){//для каждого числа до введеного проверяет условие
                if(i%j==0){
                    flag = false;//если число не простое выход из внутреннего цикла
                    break;
                }
            }
            //если число оказывается простым, увеличивается счетчик и число добавляется в коллекцию
            if (flag){
                countPrime++;
                ListOfPrimes.add(i);
            }
        }
        System.out.println(ListOfPrimes);
        return countPrime;
    }

}
