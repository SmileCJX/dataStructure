import java.util.Scanner;

public class MGraph_test {
	//num 为图的顶点个数,全局数组flag初始化
	
	public static void main(String[] args) {
		System.out.println("请输入点的个数和边的个数");
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
