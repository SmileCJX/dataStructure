import java.util.Scanner;

public class SortTest {
	public static int compareCount = 0;
	public static int moveCount = 0;
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		System.out.print("����������ĸ���:");
		int [] array = new int[input.nextInt()];
		System.out.print("�����������Ԫ��:");
		for (int i=0; i<array.length; i++){
			array[i] = input.nextInt();
		}
		System.out.println("����ǰ��ԭ����:");
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
// 		ѡ������һ�������㷨�������������㷨ע��
//		InsertSort(array);
//		BInsertSort(array);
//		BubbleSort(array);
		QuickSort(array,0,array.length-1);
		System.out.println("�����Ľ��Ϊ:");
		print(array);
		System.out.println();
		System.out.println("�Ƚϴ�����ֵΪ:"+compareCount);
		System.out.println("�ƶ�������ֵΪ:"+moveCount);
		System.out.print("�����������ֵkey:");
		int key = input.nextInt();
		System.out.println("�ؼ�key���ڵ�λ��:"+BinarySearch(array,key));
	}
	
	
	//�������a����ֱ�Ӳ�������
	public static void InsertSort(int[] a){
		int i,j;
		int monitor;
		for (i=1; i<a.length; i++){
			if (a[i-1]>a[i]){
				monitor = a[i];//��a[i]����a[1]..a[i-1]��,monitorΪ������
				for(j = i-1; j!=-1 && monitor<=a[j]; compareCount++,j--){
					moveCount++;
					a[j+1] = a[j];//���Ƽ�¼ 
				}
				a[j+1] = monitor;//���뵽����λ��
			}
		}
	}
	
	
	//�������a�����۰��������
	public static void BInsertSort(int[] a){
		for (int i=0; i<a.length; i++){
			int temp = a[i];//���������Ԫ��
			int low=0;
			int high=i;//���ó�ʼ����
			int mid;
			while(low<=high){//��ѭ��������ȷ������λ��
				mid = (low+high)/2;
				
				if (++compareCount>=1 && temp>a[mid]){
					low=mid+1;//����λ���ڸ߰�����
				}else{
					high=mid-1;//����λ���ڵͰ�����
				}	
			}
			for (int j=i-1; j>=high+1; j--){//high+1Ϊ����λ��
				moveCount++;
				a[j+1] = a[j];//����Ԫ��,���������λ
			}
			a[high+1] = temp;//��Ԫ�ز���
		}
	}
	
	//�������a����ð������
	public static void BubbleSort(int[] a){
		for (int i=1; i<a.length; i++){
			int swap = 0;//swapΪ�Ƿ񽻻��ı�־
			for (int j=0; j<a.length-i; j++){
				if (++compareCount>=1 && a[j]>a[j+1]){
					moveCount++;
					swap(a,j,j+1);
					swap = 1;//�ý�����־λ1����ʾ�н�������
				}
			}
			if (swap==0){
				break;
			}
		}
	}
	
	//���������㷨
	public static void QuickSort(int [] a,int s,int t){
		//��a[s]....a[t]���п�������
		int i;
		if (s<t){
			i = Partition(a,s,t);//����һ��Ϊ��
			QuickSort(a,s,i-1);//��֧��ǰ���ӱ�ݹ�����
			QuickSort(a,i+1,t);//��֧�����ӱ�ݹ�����
		}
	}
	
	//��������a[low]....a[high],��a[low]Ϊ֧����л��֣��㷨����֧���¼���յ�λ��
	public static int Partition(int [] a,int low,int high){
		int result=a[low];//�ݴ�֧���¼
		while(low<high){//�ӱ�����ν�������м�ɨ��
			while(low<high && ++compareCount>=1 && a[high]>=result){
				high--;
			}
			if (low<high){
				moveCount++;
				swap(a,low,high);
				low++; 
			}//����֧���¼С�Ľ�����ǰ��
			
			while(low<high && ++compareCount>=1 && a[low]<result){
				low++;
			}
			if (low<high){
				moveCount++;
				swap(a,low,high);
				high--;
			}//����֧���¼��Ľ���������
		}
		a[low] = result;//֧���¼��λ
		return low;//����֧���¼����λ��
	}
	//{36,20,18,10,60,25,30,18,12,56};
	public static void print(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	//����������Ԫ�ص�ֵ���н���
	public static void swap(int [] a,int x,int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static int BinarySearch(int[] a,int key){
		//���ұ����ݴ��������a��
		//������˳����в��ҹؼ���Ϊkey������Ԫ��,���ҵ������ظ�Ԫ���ڱ��е�λ�ã����򣬷���0
		int mid,low = 0;//���ó�ʼ����
		int high = a.length-1;
		while(low<=high){//����������ǿ�
			mid = (low+high)/2;//ȡ�����е�
			if (key==a[mid]){
				return mid+1;//���ҳɹ����Ż�mid+1
			}else if(key<a[mid]){
				high = mid-1;//�����������
			}else{
				low = mid+1;//����������
			}
		}
		return -1;//����ʧ�ܣ�����-1
	}
}

/*		int [] a0 = {36,20,18,10,60,25,30,18,12,56};
int [] a1 = {60,50,40,-20,17,30,180,190,78,18,36,28};
int [] a2 = {10,20,30,40,50,60,70,5,8,20,19};
int [] a3 = {-3,-7,0,56,-20,46,30,28,17};
int [] a4 = {80,30,20,48,29,65,20};*/
/*		InsertSort(a0);
InsertSort(a1);
InsertSort(a2);
InsertSort(a3);
InsertSort(a4);*/
/*		BInsertSort(a0);
BInsertSort(a1);
BInsertSort(a2);
BInsertSort(a3);
BInsertSort(a4);*/
/*		BubbleSort(a0);
BubbleSort(a1);
BubbleSort(a2);
BubbleSort(a3);
BubbleSort(a4);*/
/*		QuickSort(a0,0,a0.length-1);
QuickSort(a1,0,a1.length-1);
QuickSort(a2,0,a2.length-1);
QuickSort(a3,0,a3.length-1);
QuickSort(a4,0,a4.length-1);*/
/*		print(a0);
System.out.println();
print(a1);
System.out.println();
print(a2);
System.out.println();
print(a3);
System.out.println();
print(a4);*/