import java.util.*;

public class janghyuk_boj_7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // 개행 제거

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = sc.nextLine().split(" ");
            String name = log[0];
            String action = log[1];

            if (action.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        
        // 정렬
        List<String> result = new ArrayList<>(set);
        Collections.sort(result, Collections.reverseOrder());

        for (String name : result) {
            System.out.println(name);
        }
    }
}
