package com.example.databselibrary.service;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("choose option");
            System.out.println("1. read the book");
            System.out.println("2. save the book");
            System.out.println("3. update the book");
            System.out.println("4. delete the book");
            System.out.println("0. exit");

            String option = sc.nextLine();

            switch (option) {

                case "1":
                    LibraryRead.main(new String[0]);
                    break;
                case "2":
                    LibrarySave.main(new String[0]);
                    break;
                case "3":
                    LibraryUpdate.main(new String[0]);
                    break;
                case "4":
                    LibraryDelete.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("error");
            }
        }
    }
}
