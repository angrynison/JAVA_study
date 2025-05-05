import java.util.Scanner;
import java.util.Stack;

public class JiHyeon_boj_9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<N; i++){
            String line = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean stopCheck = false;

            for(int j=0; j<line.length(); j++){
                char str = line.charAt(j);

                if(str == '('){
                    stack.push(str);
                } else if (str == ')') {
                    if(stack.empty()){
                        System.out.println("NO");
                        stopCheck = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stopCheck) { // 중간에 NO 출력한 적 없을 때만
                if (stack.empty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }
}
