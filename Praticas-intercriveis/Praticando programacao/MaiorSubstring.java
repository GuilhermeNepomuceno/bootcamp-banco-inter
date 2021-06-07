import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MaiorSubstring {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String firstLine, secondaryLine, min, max;
        while ((firstLine = in.readLine()) != null) {
            secondaryLine = in.readLine();
            if (firstLine.length() > secondaryLine.length()) {
                max = firstLine;
                min = secondaryLine;
            } else {
                max = secondaryLine;
                min = firstLine;
            }
            int minLength = min.length();
            int maxSubstring = minLength;
            boolean notSubstring = true;
            while (maxSubstring > 0 && notSubstring) {
                int diff = minLength - maxSubstring;
                for (int i = 0; i <= diff; i++) {
                    if (max.contains(min.substring(i, i + maxSubstring))) {
                        notSubstring = false;
                        maxSubstring++;
                        break;
                    }
                }
                maxSubstring--;
            }
            System.out.println(maxSubstring);
        }
        out.close();
    }

}