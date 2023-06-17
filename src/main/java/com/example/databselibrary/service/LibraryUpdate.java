package com.example.databselibrary.service;

import com.example.databselibrary.dao.BookDao;
import com.example.databselibrary.model.Book;

import java.util.Scanner;

public class LibraryUpdate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book id");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Insert title");
        String title = sc.nextLine();

        System.out.println("Insert author");
        String author = sc.nextLine();

        System.out.println("Insert year");
        int year = sc.nextInt();

        System.out.println("Insert isbn");
        int isbn = sc.nextInt();
        sc.nextLine();

        Book book = new Book(id, title, author, year, isbn);

        BookDao bookDao = new BookDao();
        bookDao.updateData(book);
    }
}
