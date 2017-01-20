import java.util.Scanner;
/*
 * 无向图和有向图的实现，若为有向图可直接将g.edges[j][i] = 1去掉
 */
public class MGraph {
//	public MGraph g=null;
	private boolean[] flag;
	private int[] vexs;//顶点表
	private int [][] edges;//邻接矩阵
	private int vexnum;//图中节点的个数
	private int edgenum;//图中边的个数

	//vnum为输入的顶点个数,num为图中边的个数
	MGraph(int vnum,int num){
		vexs = new int[vnum];
		edges = new int[vnum][vnum];
		vexnum = vnum;
		edgenum = num;
		flag = new boolean[vnum];
	}
	
	public void InitFlag(){
		for (int i=0; i<flag.length; i++){
			flag[i] = false;
		}
	}
	public  MGraph create_MGraph(MGraph g){//建立无向图g的邻接矩阵存储
		int i,j;
		Scanner scanner = new Scanner(System.in);
	
		for (i=0; i<g.vexnum; i++){//输入顶点信息，建立顶点表
			vexs[i] = scanner.nextInt();
		}
		for (i=0; i<g.edges.length;i++){//初始化邻接矩阵
			for (j=0; j<g.edges[i].length; j++){
				g.edges[i][j] = 0;
			}
		}
		System.out.println("请输入边");
		for (int k=0; k<g.edgenum; k++){
			//依次输入num条边,每一条边用顶点对<i,j>表示
			i = scanner.nextInt();
			j = scanner.nextInt();
			//无向图，要建立(i,j),(j,i)边，即g.edges[i][j] = 1 && g.edges[j][i] = 1
			g.edges[i][j] = 1;
//			g.edges[j][i] = 1;
		}
		scanner.close();
		return g;
	}
	
	private void BFSM(MGraph g,int i){
		//以顶点i为出发点,对邻接矩阵存储的图g进行BFS搜索
		int j;
		int [] Q = new int[g.vexnum];//定义队列空间
		int front,rear;//定义队头和队尾变量
		//初始化为空
		front = 0;rear = -1;
		System.out.print(g.vexs[i]+" ");//访问顶点i
		g.flag[i] = true;//置访问标志
		//出发点顶点i入队
		rear++;Q[rear] = i;
		while(front<=rear){//当队不空
			//出队
			i = Q[front];
			//依次搜索顶点i的邻接点
			for (j=0; j<g.vexnum; j++){//依次搜索顶点i的邻接点
//				if(g.edges[i][j]==1 && g.edges[j][i]==1 && !g.flag[j]){//无向图  若邻接点顶点j未访问
				if(g.edges[i][j]==1 && !g.flag[j]){//有向图 若邻接点顶点j未访问
					System.out.print(g.vexs[j]+" ");//访问顶点j
					g.flag[j] = true;//置访问标志				
					rear++;Q[rear] = j;//访问过的顶点j入队
				}
			}
			front++;
		}
	}
	
	private void DFSM(MGraph g,int i){
		//以顶点i为出发点,对邻接矩阵存储的图g进行BFS搜索
		int j;
		int [] Q = new int[g.vexnum];//定义队列空间
		int front,rear;//定义队头和队尾变量
		//初始化为空
		front = 0;rear = -1;
		System.out.print(g.vexs[i]+" ");//访问顶点i
		g.flag[i] = true;//置访问标志
		//出发点顶点i入队
		rear++;Q[rear] = i;
		while(front<=rear){//当队不空
			//出队
			i = Q[front];
			//依次搜索顶点i的邻接点
			for (j=0; j<g.vexnum; j++){//依次搜索顶点i的邻接点
//				if(g.edges[i][j]==1 && g.edges[j][i]==1 && !g.flag[j]){//无向图 若邻接点顶点j未访问
				if(g.edges[i][j]==1 && !g.flag[j]){//有向图  若邻接点顶点j未访问
					System.out.print(g.vexs[j]+" ");//访问顶点j
					g.flag[j] = true;//置访问标志				
					rear++;Q[rear] = j;//访问过的顶点j入队
					break;
				}
			}
			front++;
		}
	}
	//广度优先遍历以邻接矩阵存储的图g
	public void BFSTraverseAL(MGraph g){
		int i;
		System.out.println("广度优先遍历的结果为:");
		for(i=0; i<g.vexnum; i++){
			if(!flag[i]){
				BFSM(g,i);//若顶点i未访问,从顶点i开始BFS搜索
			}
		}
		System.out.println();
	}
	
	public void DFSTraverseAL(MGraph g){
		int i;
		System.out.println("深度优先遍历的结果为:");
		for(i=0; i<g.vexnum; i++){
			if(!flag[i]){
				DFSM(g,i);//若顶点i未访问,从顶点i开始DFS搜索
			}
		}
		System.out.println();
	}
	public void test(MGraph g){
		System.out.println("顶点个数为："+g.vexnum);
		System.out.println("边的个数为："+g.edgenum);
		System.out.println("输出邻接矩阵:");
		for(int i=0; i<g.edges.length; i++){
			for (int j=0; j<g.edges[i].length; j++){
				System.out.print(g.edges[i][j]+" ");
			}
			System.out.println();
		}
	}
}


