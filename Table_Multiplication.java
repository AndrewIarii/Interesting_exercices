import java.util.ArrayList;
import java.util.List;

public class Table_Multiplication {

    //печать таблицы умножения
    public static void main(String[] args) {
        String[][] table = new String[9][9];


        System.out.println("Table of multiplication ");
        for (int j = 1; j < 9; j++) {
            System.out.println();
            for (int i = 1; i < 9; i++) {
                table[i][j] = "\t" + i + "*" + j + "=" + (i * j);
                System.out.print(table[i][j]);
            }
        }

    }
}