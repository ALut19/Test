import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

import static java.util.Collections.sort;


public class Sort {
    @Test
    public void main() {{
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("C:/Users/Андрей/Desktop/Новая папка/doc.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TreeSet<Integer> words = new TreeSet<>();
        while (scanner.hasNext()) {
            int word = Integer.parseInt(scanner.useDelimiter("\\s+").next());
            words.add(Integer.valueOf(word));
        }


        sort(words);
        System.out.println(words);
    }}

    private void sort(TreeSet<Integer> words) {
    }
}

