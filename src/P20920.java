import java.io.*;
import java.util.*;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = bf.readLine();
            if (word.length() < m) continue;

            Integer cnt = map.get(word);
            if (cnt == null) cnt = 0;

            map.put(word, cnt + 1);
        }

        ArrayList<String> words = new ArrayList<>(map.keySet());
        words.sort((o1, o2) -> {
            if (map.get(o1) < map.get(o2)) return 1;
            else if (map.get(o1) > map.get(o2)) return -1;
            else {
                if (o1.length() < o2.length()) return 1;
                else if (o1.length() > o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });

        for (String word: words) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
