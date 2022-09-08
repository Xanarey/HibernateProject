package com.view;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;

import java.util.Objects;
import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final DeveloperView developerView = new DeveloperView();
    private final SpecialtyView specialtyView = new SpecialtyView();

    public MainView() {}

    public void start() {

        do {
            System.out.println(MENU);
            CHOICE_MENU = scanner.nextLong();

            if (CHOICE_MENU == 2) {
                developerView.getAllDeveloper();
            }

            if (CHOICE_MENU == 3) {
                System.out.println("Введите id разработчика: ");
                do {
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.getDeveloperById(ID);
            }

            if (CHOICE_MENU == 4) {
                do {
                    System.out.println("Введите id: ");
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.delete(ID);
            }

            if (CHOICE_MENU == 5) {
                do {
                    System.out.println("Введите id для изменения статуса на (DELETED):");
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.changeStatus(ID);
            }

            if (CHOICE_MENU == 6) {
                System.out.println("Введите First_Name:");
                do {
                    FIRST_NAME = scanner.nextLine();
                } while (Objects.equals(FIRST_NAME, ""));

                System.out.println("Введите Last_Name:");
                do {
                    LAST_NAME = scanner.nextLine();
                } while (Objects.equals(LAST_NAME, ""));
                specialtyView.getAllSpecialty();
                System.out.println("Выберите специальность по id: ");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                developerView.insert(new Developer(FIRST_NAME, LAST_NAME, Status.ACTIVE, SPECIALTY_ID));
            }

            if (CHOICE_MENU == 7) {
                specialtyView.getAllSpecialty();
            }

            if (CHOICE_MENU == 8) {
                System.out.println("Введите id:");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                specialtyView.getSpecialtyById(SPECIALTY_ID);
            }

            if (CHOICE_MENU == 9) {
                System.out.println("Введите имя новой специальности: ");
                do {
                    SPECIALTY_NAME = scanner.nextLine();
                } while (SPECIALTY_NAME.equals(""));
                specialtyView.insertSpecialty(SPECIALTY_NAME);
                System.out.println("Специальность успешно добавлена");
            }

            if (CHOICE_MENU == 10) {
                specialtyView.getAllSpecialty();
                System.out.println("Выберите id удаляемой специальности: " + "\n");
                do {
                    ID = scanner.nextLong();
                } while (ID <= 0);
                specialtyView.deleteSpecialtyById(ID);
            }

            if (CHOICE_MENU == 11) {
                specialtyView.getAllSpecialty();
                System.out.println("Выберите изменяемую специальность по id: ");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                System.out.println("Введите новое название специальности: ");
                do {
                    SPECIALTY_NAME = scanner.nextLine();
                } while (SPECIALTY_NAME.equals(""));
                specialtyView.updateSpecialty(SPECIALTY_ID, SPECIALTY_NAME);
            }

        } while (CHOICE_MENU != 1);

    }

    public static String MENU = """
            =================================
            __________MENU__________
            1.  Выход
            ---Работа с DEVELOPERS---
            2.  Вывести всех разработчиков
            3.  Вывести разработчика
            4.  Удалить разработчика
            5.  Удалить разработчика (установить статус DELETED)
            6.  Добавить разработчика
            ---Работа с SPECIALTY---
            7.  Вывести все специальности
            8.  Получить специальность по id
            9.  Добавить специальность
            10. Удалить специальность
            11. Изменить специальность
            """;

    public static Long ID = 0L;
    public static Long SPECIALTY_ID = 0L;
    public static Long SKILL_ID = 0L;
    public static Long CHOICE_MENU;
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static String SKILL_NAME;
    public static String SPECIALTY_NAME;


}
