import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bf.readLine().split("");
        ArrayList<String> sentence = new ArrayList<>(Arrays.asList(input));
        int cursor = sentence.size();

        int loopSize = Integer.parseInt(bf.readLine());

        for (int loop = 0; loop < loopSize; loop++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String com = st.nextToken();

            switch (com) {
                case "P":
                    if (cursor >= sentence.size()) sentence.add(st.nextToken());
                    else sentence.add(cursor, st.nextToken());
                    cursor+=1;
                    break;

                case "L":
                    if (cursor > 0) cursor--;
                    break;

                case "D":
                    if (cursor < sentence.size()) cursor ++;
                    break;

                case "B":
                    if (cursor > 0) {sentence.remove(--cursor);}
                    break;
            }
        }

        bw.write(String.join("", sentence));
        bw.flush();
        bw.close();
    }
}
