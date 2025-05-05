import java.util.Scanner;

public class JiHyeon_boj_10818 {
    public static void main(String[] args) {
//        사용하는 자료구조 : 배열(array)
//        개념 : 반복문 + 배열 순회

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }

        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<N; i++){
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }

//        System.out.println(min +' '+ max); // 문자아스키코드를 더해버린다.
        System.out.println(min + " "+ max);

    }
}
