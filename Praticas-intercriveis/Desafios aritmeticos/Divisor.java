import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nroA = Integer.parseInt(st.nextToken());
        int nroB = Integer.parseInt(st.nextToken());
        int nroC = Integer.parseInt(st.nextToken());
        int nroD = Integer.parseInt(st.nextToken());
        br.close();

        int n = -1;

        if (nroC % nroA == 0) {
            for (int i = nroA; i <= nroC; i++) {
                if (i % nroA == 0 && i % nroB != 0 && (nroC % i == 0) && (nroD % i != 0)) {
                    n = i;
                    break;
                }
            }
        }
        System.out.println(n);
    }
}