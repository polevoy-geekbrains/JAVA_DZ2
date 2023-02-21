// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.     */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class dz_01_02 {

    public static void main(String[] args) throws IOException {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива, массив будет сформирован случайным образом: ");
        int arraySize = iScanner.nextInt();
        iScanner.close();
        int[] arrayNum = fillArray(arraySize);
        // Печать исходного массива
        printArray(arrayNum);
        // Печать отсортированного массива
        printArray(bubbleSort(arrayNum));
    }
    public static int[] bubbleSort(int[] arrayNum) throws IOException {
        for (int i = 0; i < arrayNum.length; i++) {
            for (int j = 0; j < arrayNum.length - 1; j++) {
                if (arrayNum[j] > arrayNum[j + 1]) {
                    int temp = arrayNum[j];
                    arrayNum[j] = arrayNum[j + 1];
                    arrayNum[j + 1] = temp;
                    // Логирование после каждой итерации
                    logSort(Arrays.toString(arrayNum), arrayNum[j], arrayNum[j + 1], j);
                }
            }
        }
        return arrayNum;
    }
    public static void logSort(String array, int a, int b, int j) throws IOException {
        Logger logger = Logger.getLogger(dz_01_02.class.getName());
        FileHandler fh = new FileHandler("mylogger1.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        StringBuilder str = new StringBuilder();
        str.append(a).append(" и ").append(b).append(" поменялись местами.\n");
        str.append("Массив изменился: ").append(array).append("\n");
        logger.info(str.toString());
        fh.close();
    }
    public static int[] fillArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }
         return array;
    }
    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}