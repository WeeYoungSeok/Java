package oo;

public class lotto1 {
	private int[] make() {
		int[] arr = new int[6];
		int index = 0;
		while(index < 6) {
			int insert = (int)(Math.random()*45)+1;
			if(!isSame(arr,insert)) {
				arr[index] = insert;
				index++;
			}
		}
		return arr;
	}
	private boolean isSame(int[] arr, int insert) {
		boolean res = false;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == insert) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	private void sort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length; j++) {
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j-1];
					arr[j-1]=arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public void prn() {
		
		int[] arr = make();
		sort(arr);
		
		System.out.print("로또 번호  : ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
