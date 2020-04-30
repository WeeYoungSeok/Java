package oo;

import java.util.Scanner;

public class dalpange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("달팽이 n X n : ");

		int n = sc.nextInt();
		int[][] dal = new int[n][n];
		int x = 0;
		int y = -1;
		int inc = 1;
		int count = 1;
		
		while(n>0) {
		for(int i = 0; i<n; i++ ) {
			y+=inc;
			dal[x][y] = count;
			count++;
		}
		n--;
		if(n==0) break;
		for(int i = 0; i<n; i++) {
			x+=inc;
			dal[x][y] = count;
			count++;
		}
		inc *= -1;
	}
		// 여기서 n이 0인 상애로 밑의 for문에 들어가기 때문에
		// i < dal.length말고 n을 넣으면 출력문이 다 조건이 거짓이 된다.
		// 그래서 출력을 못한다.
		
		for(int i = 0; i < dal.length; i++) {
			for(int j = 0; j < dal[i].length; j++) {
				System.out.printf("%3d",dal[i][j]);
			}
			System.out.println();
		}
	}
	
	

}
