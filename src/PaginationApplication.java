package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//Class that paginates a text file
public class PaginationApplication {
    private static final int MAX_LINE_LENGTH = 80; // Maximum number of characters per line
    private static final int LINES_PER_PAGE = 25; // Maximum number of lines per page

    //Main method that reads a file, paginates it and prints the pages
    public static void main(String[] args) {
        String filePath = "./input/document.txt"; // Path to the file to be paginated
        String file = ReadFile(filePath);
        List<List<String>> pages = paginate(file);
        printPages(pages);
    }

    //Method that reads a file and returns its content as a String
    public static String ReadFile(String filePath) {
        String file = null;
        //Read the only line in the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            file = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    //Method that paginates a text file
    public static List<List<String>> paginate(String file) {
        List<List<String>> pages = new ArrayList<>(); // List of pages
        List<String> page = new ArrayList<>(); // List of lines in a page
        // Split the file into words
        String[] words = file.split(" "); 
        StringBuilder line = new StringBuilder();
        // Add words to the lines
        for (String word : words) {
            // If the line is not full, add the word to it
            if (line.length() + word.length() + 1 <= MAX_LINE_LENGTH) {
                line.append(word).append(" ");
            } else {
                // If the line is full, add it to the page and start a new line
                page.add(line.toString().trim());
                line = new StringBuilder(word + " ");
            }
            // If the page is full, add it to the pages and start a new page
            if (page.size() == LINES_PER_PAGE) {
                pages.add(page);
                page = new ArrayList<>();
            }
        }
        // Add the last line to the page
        if (line.length() > 0) {
            page.add(line.toString().trim());
        }
        // Add the last page to the pages
        if (!page.isEmpty()) {
            pages.add(page);
        }
        // Add page separation marks to the pages
        addPageSeparationMarks(pages);
        return pages;
    }

    //Method that adds page separation marks to the pages
    public static void addPageSeparationMarks(List<List<String>> pages) {
        int pageCount = 1;
        // Add page separation marks to the pages
        for (List<String> page : pages) {
            // If the page is not full, add empty lines to it
            if (page.size() < LINES_PER_PAGE) {
                for (int i = page.size(); i < LINES_PER_PAGE; i++) {
                    page.add("");
                }
            }
            page.add("---- Page " + pageCount + " ----");
            pageCount++;
        }
    }

    //Method that prints the pages to the output file
    public static void printPages(List<List<String>> pages) {
        // Print the pages to the output file
        try (PrintWriter writer = new PrintWriter("./output/output.txt", "UTF-8")) {
            for (List<String> page : pages) {
                for (String line : page) {
                    writer.println(line);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}