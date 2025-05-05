import java.util.Scanner;

public class JiHyeon_boj_10828_arraylist {
    public static void main(String[] args) {
//        사용하는 자료구조 : 배열(arraylist)
//        개념 : 반복문 + 조건문
//        top으로 top을 기준으로 배열의 모든 값을 접근

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] stack = new int[N];
        int top = -1; // 비어있을 때 -1

        for(int i=0; i<N; i++){
            String line = scanner.next();

            if(line.equals("push")){
                int num = scanner.nextInt();
                stack[++top] = num; // top++ 은 top를 먼저 사용하고, top에 1을 더한다.

            } else if (line.equals("pop")) {
                if(top==-1){
                    System.out.println(-1);
                }else {
                    System.out.println(stack[top--]); // pop하기 전에 print가 먼저 수행되어야 하기 때문에
                }

            } else if (line.equals("size")) {
                System.out.println(top+1);

            } else if (line.equals("empty")){
                if(top==-1){
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }

            } else if (line.equals("top")) {
                if(top==-1){
                    System.out.println(-1);
                }else {
                    System.out.println(stack[top]);
                }

            }
        }

    }
}
