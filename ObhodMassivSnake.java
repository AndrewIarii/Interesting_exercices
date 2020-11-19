import java.util.Scanner;

public class ObhodMassivSnake {
    public static void main(String[] args) {
        int i,j =0, p,num, m,n;
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


        //вывод матрицы змейкой
        System.out.println("\nВывод матрицы змейкой");
        for (i=0;i<n;i++){

            if (i%2==0){//если строка четная слева направо
                for (j=0;j<n;j++)System.out.print(" "+A[i][j]);
            }

            else{//иначе справа налево
                for (j=n-1;j>=0;j--) System.out.print(" "+A[i][j]);
            }

        }

        //вывод матрицы обратной змейкой
        System.out.println("\nВывод матрицы змейкой");
        for (i=0;i<n;i++){

            if (i%2==0){//если строка четная слева направо
                for (j=n-1; j>=0; j--) System.out.print(" "+ A[i][j]);//если строка четная идем справа налево}
            }

            else{//иначе справа налево
                for (j=0; j<n; j++) System.out.print(" "+ A[i][j]);	//иначе идем слева направо}
            }

        }




    }}

