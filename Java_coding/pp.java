package oo;

import java.util.Scanner;

public class pp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("파스칼 삼각형의 세로의 길이를 입력하세요(0입력시 종료) : ");
		int n = sc.nextInt();
		if(n==0) break;
		int[][] a = new int[n][];
		int count = 1;

		int i, j;

		for (i = 0; i < a.length; i++) {
			a[i] = new int[i + 1];

		}
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				a[i][j] = count;

				if (i > 1 && (j > 0 && j < i)) {
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
				}

			}
		}
		

		for ( i = 0; i < n; i++) {

			for (int k = 0; k < n - i; k++) {
				System.out.print("  ");
			}
			for (j = 0; j <= i; j++) {
				System.out.printf("%4d", a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	}

}
