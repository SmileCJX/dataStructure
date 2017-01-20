

public class SeqStack {
		//定义顺序栈空间的最大容量
		private static final int MAXSIZE = 100;
		//用于存储栈顶位置
		private static int top;
		//顺序栈的存储空间
		private double[] data;
		//构造函数，调用顺序栈初始化函数，建立存储容量为MAXSIZE的空栈
		SeqStack(){
			Init_SeqStack(MAXSIZE);
		};
		SeqStack(double [] arr){
			Init_SeqStack(MAXSIZE);
			for (int i=0;i<arr.length; i++){
				top++;
				data[top] = arr[i];
			}
		}
		//初始化空栈
		private void Init_SeqStack(int size){
			data = new double [size];
			top = -1;
		}
		//栈判空方法
		public int empty_SeqStack(){
			if (top == -1){
				return 1;
			}else{
				return 0;
			}
		}
		//栈判满算法
		public int full_SeqStack(){
			if (top == MAXSIZE-1){
				return 1;
			}else{
				return 0;
			}
		}
		//入栈算法
		public int push_SeqStack(double x){
			//栈满不能入栈
			if (full_SeqStack()==1){
				return 0;
			}else{
				top++;
				data[top] = x;
				return 1;
			}
		}
		//出栈算法
		public Object pop_SeqStack(){
			//栈空不能出栈
			if (empty_SeqStack()== 1){
				return null;
			//更新栈顶位置
			}else{
				return data[top--];
			}
		}
		//读栈顶元素算法
		public Object top_SeqStack(){
			if (empty_SeqStack()==-1){
				return null;
			}else{
				return data[top];
			}
		}
		
		
		
		public  void print(){
			for (int i=0; i<top; i++){
				System.out.print(data[i]+" ");
			}
		}
	
		public int length(){
			return top;
		}
}
