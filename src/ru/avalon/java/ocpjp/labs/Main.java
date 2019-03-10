package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileCreateAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче
 * сертификационных экзаменов серии Oracle Certified
 * Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Main().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                FileCopyAction a = new FileCopyAction("startPlace.txt", "finalPlace.txt");
                a.start();
                break;

            case move:
                FileMoveAction b = new FileMoveAction("startPlace.txt", "finalPlace.txt");
                b.start();
                break;

            case exit:
                close();
                break;

            case deleteFile:
                FileDeleteAction c = new FileDeleteAction("fileName");
                c.start();
                break;

            case newFile:
                FileCreateAction d = new FileCreateAction("fileName");
                d.start();
                break;
        }
    }

}
