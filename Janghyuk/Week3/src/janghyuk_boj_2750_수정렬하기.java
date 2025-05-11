import java.util.Scanner;
import java.io.*;
import java.util.*;
public class janghyuk_boj_2750_수정렬하기{

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int []sort (int n, int [] arr){

        for (int i = 0; i < n-1; i++) {
            int min_index = i;

            for (int j = i+1; j < n; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }

        return arr;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr = sort(n, arr);

        for ( int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        return ;
    }
}