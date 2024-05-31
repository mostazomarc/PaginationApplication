package src;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
public class PaginationApplicationTest {

    //Test that ckecs if the input String is paginated correctly with a maximum of 80 characters per line and 25 lines per page
    @Test
    public void testPaginate() {
        String file = "This is a sample text file for testing pagination that uses a maximum of 80 characters per line and 25 lines per page. This is a sample text file for testing pagination that uses a maximum of 80 characters per line and 25 lines per page.";
        //paginate the file
        List<List<String>> pages = PaginationApplication.paginate(file);
        // Assert that each page has a maximum of 25 lines
        for (List<String> page : pages) {
            assertTrue("The page should have a maximum of 25 lines", page.size() <= 26); // 25 lines + 1 page separation mark

            // Assert that each line has a maximum of 80 characters
            for (String line : page) {
                assertTrue("The line should have a maximum of 80 characters", line.length() <= 80);
            }
        }

        
       
    }

    //Test that cheks if page separation marks are added correctly
    @Test
    public void testAddPageSeparationMarks() {
        List<List<String>> pages = new ArrayList<>();

        //fill page with dummy lines
        List<String> page1 = new ArrayList<>();
        page1.add("Line 1");
        page1.add("Line 2");
        page1.add("Line 3");
        pages.add(page1);
        
        //fill page with dummy lines
        List<String> page2 = new ArrayList<>();
        page2.add("Line 4");
        page2.add("Line 5");
        page2.add("Line 6");
        pages.add(page2);
        
        //add page separation marks to the pages
        PaginationApplication.addPageSeparationMarks(pages);
        
        // Assert the page separation mark in the first page
        assertEquals("---- Page 1 ----", pages.get(0).get(page1.size() - 1));
        
        // Assert the page separation mark in the second page
        assertEquals("---- Page 2 ----", pages.get(1).get(page2.size() - 1));
    }

    //Page that checks if the output is printed correctly
    @Test
    public void testPrintPages() {
        List<List<String>> pages = new ArrayList<>();

        //fill page with dummy lines
        List<String> page1 = new ArrayList<>();
        page1.add("Line 1");
        page1.add("Line 2");
        page1.add("Line 3");
        pages.add(page1);

        //fill page with dummy lines
        List<String> page2 = new ArrayList<>();
        page2.add("Line 4");
        page2.add("Line 5");
        page2.add("Line 6");
        pages.add(page2);
        
        //print the pages to the output file
        PaginationApplication.printPages(pages);
        
        // Assert the content of the output file that shoud be the same as page1 and page2
        try (BufferedReader reader = new BufferedReader(new FileReader("./output/output.txt"))) {
            assertEquals("Line 1", reader.readLine());
            assertEquals("Line 2", reader.readLine());
            assertEquals("Line 3", reader.readLine());
            assertEquals("", reader.readLine());
            assertEquals("Line 4", reader.readLine());
            assertEquals("Line 5", reader.readLine());
            assertEquals("Line 6", reader.readLine());
            assertEquals("", reader.readLine());
            assertNull(reader.readLine()); // End of file
        } catch (IOException e) {
            fail("Failed to read the output file.");
        }
    }
}