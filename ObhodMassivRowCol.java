import java.util.Scanner;

public class ObhodMassivRowCol {

    public static void main(String[] args) {//начало метода public static void main с аргументами
        int i,j, n; //создаем переменные типа целочисленный
        int count=0;
        Scanner in = new Scanner (System.in);//создаем объект класса Сканер
        System.out.println("Размер матрицы:");
        n = in.nextInt();
        int[][] A = new int [n][n];


        //вывод матрицы
        System.out.println("Вывод матрицы");

        for (i=0; i<n; i++)//начало цикла
        {
            System.out.println();
            for (j=0; j<n; j++)
            {
                count++;
                A[i][j]=count;
                System.out.print(A[i][j]+"\t");
            }
        }




        System.out.println("\nЭлементы по строкам:");
        for (i=0; i<n; i++)
            for (j=0; j<n; j++)
            {
                System.out.print(A[i][j]+" ");
            }

        System.out.println("\nЭлементы по столбцам :");
        for (j=0; j<n; j++)
            for (i=0; i<n; i++)
            {
                System.out.print(A[i][j]+" ");
            }

    }

}
