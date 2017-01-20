

public class SeqStack {
		//����˳��ջ�ռ���������
		private static final int MAXSIZE = 100;
		//���ڴ洢ջ��λ��
		private static int top;
		//˳��ջ�Ĵ洢�ռ�
		private double[] data;
		//���캯��������˳��ջ��ʼ�������������洢����ΪMAXSIZE�Ŀ�ջ
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
		//��ʼ����ջ
		private void Init_SeqStack(int size){
			data = new double [size];
			top = -1;
		}
		//ջ�пշ���
		public int empty_SeqStack(){
			if (top == -1){
				return 1;
			}else{
				return 0;
			}
		}
		//ջ�����㷨
		public int full_SeqStack(){
			if (top == MAXSIZE-1){
				return 1;
			}else{
				return 0;
			}
		}
		//��ջ�㷨
		public int push_SeqStack(double x){
			//ջ��������ջ
			if (full_SeqStack()==1){
				return 0;
			}else{
				top++;
				data[top] = x;
				return 1;
			}
		}
		//��ջ�㷨
		public Object pop_SeqStack(){
			//ջ�ղ��ܳ�ջ
			if (empty_SeqStack()== 1){
				return null;
			//����ջ��λ��
			}else{
				return data[top--];
			}
		}
		//��ջ��Ԫ���㷨
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
