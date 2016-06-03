package postfix;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostFix {
	char y;

	public Stack<String> postfix(String str) {
		String temp = "";
		Stack<String> s1 = new Stack<String>();
		Stack<Character> s = new Stack<Character>();
		s.push('#');
		int n = 0;
		for (int i = 0; i < str.length(); i = i + 1 + n) {
			n = 0;
			if (Character.isDigit(str.charAt(i))) {
				n = 0;
				while (Character.isDigit(str.charAt(i + n)) || str.charAt(i + n) == '.') {
					// System.out.print(str.charAt(i + n));
					temp = temp + str.charAt(i + n);
					n++;
				}
				n = n - 1;
				// System.out.println();
				s1.push(temp + "");
				temp = "";
			} else if (str.charAt(i) == ')') {
				for (char y = s.pop(); y != '('; y = s.pop()) {
					// System.out.println(y);
					s1.push(y + "");
				}
			} else if (str.charAt(i) == '(') {
				s.push('(');
			} else {
				if (isp(y = s.pop(), str.charAt(i))) {
					// 如果栈顶元素优先级大于该字符优先级,则输出栈顶元素
					// System.out.println(y);
					s.push(str.charAt(i));
					s1.push(y + "");
				} else {
					s.push(y);
					s.push(str.charAt(i));
				}
			}

		}
		s.pop();
		while (s.peek() != '#') {
			// System.out.println(s.peek());
			s1.push("" + s.peek());
			s.pop();
		}
//		 while (!s1.isEmpty()) {
//		 System.out.println(s1.pop());
//		 }
		return s1;
	}

	public void calcu(Stack<String> s) {
		DecimalFormat df=new DecimalFormat("#.00");
			String result = s.pop();
			if (s.isEmpty()) {
				System.out.println(df.format(Double.parseDouble(result)));
//				return result;
			} else {
//				System.out.println("no end");
				s.push(result);
				Stack<String> st = new Stack<String>();
				while (!s.isEmpty()) {
					if (!isNumeric(s.peek())) {// 如果是符号的话
						String str1 = s.pop();
						if (!s.isEmpty() && isNumeric(s.peek())) {// 如果是数字的话
							String str2 = s.pop();
							double oper2 = Double.parseDouble(str2);
							if (!s.isEmpty() && isNumeric(s.peek())) {// 如果是数字的话
								double oper1 = Double.parseDouble(s.pop());
								String answer = calculate(oper1, oper2, str1);
//								System.out.println(answer);
								s.push(answer);
							} else {
								st.push(str1);
								st.push(str2);
							}
						} else {
							st.push(str1);
						}
					} else {
						String str1 = s.pop();
						st.push(str1);
					}
				}
				Stack<String> st2 = new Stack<String>();
				while (!st.isEmpty()) {
					String temp=st.pop();
//					System.out.println(temp);
					st2.push(temp);
				}
				calcu(st2);
				
			}
//			return result;
		

		
	}

	public String calculate(double oper1, double oper2, String oper) {
		String result1 = "";
		double result = 0;
		if (oper.equals("+")) {
			result = oper1 + oper2;
		} else if (oper.equals("-")) {
			result = oper1 - oper2;
		} else if (oper.equals("*")) {
			result = oper1 * oper2;
		} else if (oper.equals("/")) {
			result = oper1 / oper2;
		} else if (oper.equals("^")) {
			result = Math.pow(oper1, oper2);
		}
		result1 = result + "";
		return result1;
	}

	public boolean isNumeric(String str) {
//		Pattern pattern = Pattern.compile("[0-9]*");
//		Pattern pattern1 = Pattern.compile("^-?[0-9]+");
		Pattern pattern2=Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
//		Matcher isNum = pattern.matcher(str);
//		Matcher isNum1 = pattern1.matcher(str);
		Matcher isNum2=pattern2.matcher(str);
		if(str.equals("-")||str.equals("+")){
			return false;
		}
		else if (!isNum2.matches()) {
			return false;
		}
		return true;
	}

	public boolean isp(char x, char y) {// 如果x优先级大于y，则返回true
		boolean s = true;
		if (x == y)
			s = false;
		else if (x == '*') {
			if (y == '/' || y == '(')
				s = false;
		} else if (x == '/') {
			if (y == '*' || y == '(') {
				s = false;
			}
		} else if (x == '+' || x == '-') {
			if (y != '#')
				s = false;
		} else if (x == '#') {
			s = false;
		} else if (x == '(') {
			s = false;
		}

		return s;
	}

	public static void main(String[] args) throws IOException {
//		System.out.println("Input the expression");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
		String str="(1+2)*(3-4)#";
		PostFix p = new PostFix();
		Stack<String> s = p.postfix(str);
		p.calcu(s);
//		System.out.println(p.isNumeric("+"));

	}
}
