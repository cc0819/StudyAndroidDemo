// IBookManager.aidl
package com.example.aidl;

// Declare any non-default types here with import statements

interface IBookManager {
      List<Book> getBookList();
       void addBook(in Book book);
}
