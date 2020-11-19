import java.util.Random;
import java.util.Scanner;

public class ObhodMassivSpiral {


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
               // A[i][j]=0+(int)(Math.random()*10);//по строкам
                count++;
                A[i][j]=count;
                System.out.print(A[i][j]+"\t");
            }
        }


        System.out.println("Вывод матрицы по спирали");
        for(i=n-1;i>0;i--,j++){
            //i хранит ограничение при положительном проходе
            //j хранит ограничение при негативном проходе
            //при каждой итерации проход в одну из сторон уменьшается на один

                //слева направо до текущего  значения  i
            for (num=j; num<i;num++) System.out.print(" "+A[j][num]);
                //вниз до текущего  значения  i
            for (num=j;num<i;num++){ System.out.print(" "+A[num][i]);}
                //справа налево до текущего значения j
            for (num=i;num>j;num--) System.out.print(" "+A[i][num]);
                //вверх до текущего значения j
            for (num=i;num>j;num--) System.out.print(" "+A[num][j]);



        }//получаем элемент из середины
        int mid=(n-1)/2;
        //если есть элемент в середине выводим на экран
        if(n%2==1) System.out.print(" "+A[mid][mid]+"\n");

        //Обратный проход матрицы
        System.out.println("Обратный проход матрицы по спирали ");

        //для начала создаем цикл хранящий значения нужные для обхода
        //максимальные/минимальные значения при проходе вперед/назад
        j=0;i=0;
        for (i=n-1;i>0;i--,j++){

            //сначала нужно пойти с первого элемента вниз по строкам
            //значения столбца не будет меняться
            for (num=j;num<i;num++) System.out.print(" "+A[num][j]);
            //пойдем слева направо но по макс текущему значению строки (i)
            for (num=j;num<i;num++) System.out.print(" "+A[i][num]);
            //Теперь вверх с правого нижнего угла
            //до текущего значения j
            for (num=i;num>j;num--) System.out.print(" "+A[num][i]);
            //справа налево до текущего значения j
            for (num=i;num>j;num--) System.out.print(" "+A[j][num]);
        }if(n%2==1) System.out.print(" "+A[mid][mid]);

    }

}
