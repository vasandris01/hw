package org.example.view;

import org.example.controller.Controller;
import org.example.model.Book;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Controller controller = new Controller();

    private void menu() {
        System.out.println("Új dolog felvétele (1)");
        System.out.println("Dolog módosítása (2)");
        System.out.println("Dolog törlése (3)");
        System.out.println("Kilépés (q)");
        String chose = sc.nextLine();
        while (true) {
            switch (chose) {
                case "1" -> {
                    newRecordMenu();
                }
                case "2" -> {
                    modificationMenuMenu();
                }
                case "3" -> {
                    deleteRecordMenu();
                }
                case "q" -> {
                    return;
                }
                default -> {
                    System.out.println("Ne írj faszságot inkább válasz a menüpontokból");
                }
            }
        }
    }

    private void newRecordMenu() {
        System.out.println("Új könyv (1)");
        System.out.println("Új bolt (2)");
        System.out.println("Új szerző (3)");
        System.out.println("Vissza (q)");

        String chose = sc.nextLine();
        switch (chose) {
            case "1" -> {
                controller.addBook();
            }
            case "2" -> {
                controller.addStore();
            }
            case "3" -> {
                controller.addAuthor();
            }
            case "q" -> {
            }
            default -> {
                System.out.println("Ne írj faszságot inkább válasz a menüpontokból");
            }
        }
    }

    private void modificationMenuMenu() {
        System.out.println("Könyv módosítása (1)");
        System.out.println("Bolt módosítása (2)");
        System.out.println("Szerző módosítása (3)");
        System.out.println("Vissza (q)");

        String chose = sc.nextLine();
        switch (chose) {
            case "1" -> {
                controller.modificationBook();
            }
            case "2" -> {
                controller.modificationStore();
            }
            case "3" -> {
                controller.modificationAuthor();
            }
            case "q" -> {
            }
            default -> {
                System.out.println("Ne írj faszságot inkább válasz a menüpontokból");
            }
        }
    }

    private void deleteRecordMenu() {
        System.out.println("Bolt törlése (1)");
        System.out.println("Szerző törlése (2)");
        System.out.println("Vissza (q)");

        String chose = sc.nextLine();
        switch (chose) {
            case "1" -> {
                controller.deleteStore();
            }
            case "2" -> {
                controller.deleteAuthor();
            }

            case "q" -> {
            }
            default -> {
                System.out.println("Ne írj faszságot inkább válasz a menüpontokból");
            }
        }
    }

    private void typeBookSearch() {
        System.out.println("Cím alapján (1)");
        System.out.println("Szerző alapján (2)");
        System.out.println("ISBN alapján (3)");

        String chose = sc.nextLine();
        switch (chose) {
            case "1" -> {

                Book book = controller.searchBookTitle();
            }
            case "2" -> {
                Book book = controller.searchBookAuthor();
            }
            case "3" -> {
                Book book = controller.searchBookISBN();
            }
            case "q" -> {
            }
            default -> {
                System.out.println("Ne írj faszságot inkább válasz a menüpontokból");
            }
        }
    }

}
