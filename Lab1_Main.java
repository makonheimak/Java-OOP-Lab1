import java.util.Scanner;

/**
 * Лабораторная работа № 1 (Вариант 5)
 * Главный класс для демонстрации обоих заданий.
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Lab1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==========================================================");
            System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 1: Создание программ на Java     ");
            System.out.println("   Выполнил студент 4 курса ИВТ-А Юраш Максим     ");
            System.out.println("   Вариант 5                                             ");
            System.out.println("==========================================================");
            System.out.println("1 - Задание 1 (Простое): Определение знака числа (+ / - / 0)");
            System.out.println("2 - Задание 2 (Сложное): Сортировка массива пузырьком");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                System.out.println("Выход из программы. Удачи!");
                break;
            } else if (input.equals("1")) {
                Task1_NumberSign.main(new String[0]);
            } else if (input.equals("2")) {
                Task2_BubbleSort.main(new String[0]);
            } else {
                System.out.println("Некорректный выбор, повторите ввод.");
            }
            System.out.println();
        }
    }
}
