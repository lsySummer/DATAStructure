package examReview1;

public class Palidromes {
	public static boolean isPalindrome(String s){
		return isPalindrome(s,0,s.length()-1);
	}
	
	public static boolean isPalindrome(String s,int low,int high){
		if(high<=low){
			return true;
		}else if(s.charAt(low)!=s.charAt(high)){
			return false;
		}else{
			return isPalindrome(s,low+1,high-1);
		}
	}
	
	public static boolean palindrome(String word,int low,int high){
		if(low>=high){
			return true;
		}while(!Character.isLetter(word.charAt(low))){
			low++;
		}while(!Character.isLetter(word.charAt(high))){
			high--;
		}if(word.charAt(low) == word.charAt(high)||Math.abs(word.charAt(low)-word.charAt(high))==32){
			return palindrome(word,low+1,high-1);
		}else{
			return false;
		}
	}
	
	public static boolean sentence(String word){
		String s1 = word.toLowerCase();
		String s2 = "";
		for(int i=0;i<word.length();i++){
			if(s1.charAt(i)>='a'&&s1.charAt(i)<='z'){
				s2 += s1.charAt(i);
			}
		}
		return palindrome(s2,0,s2.length()-1);
	}
}
