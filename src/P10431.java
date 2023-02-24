import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = Integer.parseInt(bf.readLine());

        for (int i = 0; i < loop; i++) {
            int backwalk = 0;

            String input =  bf.readLine();
            String[] st = input.split(" ");
            int idx = Integer.parseInt(st[0]);

            ArrayList<Integer> children = new ArrayList<>();
            children.add(Integer.parseInt(st[1]));

            for (int j = 2; j < 21; j++) {
                Integer cur = Integer.parseInt(st[j]); //현재 넣을 키
                boolean isAdded = false;

                for (int k = 0; k < children.size(); k++) {
                    Integer child = children.get(k);

                    //k번째 학생이 현재 학생보다 키가 크면
                    if (child > cur) {
                        backwalk += (children.size() - k);
                        children.add(k, cur); //k번째에 해당 학생 넣음
                        isAdded = true;
                        break;
                    }
                }

                if (!isAdded) children.add(cur);
            }

            bw.write(idx + " " + backwalk);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
