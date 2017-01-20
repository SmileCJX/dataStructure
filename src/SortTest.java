import java.util.Scanner;

public class SortTest {
	public static int compareCount = 0;
	public static int moveCount = 0;
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		System.out.print("请输入数组的个数:");
		int [] array = new int[input.nextInt()];
		System.out.print("请输入数组的元素:");
		for (int i=0; i<array.length; i++){
			array[i] = input.nextInt();
		}
		System.out.println("排序前的原数组:");
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
// 		选择其中一种排序算法，将其他排序算法注释
//		InsertSort(array);
//		BInsertSort(array);
//		BubbleSort(array);
		QuickSort(array,0,array.length-1);
		System.out.println("排序后的结果为:");
		print(array);
		System.out.println();
		System.out.println("比较次数的值为:"+compareCount);
		System.out.println("移动次数的值为:"+moveCount);
		System.out.print("请输入给定定值key:");
		int key = input.nextInt();
		System.out.println("关键key所在的位置:"+BinarySearch(array,key));
	}
	
	
	//对排序表a进行直接插入排序
	public static void InsertSort(int[] a){
		int i,j;
		int monitor;
		for (i=1; i<a.length; i++){
			if (a[i-1]>a[i]){
				monitor = a[i];//将a[i]插入a[1]..a[i-1]中,monitor为监视哨
				for(j = i-1; j!=-1 && monitor<=a[j]; compareCount++,j--){
					moveCount++;
					a[j+1] = a[j];//后移记录 
				}
				a[j+1] = monitor;//插入到合适位置
			}
		}
	}
	
	
	//对排序表a进行折半插入排序
	public static void BInsertSort(int[] a){
		for (int i=0; i<a.length; i++){
			int temp = a[i];//保存待插入元素
			int low=0;
			int high=i;//设置初始区间
			int mid;
			while(low<=high){//该循环语句完成确定插入位置
				mid = (low+high)/2;
				
				if (++compareCount>=1 && temp>a[mid]){
					low=mid+1;//插入位置在高半区中
				}else{
					high=mid-1;//插入位置在低半区中
				}	
			}
			for (int j=i-1; j>=high+1; j--){//high+1为插入位置
				moveCount++;
				a[j+1] = a[j];//后移元素,留出插入空位
			}
			a[high+1] = temp;//将元素插入
		}
	}
	
	//对排序表a进行冒泡排序
	public static void BubbleSort(int[] a){
		for (int i=1; i<a.length; i++){
			int swap = 0;//swap为是否交换的标志
			for (int j=0; j<a.length-i; j++){
				if (++compareCount>=1 && a[j]>a[j+1]){
					moveCount++;
					swap(a,j,j+1);
					swap = 1;//置交换标志位1，表示有交换发生
				}
			}
			if (swap==0){
				break;
			}
		}
	}
	
	//快速排序算法
	public static void QuickSort(int [] a,int s,int t){
		//对a[s]....a[t]进行快速排序
		int i;
		if (s<t){
			i = Partition(a,s,t);//将表一分为二
			QuickSort(a,s,i-1);//对支点前端子表递归排序
			QuickSort(a,i+1,t);//对支点后端子表递归排序
		}
	}
	
	//对子区间a[low]....a[high],以a[low]为支点进行划分，算法返回支点记录最终的位置
	public static int Partition(int [] a,int low,int high){
		int result=a[low];//暂存支点记录
		while(low<high){//从表的两段交替地向中间扫描
			while(low<high && ++compareCount>=1 && a[high]>=result){
				high--;
			}
			if (low<high){
				moveCount++;
				swap(a,low,high);
				low++; 
			}//将比支点记录小的交换到前面
			
			while(low<high && ++compareCount>=1 && a[low]<result){
				low++;
			}
			if (low<high){
				moveCount++;
				swap(a,low,high);
				high--;
			}//将比支点记录大的交换到后面
		}
		a[low] = result;//支点记录到位
		return low;//返回支点记录所在位置
	}
	//{36,20,18,10,60,25,30,18,12,56};
	public static void print(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	//对数组两个元素的值进行交换
	public static void swap(int [] a,int x,int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static int BinarySearch(int[] a,int key){
		//查找表数据存放在数组a中
		//在有序顺序表中查找关键码为key的数据元素,若找到，返回该元素在表中的位置；否则，返回0
		int mid,low = 0;//设置初始区间
		int high = a.length-1;
		while(low<=high){//当查找区间非空
			mid = (low+high)/2;//取区间中点
			if (key==a[mid]){
				return mid+1;//查找成功，放回mid+1
			}else if(key<a[mid]){
				high = mid-1;//调整到左半区
			}else{
				low = mid+1;//调整到半区
			}
		}
		return -1;//查找失败，返回-1
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