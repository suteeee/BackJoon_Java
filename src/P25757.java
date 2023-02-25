import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int gameMember = 0;
        String game = st.nextToken();

        if (game.equals("Y")) gameMember = 2;
        else if (game.equals("F")) gameMember = 3;
        else if (game.equals("O")) gameMember = 4;

        HashSet<String> users = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = bf.readLine();
            users.add(name);
        }

        bw.write("" + users.size() / (gameMember-1));
        bw.flush();
        bw.close();
    }
}
