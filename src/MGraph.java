import java.util.Scanner;
/*
 * ����ͼ������ͼ��ʵ�֣���Ϊ����ͼ��ֱ�ӽ�g.edges[j][i] = 1ȥ��
 */
public class MGraph {
//	public MGraph g=null;
	private boolean[] flag;
	private int[] vexs;//�����
	private int [][] edges;//�ڽӾ���
	private int vexnum;//ͼ�нڵ�ĸ���
	private int edgenum;//ͼ�бߵĸ���

	//vnumΪ����Ķ������,numΪͼ�бߵĸ���
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
	public  MGraph create_MGraph(MGraph g){//��������ͼg���ڽӾ���洢
		int i,j;
		Scanner scanner = new Scanner(System.in);
	
		for (i=0; i<g.vexnum; i++){//���붥����Ϣ�����������
			vexs[i] = scanner.nextInt();
		}
		for (i=0; i<g.edges.length;i++){//��ʼ���ڽӾ���
			for (j=0; j<g.edges[i].length; j++){
				g.edges[i][j] = 0;
			}
		}
		System.out.println("�������");
		for (int k=0; k<g.edgenum; k++){
			//��������num����,ÿһ�����ö����<i,j>��ʾ
			i = scanner.nextInt();
			j = scanner.nextInt();
			//����ͼ��Ҫ����(i,j),(j,i)�ߣ���g.edges[i][j] = 1 && g.edges[j][i] = 1
			g.edges[i][j] = 1;
//			g.edges[j][i] = 1;
		}
		scanner.close();
		return g;
	}
	
	private void BFSM(MGraph g,int i){
		//�Զ���iΪ������,���ڽӾ���洢��ͼg����BFS����
		int j;
		int [] Q = new int[g.vexnum];//������пռ�
		int front,rear;//�����ͷ�Ͷ�β����
		//��ʼ��Ϊ��
		front = 0;rear = -1;
		System.out.print(g.vexs[i]+" ");//���ʶ���i
		g.flag[i] = true;//�÷��ʱ�־
		//�����㶥��i���
		rear++;Q[rear] = i;
		while(front<=rear){//���Ӳ���
			//����
			i = Q[front];
			//������������i���ڽӵ�
			for (j=0; j<g.vexnum; j++){//������������i���ڽӵ�
//				if(g.edges[i][j]==1 && g.edges[j][i]==1 && !g.flag[j]){//����ͼ  ���ڽӵ㶥��jδ����
				if(g.edges[i][j]==1 && !g.flag[j]){//����ͼ ���ڽӵ㶥��jδ����
					System.out.print(g.vexs[j]+" ");//���ʶ���j
					g.flag[j] = true;//�÷��ʱ�־				
					rear++;Q[rear] = j;//���ʹ��Ķ���j���
				}
			}
			front++;
		}
	}
	
	private void DFSM(MGraph g,int i){
		//�Զ���iΪ������,���ڽӾ���洢��ͼg����BFS����
		int j;
		int [] Q = new int[g.vexnum];//������пռ�
		int front,rear;//�����ͷ�Ͷ�β����
		//��ʼ��Ϊ��
		front = 0;rear = -1;
		System.out.print(g.vexs[i]+" ");//���ʶ���i
		g.flag[i] = true;//�÷��ʱ�־
		//�����㶥��i���
		rear++;Q[rear] = i;
		while(front<=rear){//���Ӳ���
			//����
			i = Q[front];
			//������������i���ڽӵ�
			for (j=0; j<g.vexnum; j++){//������������i���ڽӵ�
//				if(g.edges[i][j]==1 && g.edges[j][i]==1 && !g.flag[j]){//����ͼ ���ڽӵ㶥��jδ����
				if(g.edges[i][j]==1 && !g.flag[j]){//����ͼ  ���ڽӵ㶥��jδ����
					System.out.print(g.vexs[j]+" ");//���ʶ���j
					g.flag[j] = true;//�÷��ʱ�־				
					rear++;Q[rear] = j;//���ʹ��Ķ���j���
					break;
				}
			}
			front++;
		}
	}
	//������ȱ������ڽӾ���洢��ͼg
	public void BFSTraverseAL(MGraph g){
		int i;
		System.out.println("������ȱ����Ľ��Ϊ:");
		for(i=0; i<g.vexnum; i++){
			if(!flag[i]){
				BFSM(g,i);//������iδ����,�Ӷ���i��ʼBFS����
			}
		}
		System.out.println();
	}
	
	public void DFSTraverseAL(MGraph g){
		int i;
		System.out.println("������ȱ����Ľ��Ϊ:");
		for(i=0; i<g.vexnum; i++){
			if(!flag[i]){
				DFSM(g,i);//������iδ����,�Ӷ���i��ʼDFS����
			}
		}
		System.out.println();
	}
	public void test(MGraph g){
		System.out.println("�������Ϊ��"+g.vexnum);
		System.out.println("�ߵĸ���Ϊ��"+g.edgenum);
		System.out.println("����ڽӾ���:");
		for(int i=0; i<g.edges.length; i++){
			for (int j=0; j<g.edges[i].length; j++){
				System.out.print(g.edges[i][j]+" ");
			}
			System.out.println();
		}
	}
}


