import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            Library library = new Library();
            
            do {
                System.out.println("Welcome to the Library Management System");
                System.out.println("1. Add Library Item");
                System.out.println("2. Edit Library Item");
                System.out.println("3. Delete Library Item");
                System.out.println("4. Borrow Library Item");
                System.out.println("5. Return Library Item");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-6): ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> {
                        System.out.println("Adding a new library item...");
                        // Add logic to add a library item
                        System.out.println("Enter Library Item ID: ");
                        String libraryItemId = scanner.next();
                        System.out.println("Enter Library Item Title: ");
                        String libraryItemTitle = scanner.next();
                        System.out.println("Enter Library Item Author: ");
                        String libraryItemAuthor = scanner.next();
                        System.out.println("Enter Library Item ISBN: ");
                        String libraryItemIsbn = scanner.next();
                        System.out.println("Enter Library Item Publisher: ");
                        String libraryItemPublisher = scanner.next();
                        System.out.println("Enter Library Item Number of Copies: ");
                        int libraryItemNumberOfCopies = scanner.nextInt();
                        LibraryItem libraryItem = new LibraryItem(libraryItemId,libraryItemTitle,libraryItemAuthor,libraryItemIsbn,libraryItemPublisher,libraryItemNumberOfCopies,Status.AVAILABLE);
                        library.addLibraryItem(libraryItem);
                        
                        // Add logic to add an author
                        library.checkAuthorList(libraryItemAuthor,libraryItem);
                        
                        library.printitems();
                    }
                    case 2 -> {
                        System.out.println("Editing an existing library item...");
                        // Add logic to edit a library item
                        System.out.println("Enter the ID of the library item to edit: ");
                        String itemId = scanner.next();
                        LibraryItem itemToEdit = library.getLibraryItemById(itemId);
                        if (itemToEdit != null) {
                            System.out.println("Enter new title: ");
                            String newTitle = scanner.next();
                            itemToEdit.setTitle(newTitle);
                            
                            System.out.println("Enter new author: ");
                            String newAuthor = scanner.next();
                            itemToEdit.setAuthor(newAuthor);
                            
                            System.out.println("Enter new ISBN: ");
                            String newIsbn = scanner.next();
                            itemToEdit.setIsbn(newIsbn);
                            
                            System.out.println("Enter new publisher: ");
                            String newPublisher = scanner.next();
                            itemToEdit.setPublisher(newPublisher);
                            
                            System.out.println("Enter new number of copies: ");
                            int newNumberOfCopies = scanner.nextInt();
                            itemToEdit.setNumberOfCopies(newNumberOfCopies);
                            
                            System.out.println("Library item edited successfully.");
                            library.printitems();
                        } else {
                            System.out.println("No library item found with the provided ID.");
                        }
                        // System.out.println("Edit Library Item ID: ");
                        // String editItemId = scanner.next();
                        // System.out.println("Edit Library Item Title: ");
                        // String editItemTitle = scanner.next();
                        // System.out.println("Edit Library Item Author: ");
                        // String editItemAuthor = scanner.next();
                        // System.out.println("Edit Library Item ISBN: ");
                        // String editItemIsbn = scanner.next();
                        // System.out.println("Edit Library Item Publisher: ");
                        // String editItemPublisher = scanner.next();
                        // System.out.println("Edit Library Item Number of Copies: ");
                        // int editItemNumberOfCopies = scanner.nextInt();
                    }
                    case 3 -> {
                        System.out.println("Deleting a library item...");
                        // Add logic to delete a library item
                        // Delete a library item
                        System.out.println("Deleting a library item...");
                        System.out.print("Enter the ID of the item to delete: ");
                        String deleteId = scanner.next();
                        boolean isDeleted = library.deleteLibraryItem(deleteId);
                        if (isDeleted) {
                            System.out.println("Library item deleted successfully.");
                            library.printitems();
                        } else {
                            System.out.println("No library item found with the provided ID.");
                        }
                        System.out.println("Deleting a library item...");
                        System.out.print("Enter the ID of the item to delete: ");
                        //String deleteId = scanner.next();
                        library.deleteLibraryItem(deleteId);
                    }
                    case 4 -> {
                        System.out.println("Borrowing a library item...");
                        // Add logic to borrow a library item
                        System.out.println("Enter the title of the item to borrow: ");
                        String borrowTitle = scanner.next();
                        System.out.println("Enter your name: ");
                        String name = scanner.next();
                        System.out.println("Enter your address: ");
                        String address = scanner.next();
                        System.out.println("Enter your phone number: ");
                        String phoneNumber = scanner.next();
                        System.out.println("Enter your employee ID: ");
                        String employeeId = scanner.next();
                        System.out.println("Enter your department: ");
                        String department = scanner.next();
                        Patron patron = new Employee(name, address, phoneNumber, new ArrayList<>(), employeeId, department);
                        library.borrowLibraryItem(borrowTitle, patron);
                    }
                    case 5 -> {
                        System.out.println("Returning a library item...");
                        // Add logic to return a library item
                        System.out.println("Enter the title of the item to return: ");
                        String returnTitle = scanner.next();
                        System.out.println("Enter your name: ");
                        String nameReturn = scanner.next();
                        System.out.println("Enter your address: ");
                        String addressReturn = scanner.next();
                        System.out.println("Enter your phone number: ");
                        String phoneNumberReturn = scanner.next();
                        System.out.println("Are you an Employee or a Student? (E/S): ");
                        String patronType = scanner.next();
                        Patron returnPatron = null;
                        if (patronType.equalsIgnoreCase("E")) {
                            System.out.println("Enter your employee ID: ");
                            String employeeIdReturn = scanner.next();
                            System.out.println("Enter your department: ");
                            String departmentReturn = scanner.next();
                            returnPatron = new Employee(nameReturn, addressReturn, phoneNumberReturn, new ArrayList<>(), employeeIdReturn, departmentReturn);
                        } else if (patronType.equalsIgnoreCase("S")) {
                            System.out.println("Enter your student ID: ");
                            String studentId = scanner.next();
                            System.out.println("Enter your course: ");
                            String course = scanner.next();
                            returnPatron = new Student(nameReturn, addressReturn, phoneNumberReturn, new ArrayList<>(), studentId, course);
                        }
                        if (returnPatron != null) {
                            library.returnLibraryItem(returnTitle, returnPatron);
                        } else {
                            System.out.println("Invalid patron type. Please enter E for Employee or S for Student.");
                        }
                        System.out.println("Returning a library item...");
                        System.out.print("Enter the title of the item to return: ");
                        /*String returnTitle = scanner.nextLine();
                        System.out.print("Enter your name: ");
                        String nameReturn = scanner.nextLine();
                        System.out.print("Enter your address: ");
                        String addressReturn = scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phoneNumberReturn = scanner.nextLine();
                        System.out.print("Enter your employee ID: ");
                        String employeeIdReturn = scanner.nextLine();
                        System.out.print("Enter your department: ");
                        String departmentReturn = scanner.nextLine();
                        Patron returnPatron = new Employee(nameReturn, addressReturn, phoneNumberReturn, new ArrayList<>(), employeeIdReturn, department);
                        library.returnLibraryItem(returnTitle, returnPatron);*/
                    }
                    case 6 -> System.out.println("Exiting the system. Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } while (choice != 6);
        }
    }
}
