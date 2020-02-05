import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

   private static final String FILE = "words.txt";
   private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        List<String> words = Files.readAllLines(Paths.get(FILE), UTF_8);

        Solver solver = new Solver(words);
        String longestCompositeWord = solver.findLongestCompositeWord();
        String secondLongest = solver.findSecondLongestCompostieWord();
        int countOfConcatenatedWords = solver.getCountConcatenatedWords();

        StringBuilder output = new StringBuilder();
        output.append("the longest concatenated word is:")
                .append(System.lineSeparator())
                .append(longestCompositeWord)
                .append(System.lineSeparator())
                .append(secondLongest)
                .append(System.lineSeparator())
                .append("total concatenated words count:")
                .append(countOfConcatenatedWords);

        Files.write(Paths.get(OUTPUT), Collections.singletonList(output.toString()), UTF_8, CREATE);
    }
}
