package com.view;

import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final DeveloperView developerView = new DeveloperView();

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

        } while (CHOICE_MENU != 1);

    }

    public static String MENU = """
            =================================
            __________MENU__________
            1.  Выход
            ---Работа с DEVELOPERS---
            2.  Вывести всех разработчиков
            3.  Вывести разработчика
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
