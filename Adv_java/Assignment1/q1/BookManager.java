package Adv_java.Assignment1.q1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private static final String FILE_NAME = "Books.dat";
    private List<Book> books = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BookManager() {
        loadBooksFromFile();
    }

    public void addBook() throws IOException {
        int id = promptInt("Book ID: ");
        if (bookExists(id)) {
            System.out.println("Book with ID " + id + " already exists!");
            return;
        }

        String name = prompt("Book Name: ");
        String author = prompt("Author: ");
        String publication = prompt("Publication: ");
        double price = promptDouble("Price: ");

        books.add(new Book(id, name, author, publication, price));
        saveBooksToFile();
        System.out.println("Book added successfully!");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void searchBook() throws IOException {
        System.out.println("\nSearch by:");
        System.out.println("1. Book ID");
        System.out.println("2. Book Name");
        System.out.println("3. Author");
        System.out.println("4. Publication");
        System.out.print("Enter choice: ");

        String choice = reader.readLine();
        System.out.print("Enter search term: ");
        String searchTerm = reader.readLine().toLowerCase();

        List<Book> results = new ArrayList<>();

        switch (choice) {
            case "1":
                results = books.stream()
                        .filter(b -> String.valueOf(b.getBookId()).equals(searchTerm))
                        .collect(Collectors.toList());
                break;
            case "2":
                results = books.stream()
                        .filter(b -> b.getBookName().toLowerCase().contains(searchTerm))
                        .collect(Collectors.toList());
                break;
            case "3":
                results = books.stream()
                        .filter(b -> b.getAuthor().toLowerCase().contains(searchTerm))
                        .collect(Collectors.toList());
                break;
            case "4":
                results = books.stream()
                        .filter(b -> b.getPublication().toLowerCase().contains(searchTerm))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No matching books found!");
        } else {
            System.out.println("\nMatching Books:");
            results.forEach(System.out::println);
        }
    }

    public void updateBook() throws IOException {
        int id = promptInt("Enter Book ID to update: ");
        Book book = getBookById(id);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        System.out.println("Current book details: " + book);

        String name = prompt("New Book Name: ");
        if (!name.isEmpty())
            book.setBookName(name);

        String author = prompt("New Author: ");
        if (!author.isEmpty())
            book.setAuthor(author);

        String publication = prompt("New Publication: ");
        if (!publication.isEmpty())
            book.setPublication(publication);

        double price = promptDouble("New Price: ");
        if (price > 0)
            book.setPrice(price);

        saveBooksToFile();
        System.out.println("Book updated successfully!");
    }

    public void deleteBook() throws IOException {
        int id = promptInt("Enter Book ID to delete: ");
        if (books.removeIf(b -> b.getBookId() == id)) {
            saveBooksToFile();
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No data file found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    private boolean bookExists(int id) {
        return books.stream().anyMatch(b -> b.getBookId() == id);
    }

    private Book getBookById(int id) {
        return books.stream().filter(b -> b.getBookId() == id).findFirst().orElse(null);
    }

    String prompt(String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }

    private int promptInt(String message) throws IOException {
        return Integer.parseInt(prompt(message));
    }

    private double promptDouble(String message) throws IOException {
        return Double.parseDouble(prompt(message));
    }

    public void close() throws IOException {
        reader.close();
    }
}