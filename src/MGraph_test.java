import java.util.Scanner;

public class MGraph_test {
	//num Ϊͼ�Ķ������,ȫ������flag��ʼ��
	
	public static void main(String[] args) {
		System.out.println("�������ĸ����ͱߵĸ���");
		Scanner scanner = new Scanner(System.in);
		int i,j;
		i = scanner.nextInt();
		j = scanner.nextInt();
		MGraph g = new MGraph(i,j);
		g = g.create_MGraph(g);
//		g.test(g);
		g.InitFlag();
		g.BFSTraverseAL(g);
		g.InitFlag();
		g.DFSTraverseAL(g);
	}	
}
