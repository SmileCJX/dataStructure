import java.util.Scanner;

public class SeqStack_test {
	public static void main(String[] args) {
		int p1a23;
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char[] arr = str.toCharArray();
		double result = calcul_exp(arr);
		System.out.println("后缀表示式的结果为:"+result);
//		System.out.println(midToBack(arr));
	}

	
	//后缀表达式求值
	public static double calcul_exp(char[] arr) {
		double a, b;
		int i = 0;
		char ch = arr[i];
		i++;
		double c = 0;

		SeqStack s = new SeqStack();

		while (ch != '#') {
			if (ch >= '0' && ch <= '9') {
				s.push_SeqStack((double) (ch - '0'));
			} else {
				// 取出两个运算量
				b = (double) (s.pop_SeqStack());
				// System.out.println(b);
				a = (double) (s.pop_SeqStack());
				// System.out.println(a);
				switch (ch) {
				case '+':
					c = a + b;
					break;
				case '-':
					c = a - b;
					break;
				case '*':
					c = a * b;
					break;
				case '/':
					/*try{
						c = a / b;
					}catch(Exception e){
						e.printStackTrace();
					}*/
					c = a/b;
					break;
				case '%':
					c = a % b;
					break;
				case '^':
					c = (double) Math.pow(a, b);
					break;
				}
				s.push_SeqStack(c);
			}
			ch = arr[i];
			i++;
		}
		double result = ((double) s.pop_SeqStack());
		return result;
	}

	public static char[] midToBack(char[] arr) {
		SeqStack s1 = new SeqStack();
		SeqStack s2 = new SeqStack();
		s2.push_SeqStack('#');
		int i = 0;
		char ch = arr[i];
		while (ch != '#' || (char) s2.top_SeqStack() != '#') {
			if (ch >= '0' && ch <= '9') {
				s1.push_SeqStack(ch);
				i++;
				ch = arr[i];
			} else {
				if ((char) s2.top_SeqStack() == '(' && ch == ')') {
					s2.pop_SeqStack();
					i++;
					ch = arr[i];
				} else if (compare((char) s2.top_SeqStack(), ch) > 0) {
					s2.push_SeqStack(ch);
					i++;
					ch = arr[i];
				} else {
					s1.push_SeqStack((char) s2.pop_SeqStack());
				}
			}
		}
		s1.push_SeqStack('#');
		char[] b = new char[s1.length()];
		for (int j = s1.length() - 1; j >= 0; j--) {
			b[j] = (char) s1.pop_SeqStack();
		}
		return b;
	}

	public static int compare(char a, char b) {
		int m = -2, n = -2;
		switch (a) {
		case '^':
			m = 3;
			break;
		case '*':
		case '/':
		case '%':
			m = 2;
			break;
		case '+':
		case '-':
			m = 1;
			break;
		case '(':
			m = 0;
			break;
		case ')':
			m = -1;
			break;
		case '#':
			m = -2;
			break;

		}
		switch (b) {
		case '^':
			n = 4;
			break;
		case '*':
		case '/':
		case '%':
			n = 2;
			break;
		case '+':
		case '-':
			n = 1;
			break;
		case '(':
			n = 4;
			break;
		case ')':
			n = -1;
			break;
		case '#':
			n = -2;
			break;

		}
		return n-m;
	}
}
