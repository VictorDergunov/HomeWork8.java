import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static FileReader reader1;
    public static FileReader reader2;

    public static int symbolNumber1 = 0;
    public static int symbolNumber2 = 0;

    public static char[] buf1;
    public static char[] buf2;

    public static String str1;
    public static String str2;

    public static void main(String[] args) {
        try {
            File file = new File("c:\\Java\\sample01");
            if (!file.exists()) {
                System.out.println("Директория не создана!");
                if (file.mkdir()) {
                    System.out.println("Директория успешно создана!");
                } else {
                    System.out.println("Не удалось создать директорию!");
                    return; //выход
                }
            } else
                System.out.println("Директория существует!");

            // Создали первый файл

            FileWriter writer1 = new FileWriter("c:\\Java\\sample01\\text01.txt", false);
            writer1.write("Здравствуйте, приглашаю вас\nпротестировать мое первое приложение");
            writer1.append('\n');
            writer1.append("Желаю удачи!");
            writer1.flush(); // считываем даннные и копируем
            writer1.close();

            // Создали второй файл
            FileWriter writer2 = new FileWriter("c:\\Java\\sample01\\text02.txt", false);
            writer2.write("Hello world, GeekBrains ");
            writer2.append('\n');
            writer2.append("Java lesson 8 homework");
            writer2.append('\n');
            writer2.append("Выполняю домашнюю работу");
            writer2.flush(); // считываем даннные и копируем
            writer2.close();

            System.out.println();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            reader1 = new FileReader("c:\\Java\\sample01\\text01.txt");
            reader2 = new FileReader("c:\\Java\\sample01\\text02.txt");

            buf1 = new char[256];
            while ((symbolNumber1 = reader1.read(buf1)) != -1) {
                System.out.println("Колличество символов второго файла: " + symbolNumber1);
                for (int i = 0; i < symbolNumber1; i++) {
                    System.out.print(buf1[i]);
                }
                str1 = new String(buf1, 0, symbolNumber1);
            }
            System.out.println("\n");
            buf2 = new char[128];
            while ((symbolNumber2 = reader2.read(buf2)) != -1) {
                System.out.println("Колличество символов второго файла: " + symbolNumber2);
                for (int i = 0; i < symbolNumber2; i++) {
                    System.out.print(buf2[i]);
                }
                str2 = new String(buf2, 0, symbolNumber2);
            }

        } catch (Exception e) {

        }

        fileSum(str1, str2); // Склеиваем два текстовых файла!
        findWord1(str1, "вас"); // Введите слово которое хотите проверить в первой строке
        findWord2(str2, "Java"); // Введите слово которое хотите проверить в первой строке
        findWord2(str2, "привет");
    }

    public static void findWord1(String str1, String word1) {
        System.out.println();
        if (str1.contains(word1)) {
            System.out.println(" слово: " + word1);
        } else {
            System.out.println("Слово не найдено! " + '\n' +  "Вы искали слово: " + word1);

        }
    }

    public static void findWord2(String str2, String word2) {
        System.out.println();
        if (str2.contains(word2)) {
            System.out.println(" слово: " + word2);
        } else {
            System.out.println("Слово не найдено!" + '\n' +  "Вы искали слово: " + word2);

        }
    }

    public static void fileSum(String str1, String str2) {
        System.out.println('\n');
        System.out.println("Склеиваем два текстовых файла!\n");
        System.out.println(str1 + "\n" + str2);

    }
}



