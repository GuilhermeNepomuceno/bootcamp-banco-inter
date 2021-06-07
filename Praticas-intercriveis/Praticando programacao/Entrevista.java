import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Entrevista {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word, fixedWord, repeatedString;
        int wordLength;

        while (st.hasMoreTokens()) {
            word = fixedWord = st.nextToken();
            wordLength = word.length();
            if ((wordLength < 30) && (wordLength > 4)) {
                boolean isFixed = false;

                while (!isFixed) {
                    for (int i = 1; i <= wordLength; i++) {
                        repeatedString = word.substring((wordLength - i), wordLength);
                        fixedWord = word.substring(0, (wordLength - i));
                        if (fixedWord.endsWith(repeatedString)) {
                            isFixed = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(fixedWord);
        }

    }

}
