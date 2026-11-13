import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторная работа № 1 (Вариант 5)
 * Сложное задание: Сортировка массива целых чисел методом пузырька (Bubble Sort).
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Task2_BubbleSort {

    /**
     * Классическая сортировка пузырьком с оптимизацией по флагу перестановок.
     * @param arr исходный массив
     * @param ascending true - по возрастанию, false - по убыванию
     * @param verbose выводить ли промежуточные шаги
     */
    public static void bubbleSort(int[] arr, boolean ascending, boolean verbose) {
        int n = arr.length;
        int passCount = 0;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                boolean condition = ascending ? (arr[j] > arr[j + 1]) : (arr[j] < arr[j + 1]);
                if (condition) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swapCount++;
                }
            }
            passCount++;
            if (verbose) {
                System.out.printf("  Проход %2d: %s%n", passCount, Arrays.toString(arr));
            }
            // Если перестановок не было - массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
        System.out.printf("Сортировка завершена: %d проходов, %d перестановок.%n", passCount, swapCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==================================================");
        System.out.println("   Лабораторная работа № 1 - Задание 2 (Вариант 5) ");
        System.out.println("   Пузырьковая сортировка массива (Bubble Sort)   ");
        System.out.println("==================================================");

        while (true) {
            System.out.println("\nВыберите способ формирования массива:");
            System.out.println("1 - Случайный массив");
            System.out.println("2 - Ввод элементов вручную");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                System.out.println("Завершение программы.");
                break;
            }

            int[] array;

            if (choice.equals("1")) {
                System.out.print("Введите размер массива (например, 10): ");
                int size = 10;
                try {
                    size = Integer.parseInt(scanner.nextLine().trim());
                    if (size <= 0) size = 10;
                } catch (NumberFormatException e) {
                    System.out.println("Размер принят по умолчанию: 10");
                }
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = random.nextInt(100) - 20; // от -20 до 79
                }
            } else if (choice.equals("2")) {
                System.out.println("Введите целые числа через пробел (например: 12 -5 8 0 17 24):");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Пустой ввод! Попробуйте снова.");
                    continue;
                }
                String[] tokens = line.split("\\s+");
                array = new int[tokens.length];
                try {
                    for (int i = 0; i < tokens.length; i++) {
                        array[i] = Integer.parseInt(tokens[i]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: все элементы должны быть целыми числами!");
                    continue;
                }
            } else {
                System.out.println("Неверный пункт меню!");
                continue;
            }

            System.out.println("\nИсходный массив:");
            System.out.println(Arrays.toString(array));

            System.out.println("\nПроцесс сортировки по возрастанию:");
            int[] copyAsc = array.clone();
            bubbleSort(copyAsc, true, true);
            System.out.println("Итог (по возрастанию): " + Arrays.toString(copyAsc));

            System.out.println("\nИтог (по убыванию):");
            int[] copyDesc = array.clone();
            bubbleSort(copyDesc, false, false);
            System.out.println("Итог (по убыванию):    " + Arrays.toString(copyDesc));
        }
    }
}
