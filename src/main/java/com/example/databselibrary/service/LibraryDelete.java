package com.example.databselibrary.service;

import com.example.databselibrary.dao.BookDao;

import java.util.Scanner;

public class LibraryDelete {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert book id");
        int id = sc.nextInt();
        sc.nextLine();

        BookDao bookDao = new BookDao();
        bookDao.delete(id);
    }
}
