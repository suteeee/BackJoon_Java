import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class P1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] alphabets = bf.readLine().toLowerCase().split("");
        HashMap<String, Integer> cntMap = new HashMap<>();

        for (String alphabet : alphabets) {
            Integer curVal = cntMap.get(alphabet);
            if (curVal == null) curVal = 0;

            cntMap.put(alphabet, curVal + 1);
        }

        int max = 0;
        Object[] values = cntMap.values().toArray();
        for (Object value : values) {
            Integer val = (Integer) value;

            if (max < val) max = val;
        }

        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < values.length; i++) {
            Integer val = (Integer) values[i];
            if (val == max) {
                cnt++;
                idx = i;
            }
        }

        if (cnt > 1) {
            bw.write("?");
        } else {
            Object[] keys = cntMap.keySet().toArray();
            bw.write(((String)keys[idx]).toUpperCase());
        }

        bw.flush();
        bw.close();
    }
}
