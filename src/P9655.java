import java.io.*;

public class P9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());

        if (n % 2 == 0) bw.write("CY");
        else bw.write("SK");

        bw.flush();
        bw.close();
    }
}
