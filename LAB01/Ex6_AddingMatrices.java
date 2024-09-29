import java.util.Arrays;
import java.util.Scanner;

public class Ex6_AddingMatrices {
    public static void main(String[] args){
        int n,m;
        System.out.println("Please enter number of rows: ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        System.out.println("Please enter number of columns: ");
        n = sc.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        System.out.println("Elements of matrix 1: ");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                a[i][j]= sc.nextInt();
            }
        }
        System.out.println("Elements of matrix 2: ");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                b[i][j]= sc.nextInt();
            }
        }
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                a[i][j]+=b[i][j];
            }
        }
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}