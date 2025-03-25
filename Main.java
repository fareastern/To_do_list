import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<String> toDoList = new ArrayList<>();
    private static int userChoice;

    public static void main(String[] args) {
        while (true) {
            menu();
            switch (userChoice) {
                case 0: // Выход из программы
                    System.out.println("Программа завершена.");
                    return;
                case 1: // Добавить дело
                    System.out.print("Введите название задачи: ");
                    String toDoCase = sc.nextLine();
                    toDoList.add(toDoCase);
                    System.out.println("Добавлено!");
                    showActualList();
                    break;
                case 2: // Показать дела
                    showActualList();
                    break;
                case 3: // Удалить дело по номеру
                    removeCaseByNumber();
                    break;
                case 4: // Удалить дело по названию
                    System.out.print("Введите задачу для удаления: ");
                    String inputForRemove = sc.nextLine().trim();
                    removeCaseByText(4, inputForRemove);
                    break;
                case 5: // Удалить дело по ключевому слову
                    System.out.print("Введите ключевое слово для удаления: ");
                    String inputForRemove2 = sc.nextLine().trim();
                    removeCaseByText(5, inputForRemove2);
                    break;
                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }

    public static void menu() {
        System.out.print("""
                Выберите операцию:
                0. Выход из программы
                1. Добавить дело
                2. Показать дела
                3. Удалить дело по номеру
                4. Удалить дело по названию
                5. Удалить дело по ключевому слову
                Ваш выбор: \s"""
        );

        try {
            userChoice = Integer.parseInt(sc.nextLine());
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("\nОшибка: введите числовое значение от 0 до 5!");
        }
    }

    public static void showActualList() {
        if (toDoList.isEmpty()) {
            System.out.println("Ваш список дел пуст.\n");
            return;
        }

        System.out.println("Ваш список дел:");
        int count = 1;
        for (String string : toDoList) {
            System.out.println(count + ". " + string);
            count++;
        }
        System.out.println();
    }

    public static void removeCaseByNumber() {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст!\n");
            return;
        }

        System.out.print("Введите номер для удаления: ");
        try {
            int number = Integer.parseInt(sc.nextLine());
            if (number < 1 || number > toDoList.size()) {
                System.out.println("Неверный номер! Введите число от 1 до " + toDoList.size() + "\n");
            } else {
                toDoList.remove(number - 1);
                System.out.println("Удалено!");
                showActualList();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: нужно ввести число!\n");
        }
    }

    public static void removeCaseByText(int numberCase, String input) {
        boolean existCase = false;
        if (numberCase == 4) {
            existCase = toDoList.removeIf(str -> str.equals(input));
        } else if (numberCase == 5) {
            existCase = toDoList.removeIf(str -> str.toLowerCase().contains(input.toLowerCase()));
        }
        if (!existCase) {
            System.out.println("Такой задачи нет!");
        } else {
            System.out.println("Удалено!");
            showActualList();
        }
    }
}