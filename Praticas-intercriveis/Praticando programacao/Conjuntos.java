import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Conjuntos {
    public static void main(String[] args) throws IOException {
        List<String> wordSet = new ArrayList<String>();
        List<Boolean> results = new ArrayList<Boolean>();
        var inputReader = new BufferedReader(new InputStreamReader(System.in));
        var wordToken = readNextLine(inputReader);

        try {
            int elements = getElementsQuantity(wordToken);
            String word;
            while (checkSize(elements)) { // conjunto existe?
                do {
                    wordToken = readNextLine(inputReader);
                    word = wordToken.nextToken();
                    if (!word.chars().allMatch(Character::isDigit))
                        wordSet.add(word.toLowerCase());
                    else
                        System.exit(1);
                    elements--;

                } while (elements > 0);
                results.add(isBad(wordSet));
                wordSet.clear();
                wordToken = readNextLine(inputReader);
                elements = getElementsQuantity(wordToken);
            }
            printResults(results);
        } catch (NumberFormatException | NoSuchElementException e) {
            System.exit(1);
        }

    }

    private static StringTokenizer readNextLine(BufferedReader inputs) throws IOException {
        StringTokenizer inputRow = new StringTokenizer(inputs.readLine());
        return inputRow;
    }

    private static boolean isSetEmpty(int setSize) throws NumberFormatException {
        if (setSize > 0)
            return false;
        return true;
    }

    private static boolean checkSize(int setSize) throws NumberFormatException {
        if (!isSetEmpty(setSize)) {
            if (isInbound(setSize))
                return true;
        }
        return false;
    }

    private static boolean isInbound(int setSize) throws NumberFormatException {
        if ((setSize >= 1) && (setSize <= 100000))
            return true;
        return false;
    }

    private static int getElementsQuantity(StringTokenizer input) throws NumberFormatException {
        return Integer.parseInt(input.nextToken());
    }

    private static boolean isBad(List<String> words) {
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            if (isPrefix(iterator.next(), words)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrefix(String prefix, Collection<String> words) {
        if (!isRepeated(prefix, words)) {
            return words.stream().filter(word -> (!word.equals(prefix))).anyMatch(word -> word.startsWith(prefix));
        }
        return true;
    }

    private static boolean isRepeated(String prefix, Collection<String> words) {
        if (Collections.frequency(words, prefix) > 1)
            return true;
        return false;
    }

    private static void printResults(List<Boolean> results) {
        results.forEach(result -> {
            if (result) {
                System.out.println("Conjunto Ruim");
            } else {
                System.out.println("Conjunto Bom");
            }

        });
    }
}