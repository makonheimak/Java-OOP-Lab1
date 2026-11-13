import java.util.Scanner;

/**
 * Лабораторная работа № 1 (Вариант 5)
 * Простое задание: Определить, положительное, отрицательное или нулевое введённое число.
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Task1_NumberSign {

    public static String determineSign(double number) {
        if (number > 0) {
            return "Положительное число (+)";
        } else if (number < 0) {
            return "Отрицательное число (-)";
        } else {
            return "Число равно нулю (0)";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================================");
        System.out.println("   Лабораторная работа № 1 - Задание 1 (Вариант 5) ");
        System.out.println("   Определение знака введенного числа            ");
        System.out.println("==================================================");

        while (true) {
            System.out.print("\nВведите число (или 'exit' для выхода): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("выход")) {
                System.out.println("Завершение работы программы.");
                break;
            }

            try {
                // Поддерживаем как точку, так и запятую в качестве десятичного разделителя
                double number = Double.parseDouble(input.replace(',', '.'));
                String result = determineSign(number);
                System.out.printf("Результат: %.4f -> %s%n", number, result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное число! Попробуйте снова.");
            }
        }
    }
}
