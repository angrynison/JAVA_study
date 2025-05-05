import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class janghyuk_boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        //조건에 따라 다르게 쓰일 두개의 HashMap
        HashMap<Integer, String> hash1 = new HashMap<Integer, String>();
        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();


        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            hash1.put(i, S);
            hash2.put(S, i);
        }

        for(int i = 0; i < M; i++) {
            String S = br.readLine();
            //입력값이 번호인지 포켓몬이름인지 판별
            if(49 <= S.charAt(0) && S.charAt(0) <= 57) {
                sb.append(hash1.get(Integer.parseInt(S))).append("\n");
            }else {
                sb.append(hash2.get(S)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
