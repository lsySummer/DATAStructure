package examReview1;

public class FindMax {
	public static int findMax(int[] a,int n){
		if(n == 0){
			return a[0];
		}else{
			int temp = findMax(a,n-1);
			return temp>a[n-1]?temp:a[n-1];
		}
	}
	
	public static double getAverage(int[]a,int n){
		if(n == 0){
			return a[0];
		}else{
			return (getAverage(a,n-1)*(n-1)+a[n-1])/n;
		}
	}
	
	public static void main(String []args){
		int []a = {1,13,4};
		System.out.println(findMax(a,3));
		System.out.println(getAverage(a,3));
	}
}

