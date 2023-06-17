package com.example.databselibrary.service;

import com.example.databselibrary.dao.BookDao;
import com.example.databselibrary.model.Book;

import java.util.Scanner;

public class LibraryRead {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert isbn");
        int isbn = sc.nextInt();
        sc.nextLine();

        BookDao bookDao = new BookDao();
        Book book = bookDao.readData(isbn);
        System.out.println(book);
    }
}
