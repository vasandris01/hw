package org.example.controller;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Store;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private HibernateContext model = new HibernateContext();

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Adjjad meg könyv címét");
        book.setName(scanner.nextLine());
        List<Author> authors = this.allAuthor();
        for (var a : authors){
            System.out.println(a);
        }
        System.out.println("Adjjad meg könyv szerzőjének id ját");
        int id = Integer.parseInt(scanner.nextLine());

        for (var a : authors){
            if (a.getId() == id){
                book.setAuthor(a);
            }
        }
        System.out.println("Adjjad meg könyv ISBN -jért");
        book.setISBN(scanner.nextLine());

        System.out.println("Adjjad meg könyv címét");


        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.flush();

        session.getTransaction().commit();

        session.close();
    }

    private List<Author> allAuthor() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        List<Author> authors = session.createSelectionQuery("SELECT a FROM Author a", Author.class).getResultList();

        session.clear();

        session.getTransaction().commit();
        return authors;
    }

    public void modificationBook() {

    }

    public List<Book> allBook() {

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        List<Book> books = session.createSelectionQuery("SELECT b FROM Book b", Book.class).getResultList();

        session.clear();

        session.getTransaction().commit();
        return books;
    }
    public List<Store> allStores(){
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        List<Store> stores = session.createSelectionQuery("SELECT s FROM Store s", Store.class).getResultList();

        session.clear();

        session.getTransaction().commit();
        return stores;
    }

    public Book searchBookTitle(String title) {
        List<Book> books = this.allBook();
        for (var b : books){
            if(b.getName().equals(title)){
                return b;
            }
        }
        return null;
    }

    public Book searchBookAuthor(Author author) {
        List<Book> books = this.allBook();
        for (var b : books){
            if(b.getAuthor() == author){
                return b;
            }
        }
        return null;
    }

    public Book searchBookISBN(String ISBN) {
        List<Book> books = this.allBook();
        for (var b : books){
            if(b.getName().equals(ISBN)){
                return b;
            }
        }
        return null;
    }


    public void addStore() {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        System.out.println("Adjjad meg a bolt nevét");
        store.setName(scanner.nextLine());

        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(store);
        session.flush();

        session.getTransaction().commit();

        session.close();

    }

    public void addAuthor() {
        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Author());
        session.flush();

        session.getTransaction().commit();

        session.close();
    }

    public void modificationStore() {
    }

    public void modificationAuthor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Melyik szerződ módosítanád koma?");
        List<Author> authors = this.allAuthor();
        for (var a : authors){
            System.out.println(a);
        }
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("MIre változtatnád meg az idjét?");
        for (var a : authors){
            if(a.getId() == id){
                a.setId(Integer.parseInt(sc.nextLine()));
            }
        }
    }


    public void deleteStore() {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

   //         Store p = session.find(Store.class, id);
   //            session.remove(p);
            // mijaumijaumijaumijau

            // vauvauvau
            // for ciklussal kellene vau-zni




            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void deleteAuthor() {
    }
}
