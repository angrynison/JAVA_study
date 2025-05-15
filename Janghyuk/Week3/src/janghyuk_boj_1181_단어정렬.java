import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        ArrayList<String> list = new ArrayList<>(set);

        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                else {
                    return s1.compareTo(s2);
                }
            }
        };

        Collections.sort(list, comp);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return;
    }
}
