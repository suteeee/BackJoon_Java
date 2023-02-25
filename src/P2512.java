import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int locale = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] requests = new int[st.countTokens()];


        for (int i = 0; i < requests.length; i++) {
            int request = Integer.parseInt(st.nextToken());
            requests[i] = request;
        }

        Arrays.sort(requests);

        int max = Integer.parseInt(bf.readLine());

        int res = 0;
        int start = 0;
        int end = requests[requests.length - 1];

        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < locale; i++) {
                sum += Math.min(requests[i], mid);
            }

            if (sum <= max) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
