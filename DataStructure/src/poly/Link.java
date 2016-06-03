package poly;

public class Link {
	int exp;
	float coef;
	Link next;
	Link(float a,int b){
		coef=a;
		exp=b;
	}
	void display(){
		System.out.println(" "+coef+"x^"+exp);
	}
}


