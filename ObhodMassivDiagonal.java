import java.util.Scanner;

public class ObhodMassivDiagonal {
    public static void main(String[] args) {
        int i, j = 0, p, num, m, n;
        int count = 0;
        Scanner in = new Scanner(System.in);//создаем объект класса Сканер
        System.out.println("Размер матрицы:");
        n = in.nextInt();
        int[][] A = new int[n][n];


        //вывод матрицы
        System.out.println("Вывод матрицы");

        for (i = 0; i < n; i++)//начало цикла
        {
            System.out.println();
            for (j = 0; j < n; j++) {
                count++;
                A[i][j] = count;
                System.out.print(A[i][j] + "\t");
            }
        }

        System.out.println("\nВывод по побочным диагоналям:");

        for (int k = 0; k < n; k++) {
            int sum = k;
            //при каждой внешней итерации проходим весь массив
            //выводя только элементы соответсвующие условию
            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    if (i + j == sum)
                        System.out.print(" " + A[i][j]);//выводим элементы выше побочной диагонали и сама диагональ
        }
        for (int k = 1; k < n; k++) {
            //здесь сумма для проверки начинается с середины
            //поэтому изначально больше на n-1
            int sum = n - 1 + k;

            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    if (i + j == sum) System.out.print(" " + A[i][j]);//вывод побочной диагонали
        }


    }
}

