import java.util.Random;
import java.util.Scanner;

public class Game23 {
    /*есть 23 спички
    каждый игрок по очереди забирает одну две или три спички
    у кого остается последняя спичка , тот проиграл

    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rnd = new Random(System.currentTimeMillis());
        int n = 23;

        //второй случай 100% проигрыш
        System.out.println("Выберите чей первый ход: 1- Вы  2-Компьютер");
        int choice = in.nextInt();
        while (choice < 0 || choice > 2) {
            System.out.println("Повторите ввод");
            choice = in.nextInt();
        }

        //выбор первого хода
        switch (choice) {
            //первой ход игрока
            case 1:
                do {
                    int k1 = 0;
                    System.out.println("Выберите кол-во спичек от 1 до 3");

                    int myNumber = in.nextInt();
                    if (myNumber < 1 || myNumber > 3) {
                        System.out.println("Повторите ввод");

                    } else {
                        n = n - myNumber;
                        System.out.println("Вы убрали " + myNumber + " -спичек");
                        System.out.println("Осталось " + n + " -спичек");

                        if (n % 4 == 0) {
                            k1 = 3;
                        } else if (n % 4 == 1) {
                            k1 = 1 + rnd.nextInt(3);
                        } else if (n % 4 == 2) {
                            k1 = 1;
                        } else {
                            k1 = 2;
                        }
                        if (n == 1) {
                            System.out.println("Вы выиграли");
                            break;
                        }
                        n = n - k1;

                        System.out.println("Я уберу " + k1 + " -спичек");
                        System.out.println("Остается " + n + " -спичек");
                        if (n == 1) {
                            System.out.println("Вы проиграли");
                        }
                    }

                } while (n > 1);
                break;

            //первый ход у компа
            case 2:
                n = 21;
                System.out.println("Я уберу 2 спички остается " + n);
                do {
                    int k1 = 0;
                    System.out.println("Выберите кол-во спичек от 1 до 3");

                    int myNumber = in.nextInt();
                    if (myNumber < 1 || myNumber > 3) {
                        System.out.println("Повторите ввод");

                    } else {
                        n = n - myNumber;
                        System.out.println("Вы убрали " + myNumber + " -спичек");
                        System.out.println("Осталось " + n + " -спичек");

                        if (n % 4 == 0) {
                            k1 = 3;
                        } else if (n % 4 == 1) {
                            k1 = 1 + rnd.nextInt(3);
                        } else if (n % 4 == 2) {
                            k1 = 1;
                        } else {
                            k1 = 2;
                        }

                        n = n - k1;
                        System.out.println("Я уберу " + k1 + " -спичек");
                        System.out.println("Остается " + n + " -спичек");
                        if (n == 1) {
                            System.out.println("Вы проиграли");
                        } else if (n < 2) {
                            System.out.println("Кажется вы выиграли");
                        }
                    }

                } while (n > 1);
                break;
        }


    }
}
