import java.io.*;
import java.util.*;

public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st1.nextToken()); //출전 국가 수
        int k = Integer.parseInt(st1.nextToken()); //알고싶은 나라 idx

        int[] countries = new int[n+1];

        ArrayList<Integer> scores = new ArrayList<>();

        int selected = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            int score = (gold * 10000) + (silver * 100) + bronze;
            if (!scores.contains(score)) scores.add(score);

            if (index == k) selected = score;

            countries[index] = score;
        }

        scores.sort(Collections.reverseOrder());
        int selectedIdx = scores.indexOf(selected);

        int rating = 1;
        int delay = 1;

        for (int i = 1; i <= selectedIdx; i ++) {
            //이전꺼랑 같으면 등수고정
            //달라질때 점핑

            if (countries[i-1] != countries[i]) {
                rating += delay;
                delay = 1;
            }
            else delay += 1;
        }

        bw.write(String.valueOf(rating));
        bw.flush();
        bw.close();
    }
}
