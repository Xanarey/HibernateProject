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

        } while (CHOICE_MENU != 1);

    }

    public static String MENU = """
            =================================
            __________MENU__________
            1.  Выход
            ---Работа с DEVELOPERS---
            2.  Вывести всех разработчиков

            """;

    public static Long CHOICE_MENU;


}
