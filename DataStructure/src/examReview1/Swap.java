package examReview1;

public class Swap {
	int x = 1;
	int y = 2;
	public void trySwap(int[]data,int x,int y){
		int temp = 0;
		temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}
	
	public void UseSwap(){
		int []data = {1,2};
		System.out.println("before Swap x = "+data[0]+" "+"y= "+data[1]);
		trySwap(data,0,1);
		System.out.println("after Swap x = "+data[0]+" "+"y= "+data[1]);
	}
	
	public static void main(String []args){
		Swap s = new Swap();
		s.UseSwap();
		
	}
}
