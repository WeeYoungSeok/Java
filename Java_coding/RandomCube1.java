package com.random;

public class RandomCube1 {
	public static void main(String[] args) {
		prn();
	}
	
	public static void prn() {
		
		int[][] arr = new int[5][5];
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				int min = 1;
				int max = 9;
				int rd = (int)((Math.random() * (max - min + 1)) + min);
				arr[i][j] = rd;
				if(i==j || i+j==4) {
					sum += rd;
					count++;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("x형태의 총합 : " + sum);
		System.out.println("x형태의 평균 : " + (double)sum/count);
	}
}
