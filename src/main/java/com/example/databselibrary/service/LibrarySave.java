package com.example.databselibrary.service;

import com.example.databselibrary.dao.BookDao;
import com.example.databselibrary.model.Book;
import java.util.Scanner;

public class LibrarySave {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert title");
        String title = sc.nextLine();

        System.out.println("Insert author");
        String author = sc.nextLine();

        System.out.println("Insert year");
        int year = sc.nextInt();

        System.out.println("Insert isbn");
        int isbn = sc.nextInt();
        sc.nextLine();

        Book book = new Book(title, author, year, isbn);

        BookDao bookDao = new BookDao();
        bookDao.insert(book);
        System.out.println("Added!");
    }
}
