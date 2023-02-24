import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("0 0 0")) { break; }

            StringTokenizer st = new StringTokenizer(input);
            int[] values = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(values);

            if (values[0] + values[1] <= values[2]) { bw.write("Invalid"); }
            else if ((values[0] != values[1]) && (values[0] != values[2]) && (values[1] != values[2])) {bw.write("Scalene");}

            else if (values[0] == values[1]) {
                if (values[0] != values[2]) {bw.write("Isosceles"); }
                else { bw.write("Equilateral"); }
            }

            else if (values[0] == values[2]) { bw.write("Isosceles");}
            else if (values[1] == values[2]) { bw.write("Isosceles");}
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}
