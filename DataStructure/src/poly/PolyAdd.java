package poly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PolyAdd {
	public static void main(String[] args) throws NumberFormatException, IOException {
       int n,x,y;
       System.out.println("POLYNOMIAL ADDITION");
       LinkList A=new LinkList();
       LinkList B=new LinkList();
       LinkList C=new LinkList();
  //A是linklist类，为什么可以调用link类方法?     
       BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
       for(int j=1;j<=2;j++){
    	   //To insert the polynomials
    	   System.out.println("Enter the "+j+" Polunomial:");
    	   System.out.println("Enter the number of terms:");
    	   n=Integer.parseInt(f.readLine());
    	   for(int i=1;i<=n;i++){
    		   System.out.println("Enter the coeff&exponent of "+i+" term");
    		   x=Integer.parseInt(f.readLine());
    		   y=Integer.parseInt(f.readLine());
    		   if(j==1)
    			   A.create(x, y);
    		   //Assign values to links
    		   else
    			   B.create(x, y);
    	   }
       }
       
       System.out.println("First polynomial is:");
       A.disp();//Display the first polynomial
       System.out.println("Second Polynomial is:");
       B.disp();
       C.padd(A, B);
       C.disp();
       
       
	}

}
