package JavaHomeWork.UI;

import JavaHomeWork.Configs.Config;
import JavaHomeWork.Core.MVP.Presenter;
import JavaHomeWork.Core.Models.Toy;


import java.util.Scanner;

public  class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter (new ConsoleView(), Config.pathDb);
        presenter.loadFromFile();

        String command;

        while (true) {

            command = prompt("""
                    1 - Добавьте игрушку
                     2 - Удалить игрушку
                     3 - Покажите игрушки 
                     4 - Очистить все записи
                     5 - Сохраните все записи в файл
                     6 - Загрузите все записи из файла
                     7 - Выход
                    Сделайте свой выбор:\s""");
            if (command.equals("7")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForDrawing();
                    case "2" -> presenter.deleteFromDrawing();
                    case "3" -> presenter.showAll();
                    case "4" -> presenter.clearAll();
                    case "5" -> presenter.saveToFile();
                    case "6" -> presenter.loadFromFile();
                    default -> System.out.println("\n Команда не найдена!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("Идентификатор игрушки: "));
        String name = prompt("Название игрушки: ");
        String weight = prompt("Вес игрушки: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }
}