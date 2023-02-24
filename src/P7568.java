import java.io.*;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        int [][] peoples = new int[n][2];
        int [] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            peoples[i][0] = Integer.parseInt(st.nextToken());
            peoples[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < peoples.length; i++) {
            int moreHeavy = 0;
            int[] cur = peoples[i];

            for (int j = 0; j < peoples.length; j++) {
                if (i == j) continue;

                int[] other = peoples[j];

                if (other[0] > cur[0] && other[1] > cur[1]) {
                    moreHeavy++;
                }
            }

            ratings[i] = moreHeavy + 1;
        }

        for (int i = 0; i < ratings.length - 1; i++) {bw.write(ratings[i] + " ");}
        bw.write(ratings[n-1] + "");
        bw.flush();
        bw.close();
    }
}
