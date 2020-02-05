import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {

    private final List<String> words;
    private List<String> compositeWords;

    public Solver(List<String> words) {
        this.words = words;
        sortWords();
    }

    // this method sort words list property by word length ascending;
    private void sortWords() {
        Collections.sort(words, (w1, w2) -> w1.length() - w2.length());
    }

    public String findNLongestCompositeWord(int n) {
        if (compositeWords == null) {
            retrieveComposite();
        }
        int index = compositeWords.size() - n;
        return compositeWords.get(index);
    }


    public int getCountConcatenatedWords() {
        if (compositeWords != null) {
            return compositeWords.size();
        }
        retrieveComposite();
        return compositeWords.size();
    }


    // this method return only those words,
    // which cannot be represented as concatenation
    // of another words presented in input list;
    private List<String> removeComposite() {
        List<String> strongWords = new ArrayList<>();
        for (String word:words) {
            String temp = word;
            for (String strong:strongWords) {
                temp = temp.replaceAll(strong, "");
            }
            if (!temp.equals("")) {
                strongWords.add(word);
            }
        }
        return strongWords;
    }

    private void retrieveComposite() {
        List<String> strongWords = removeComposite();
        List<String> compositeWords = new ArrayList<>(words);
        compositeWords.removeAll(strongWords);
        this.compositeWords = compositeWords;
    }
}
