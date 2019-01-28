package test;

public class Caculating {
	private String cal;
	public double result;

	Caculating(String cal) {
		this.cal = cal;
		result = Caculate();
	}

	double Caculate() {
		BiTree root = null;
		double result = 0;
		char[][] str = new char[100][15];
		int length = cal.length();
		// System.out.println(length);
		char[] equation = cal.toCharArray();
		int i, j, k;
		i = 0;
		k = 0;
		while (i < length) { // 将表达式存储到str数组中
			if (equation[i] == '+' || equation[i] == '-' || equation[i] == '*' || equation[i] == '/'
					|| equation[i] == '(' || equation[i] == ')')
				str[k++][0] = equation[i++]; // 存储操作符
			else { // 存储数字
				j = 0;
				while (((equation[i] >= '0' && equation[i] <= '9') || equation[i] == '.')) {
					str[k][j] = equation[i];
					i++;
					j++;
					if (i >= length) {
						break;
					}
				}
				k++;
			}
		}
		/*
		 * for (i = 0; i < k; i++) { for (j = 0; j < str[i].length; j++) {
		 * System.out.print(str[i][j] + " "); } System.out.println(); }
		 */

		int start = 0;
		int end = k - 1;

		Boolean removable = RemoveBrackets(str, start, end);
		if (removable)
			root = CreateTreePreorder(str, start + 1, end - 1);
		else
			root = CreateTreePreorder(str, start, end);

		result = CaculateResult(root); // 计算表达式的结果*/

		return result;
	}

	private double CaculateResult(BiTree root) {
		// System.out.println("11111111111111");
		double result = 0;
		if (root.left == null && root.right == null) {
			result = StrToDigital(root.data);
			// System.out.println(root.data);
			return result;
		}
		double Lresult = CaculateResult(root.left);
		double Rresult = CaculateResult(root.right);
		switch (root.data[0]) {
		case '+':
			return Lresult + Rresult;
		case '-':
			return Lresult - Rresult;
		case '*':
			return Lresult * Rresult;
		case '/':
			return Lresult / Rresult;
		}
		return result;
	}

	private double StrToDigital(char str[]) {
		int i, len, pos;
		double sum;
		len = str.length;

		for (i = 0; i < len; i++) {
			if (str[i] == '.') {
				break;
			}
			if (str[i] == '\0') {
				break;
			}
		}
		pos = i;
		i = 0;
		sum = 0;
		// System.out.println(pos);
		while (i < len) {
			if (str[i] == '\0') {
				break;
			}
			// System.out.println(str[i]);
			if (i < pos) {
				sum += (str[i] - '0') * Math.pow(10, pos - i - 1);
				// System.out.println((str[i] - '0') * Math.pow(10, pos - i - 1));
			} else if (i > pos) {
				sum += (str[i] - '0') * Math.pow(10, pos - i);
				// System.out.println( (str[i] - '0') * Math.pow(10, pos - i));
			}
			i++;
		}
		// System.out.println(sum);
		return sum;
	}

	private BiTree CreateTreePreorder(char[][] str, int start, int end) {
		int pos = -1;// 记录优先级最低的符号位置
		int sign = 0;
		BiTree root = null;

		if (end - start == 0) {
			root = new BiTree(str[start]);
			return root;
		}
		pos = GetLowestOper(str, start, end);
		root = new BiTree(str[pos]);
		// 建立左子树
		Boolean removable = RemoveBrackets(str, start, pos - 1);
		if (removable)
			root.left = CreateTreePreorder(str, start + 1, pos - 2);
		else
			root.left = CreateTreePreorder(str, start, pos - 1);

		// 建立右子树
		removable = RemoveBrackets(str, pos + 1, end);
		if (removable)
			root.right = CreateTreePreorder(str, pos + 2, end - 1);
		else
			root.right = CreateTreePreorder(str, pos + 1, end);

		return root;
	}

	private int GetLowestOper(char[][] str, int start, int end) {
		int pos = -1;
		int sign = 0;
		int t = 1;
		while (pos == -1) {
			for (int i = start; i <= end; i++) {
				if (str[i][0] == '(') {
					i++;
					sign = 1; // 有一个左括号
					while (sign > 0) { // sign=0，表示括号去完了
						if (str[i][0] == '(')
							sign++;
						if (str[i][0] == ')')
							sign--;
						i++;
					}
					i--;
				}
				if (t == 1) {
					if (str[i][0] == '+' || str[i][0] == '-')
						pos = i; // 记录括号外优先级最低的加减符号位置
				} else {
					if (str[i][0] == '*' || str[i][0] == '/')
						pos = i; // 记录括号外优先级最低的乘除符号位置
				}
			}
			t++;
		}
		return pos;
	}

	private Boolean RemoveBrackets(char[][] str, int start, int end) {
		Boolean result = false;
		if (str[start][0] == '(' && str[end][0] == ')') {
			char flag = ')';
			for (int i = start + 1; i < end; i++) {
				if (str[i][0] == '(' || str[i][0] == ')')
					flag = str[i][0];
			}
			if (flag == ')')
				result = true;
		}
		return result;
	}

	public class BiTree {
		private char[] data;
		private BiTree left;
		private BiTree right;

		public BiTree() {

		}

		public BiTree(char[] data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
