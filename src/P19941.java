import java.io.*;
import java.util.StringTokenizer;

public class P19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int eatables = 0;

        String[] table = bf.readLine().split("");

        for (int i = 0; i < table.length; i++) {
            if (!table[i].equals("P")) continue;

            for (int j = k; j > 0; j--) {
                if (i-j < 0 || i+j >= table.length) continue;

                if (table[i-j].equals("H") || table[i+j].equals("H")) {
                    if (table[i-j].equals("H")) {
                        table[i - j] = "E";
                        bw.write("index[" + i + "] people eat h in [" + (i-j) + "]");
                    }
                    else if (table[i+j].equals("H")) {
                        table[i + j] = "E";
                        bw.write("index[" + i + "] people eat h in [" + (i+j) + "]");
                    }
                    bw.newLine();

                    eatables++;
                    break;
                }
            }
        }
        bw.write(""+eatables);
        bw.flush();
        bw.close();
    }
}
