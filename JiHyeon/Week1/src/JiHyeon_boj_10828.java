import java.util.Scanner;
import java.util.Stack;

public class JiHyeon_boj_10828 {
    public static void main(String[] args) {
//        사용하는 자료구조 : 스택(stack)
//        개념 : 반복문 + 조건문

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            String line = scanner.next();
            if (line.equals("push")){
                int num = scanner.nextInt();
                stack.push(num);

            } else if (line.equals("pop")) {
                if(stack.empty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.pop());
                }

            } else if (line.equals("size")) {
                System.out.println(stack.size());

            } else if (line.equals("empty")) {
                if(stack.empty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }

            } else if (line.equals("top")) {
                if(stack.empty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
