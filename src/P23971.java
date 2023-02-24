import java.io.*;
import java.util.StringTokenizer;

public class P23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int h = Integer.parseInt(st.nextToken()); //h행
        int w = Integer.parseInt(st.nextToken()); //w개
        int n = Integer.parseInt(st.nextToken()); //n세로
        int m = Integer.parseInt(st.nextToken()); //m가로

        // h줄에 w개씩
        //그냥 최대인원 수 : h * w

        //w-1개 를 m으로 나누기

        int widthLoop = (m + 1);
        int maxWidth = w / widthLoop;
        int widthRemainder = w % widthLoop;
        if (m != 0 && widthRemainder > 0) maxWidth++;

        int heightLoop = (n + 1);
        int maxHeight = h / heightLoop;
        int heightRemainder = h % heightLoop;
        if (n != 0 && heightRemainder > 0) maxHeight++;

        int res = maxWidth * maxHeight;

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
