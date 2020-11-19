import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strings {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("CountOfSubstring "+CountOfSubstring("bob","adadabobobasd"));
        System.out.println(isPalindrome("abba")+"  'abba'");
        System.out.println("Double chars in 'asd' "+doubleChar("asd"));
        System.out.println("Bob there? 'dfsdfbobasdsa' - "+bobThere("dfsdfbobasdsa"));
        System.out.println("MaxBlock in hoopla "+maxBlock("hoopla")+" Max block "+maxBlock("abbCCCddBBBxx"));
        System.out.println("Repeat separator X "+repeatSeparator("Word", "X", 3));
        System.out.println("Sum digits in string 'a55b3u8' = "+sumDigits("a55b3u8"));

    }

    //считает количество вхождений первой строки в вторую
    public static int CountOfSubstring(String a, String b){
        int countSub=0;
        int lengthA=a.length();

        if(a.length()>b.length()){
            System.out.println("Нет совпадений");
        }else{
            for(int i=0;i<b.length()-lengthA;i++){
                if (a.equals(b.substring(i,(i+lengthA)))){//проверка совпадений первой строки с подстрокой из второй
                    countSub++;//счетчик кол-ва совпадений
                    i+=(lengthA-1);//переход вперед на длину первого слова, для избежаний учета bobob как два вхождения
                }
            }
        }
        return countSub;

    }

    //Палиндром ли строка
    public static boolean isPalindrome(String str){

        //с использованием StringBuilder
        if (str.equals(new StringBuilder(str).reverse().toString())){//сравнение начальной строки с перевернутой
            System.out.print("Это палиндром ");
        }else {
            System.out.print("Это не палиндром ");}


        //с использованием цикла
        //проверка равенста эллементов с начала и конца
        for (int i=0;i<str.length()/2;i++){//делим длину на два т.к одновременно с двух направлений проверка
            if (str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }return true;
    }


//  exercice from codingbat.com
//  Given a string, return a string where for every char in the original, there are two chars.
    public static String doubleChar(String str){
        String newstr="";
        for(int i=0;i<str.length();i++){
            newstr+=str.substring(i,i+1)+str.substring(i,i+1);
        }
        return newstr;
    }

//    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    public static boolean bobThere(String str) {
        for(int i=0;i<str.length()-2;i++){
            if(str.substring(i,i+1).equals("b")&&str.substring(i+2,i+3).equals("b"))
                return true;
        }return false;
    }

    //Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
    // separated by the separator string.
    //repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    //repeatSeparator("This", "And", 2) → "ThisAndThis"
    //repeatSeparator("This", "And", 1) → "This"
    public static String repeatSeparator(String word, String sep, int count) {
        String result="";

        for(int i=0;i<count;i++){
            if(i==count-1){
                result+=word;
                break;
            }
            result+=word+sep;
        }
        return result;
    }



    //Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
    public static int sumDigits(String str) {
        int count=0;

        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){

                count+=Integer.parseInt(str.substring(i,i+1));
            }
        }
        return count;
    }

    //Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
    //
    //maxBlock("hoopla") → 2
    //maxBlock("abbCCCddBBBxx") → 3
    //maxBlock("") → 0
    public static int maxBlock(String str) {
        if(str.equals("")){return 0;}

        List<Integer> countOfChars=new ArrayList<Integer>();
        int count=1;

        for(int i=0;i<str.length()-1;i++){

            if(str.charAt(i)==str.charAt(i+1)){
                count++;

            }

            else {
                countOfChars.add(count);
                count=1;
            }
        }

        return Collections.max(countOfChars);
    }





}
