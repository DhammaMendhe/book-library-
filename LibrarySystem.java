import java.util.*;


class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String id, String title, String author, String genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

  
    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + isAvailable;
    }
  
}

public class LibrarySystem {
    private static List<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewAllBooks();
                case 3 -> searchBook();
                case 4 -> updateBook();
                case 5 -> deleteBook();
                case 6 -> {
                    System.out.println("Exiting the system.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Is Available (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine();

        books.add(new Book(id, title, author, genre, isAvailable));
        System.out.println("Book added successfully.");
    }

    private static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String query = scanner.nextLine();
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                System.out.print("Enter new Title (leave blank to keep current): ");
                String newTitle = scanner.nextLine();
                if (!newTitle.isBlank()) book.setTitle(newTitle);

                System.out.print("Enter new Author (leave blank to keep current): ");
                String newAuthor = scanner.nextLine();
                if (!newAuthor.isBlank()) book.setAuthor(newAuthor);

                System.out.print("Enter new Genre (leave blank to keep current): ");
                String newGenre = scanner.nextLine();
                if (!newGenre.isBlank()) book.setGenre(newGenre);

                System.out.print("Is Available (true/false): ");
                boolean isAvailable = scanner.nextBoolean();
                scanner.nextLine();
                book.setAvailable(isAvailable);

                System.out.println("Book details updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

