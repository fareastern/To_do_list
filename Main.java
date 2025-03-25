import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int userChoice;
    public static ArrayList<String> toDoList = new ArrayList<>();

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
                    System.out.print("Введите номер для удаления: ");
                    int number = Integer.parseInt(sc.nextLine());
                    toDoList.remove(number - 1);
                    System.out.println("Удалено!");
                    showActualList();
                    break;
                case 4: // Удалить дело по названию
                    System.out.print("Введите задачу для удаления: ");
                    String inputForRemove = sc.nextLine().trim();
                    removeCase(4, inputForRemove);
                    break;
                case 5: // Удалить дело по ключевому слову
                    System.out.print("Введите ключевое слово для удаления: ");
                    String inputForRemove2 = sc.nextLine().trim();
                    removeCase(5, inputForRemove2);
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
        } catch (Exception e) {
            System.out.println("\nМожно вводить только числовые значения!");
        }
    }

    public static void showActualList() {
        System.out.println("Ваш список дел:");
        int count = 1;
        for (String string : toDoList) {
            System.out.println(count + ". " + string);
            count++;
        }
        System.out.println();
    }

    public static void removeCase(int numberCase, String input) {
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