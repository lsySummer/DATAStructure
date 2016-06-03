package examReview1;

public class Perm {

	static int sum = 0;

	private static void perm(int[] arr, int begin, int end) {
		if(begin == end){
			for(int i=0;i<arr.length;i++){
				System.out.println(arr[i]);
			}
			System.out.println();
		}
		else{
			for(int j = begin;j<=end;j++){
				swap(arr,j,begin);
				perm(arr,begin+1,end);
				swap(arr,j,begin);
			}
		}
		
	}
	private static void swap(int[]arr,int a1,int a2){
		int temp = arr[a1];
		arr[a1] = arr[a2];
		arr[a2] = temp;
	}
	public static void main(String[]args){
		int[]arr = {1,2,3};
		perm(arr,0,2);
	}
}
