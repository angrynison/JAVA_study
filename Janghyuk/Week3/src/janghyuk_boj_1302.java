import java.io.*;
import java.util.*;

    public class janghyuk_boj_1302 {
        public static void main(String[] args) throws IOException {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            int max = 0;

            TreeMap<String, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    System.out.println(entry.getKey());
                    break;
                }
            }
        }

    }

