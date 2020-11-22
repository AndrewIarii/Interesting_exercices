import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameNim3Heaps {
    static Scanner in = new Scanner(System.in);

    /*Эта старинная игра представляет собою усложненное видоизменение предыдущих.
     На стол кладут три кучки спичек; в каждой кучке может быть любое число спичек, но не больше 7-ми
     (одна спичка тоже называется в этой игре «кучкой»).
     Игра состоит в том, что играющие берут по очереди из одной кучки любое число спичек (можно и все взять),
     но только из одной какой-нибудь кучки, по желанию берущего.
    Кто возьмет последнюю спичку со стола, тот считается выигравшим*/

    public static void main(String[] args) {

        //для хода программы
        int[] H1 = {7, 6, 5, 3, 2, 1};
        int[] H2 = {6, 5, 4, 2, 2, 2};
        int[] H3 = {7, 6, 5, 3, 2, 1};

        int i;

        int heapNumber, stickNumber, startStick;//определение переменных хранящих номер кучи, количество спичек, начальное количество спичек
        List<Integer> listHeap = new ArrayList<Integer>();//создание переменной хранящей количество спичек

        //ввод начального распределения по кучам
        for (i = 0; i < 3; i++) {
            System.out.println("Введите кол-во спичек в " + (i + 1) + " куче");
            startStick = in.nextInt();//ввод начального количество
            //определение условий ввода
            while (startStick < 1 || startStick > 7) {
                System.out.println("Спичек должно быть меньше 7 и больше 1");
                startStick = in.nextInt();
            }
            //добавление в коллекцию начальных значений
            listHeap.add(startStick);
        }

        //отображение текущего распределения
        showListHeap(listHeap);


        do {

            //выбор из какой кучи тянуть и сколько спичек
            System.out.println("Выберите из какой кучи тянуть и сколько спичек");

            //выбор кучи
            heapNumber = in.nextInt();

            //условие номер кучи не должен быть больше существующих
            while (heapNumber < 1 || heapNumber > listHeap.size()) {
                System.out.println("Повторите ввод номера кучи");
                heapNumber = in.nextInt();
            }
            //выбор кол-ва спичек
            stickNumber = in.nextInt();

            //кол-во спичек не должно превышать количества-существующих в выбранной куче
            while (stickNumber > listHeap.get(heapNumber - 1)) {
                System.out.println("Повторите ввод количества спичек");
                stickNumber = in.nextInt();
            }
            //запись изменений в коллекцию
            //количество существующих минус введенного пользователем т.к ввод начинается с единицы
            listHeap.set((heapNumber - 1), (listHeap.get(heapNumber - 1) - stickNumber));


            deleteEmptyHeap(listHeap);//удаление пустых куч
            showListHeap(listHeap);//отображение текущего распределения

            //ход программы
            //если куч три тогда
            if (listHeap.size() == 3) {
                for (i = 0; i < H1.length; i++) {
                    boolean h1Flag = false;
                    boolean h3Flag = false;
                    boolean h2Flag = false;
                    //если совпадает с возможной комбой первой кучи установим флаг
                    //получаем номер совпадения если найдено
                    if (listHeap.get(0) == H1[i]) {
                        h1Flag = true;

                    }
                    if (listHeap.get(2) == H3[i]) {
                        h3Flag = true;
                    }
                    if (listHeap.get(1) == H2[i]) {
                        h2Flag = true;
                    }

                    //если количество в первой куче совпадает с одной из комб
                    //а в второй куче больше 4 элементов
                    if (h1Flag) {
                        if (listHeap.get(1) > 4) {
                            listHeap.set(1, 4);
                            break;

                        }
                        if (listHeap.get(1) != 2) {
                            listHeap.set(1, 2);
                            break;
                            //если не получается скомбинить с второй кучей комбиним с третьей
                        } else if (listHeap.get(2) > 1) {
                            listHeap.set(2, 1);
                        }
                        break;
                        //если не получается ни второй привести ни третий ,приводим к нужному первую кучу
                    } else {
                        if (listHeap.get(0) > 1) {
                            listHeap.set(0, 1);
                            break;
                        }
                    }

                    //если вторая кучка соответвует одному из условий
                    //и она больше одного тогда присваиваем 1
                    if (h2Flag) {
                        if (listHeap.get(1) == 2) {
                            listHeap.set(1, 0);
                            break;
                        }
                        if (listHeap.get(0) > 1) {
                            listHeap.set(0, 1);
                            break;

                            //если первая куча не больше одного , тогда 3 куче присваемваем 1
                        } else {
                            listHeap.set(2, 1);
                            break;
                        }

                        //если вторая куча не соотвествует условию и больше двух
                        //присваеваем два
                        //иначе обнуляем ее
                    } else {
                        if (listHeap.get(1) > 2) {
                            listHeap.set(1, 2);
                            break;
                        }


                    }

                }
            }
            //если кучи две
            if (listHeap.size() == 2) {
                //если во время хода программы два элемента равны 1 игрок выиграл
                if (listHeap.get(0) == 1 && listHeap.get(1) == 1) {
                    listHeap.remove(0);
                    showListHeap(listHeap);
                    System.out.println("Вы выиграли!");
                    break;
                }
                //если кучи равны и больше 1 рандомно забираем с какой-то одну спичку
                if (listHeap.get(0) == listHeap.get(1)
                        && listHeap.get(0) > 1 && listHeap.get(1) > 1) {
                    int rnd = (int) (Math.random() * 1);
                    listHeap.set(rnd, listHeap.get(rnd) - 1);
                }
                //если кучи не равны, уравниваем их
                else {
                    //определяем тогда разницу между ними
                    int difference = Math.abs(listHeap.get(0) - listHeap.get(1));
                    if (listHeap.get(0) > listHeap.get(1)) {//если первая куча больше
                        // отнимаем от большего элемента разницу
                        listHeap.set(0, listHeap.get(0) - difference);
                    } else {
                        listHeap.set(1, listHeap.get(1) - difference);
                    }
                }


                //если только один из элементов игрок проиграл
                if (listHeap.get(0) == 1 || listHeap.get(1) == 1) {
                    showListHeap(listHeap);
                    System.out.println("Вы проиграли!");
                    break;
                }
            }
            //если одна куча остается
            if (listHeap.size() == 1) {
                //если во время хода программы одна куча в которой больше двух спичек
                //проигрыш игроку
                if (listHeap.get(0) > 2) {
                    listHeap.set(0, 2);
                    System.out.println("Вы проиграли");
                    //иначе выигрыш
                } else {
                    System.out.println("Вы выиграли");
                }
            }

            System.out.println();
            //удаление пустых ячеек и вывод
            deleteEmptyHeap(listHeap);
            showListHeap(listHeap);


        } while (listHeap.size() > 1);


    }

    //функция для отображения текущего распределения
    public static void showListHeap(List<Integer> listHeap) {
        for (int a :
                listHeap) {
            System.out.print("\t" + a);
        }
        System.out.println();

    }

    //функция для удаления пустых куч и возвращения
    public static int deleteEmptyHeap(List<Integer> listHeap) {
        for (int i = 0; i < listHeap.size(); i++) {
            if (listHeap.get(i) == 0) {
                listHeap.remove(i);
            }
        }
        return listHeap.size();
    }


}
