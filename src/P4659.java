import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = bf.readLine();
            if (input.equals("end")) break;

            String[] password = input.split("");
            List<String> gathers = new ArrayList<>(Arrays.asList("a", "e", "o", "u", "i"));

            boolean isAcceptable = true;
            boolean isMoeum = false;

            for (int i = 0; i < password.length; i++) {
                if (!isMoeum && gathers.contains(password[i])){
                    isMoeum = true;
                }

                if (password.length > 1 && i < password.length - 1 && (!password[i].equals("e") && !password[i].equals("o"))) {
                    if (password[i].equals(password[i+1])) {
                        isAcceptable = false;
                        break;
                    }
                }

                if (password.length > 2 && i < password.length - 2) {
                    if (gathers.contains(password[i]) && gathers.contains(password[i+1]) && gathers.contains(password[i+2])) {
                        isAcceptable = false;
                        break;
                    }

                    if (!gathers.contains(password[i]) && !gathers.contains(password[i+1]) && !gathers.contains(password[i+2])) {
                        isAcceptable = false;
                        break;
                    }
                }
            }

            if (!isAcceptable || !isMoeum) {
                bw.write("<" + input + "> is not acceptable.");
            } else {
                bw.write("<" + input + "> is acceptable.");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
