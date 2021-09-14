import java.util.Scanner;

public class Main {
	public static void Algorithms(int W[], int V[], int M, int n) {
		int B[][] = new int[n + 1][M + 1];
		
		for (int i=0; i<=n; i++)
			for (int j=0; j<=M; j++) {
				B[i][j] = 0;
			}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= M; j++) {
				B[i][j] = B[i - 1][j];
				
				if ((j >= W[i-1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) {
					B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1]; 
				}
	
			}
		
		}
		
		System.out.println("Max Value:\t" + B[n][M]);
		
		
		
		while (n != 0) {
			if (B[n][M] != B[n - 1][M]) {
				
				System.out.println(W[n - 1] + " "+ V[n - 1] + " (item "+(n-1)+")");
				M = M - W[n-1];
			}
			
			n--;
		}
	}
	
	public static void start() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
			int[] arrayOfWeight = new int[n];
			int[] arrayOfValue = new int[n];
			
				
					for(int i =0;i<arrayOfWeight.length;i++) {
					 arrayOfWeight[i]= scan.nextInt();
					}
					for(int i =0;i<arrayOfWeight.length;i++) {
						 arrayOfValue[i]= scan.nextInt();
						}
					scan.close();

					Algorithms(arrayOfWeight, arrayOfValue, m, n);
	}
	public static void main(String[] args) {
		start();
		
	}
}

