import java.util.Scanner;


public class LinkBiTree {
	private LinkBiTree(){}//˽�й��췽������ߵ��಻���ٽ�������
	private static LinkBiTree tree = new LinkBiTree();
	public static LinkBiTree getInstance(){
		return tree;
	}
	public LinkBiTNode bt;
	
	public LinkBiTNode createBiTree(LinkBiTNode bt){
		//������������й����������洢�Ķ�����
		char ch;
		Scanner scanner = new Scanner(System.in);
		ch = scanner.next().charAt(0);
		if (ch=='0'){
			bt = null;//����0ʱ������Ӧ�ڵ��ÿ�
		}else{
			bt = new LinkBiTNode(ch, null,null);//���ɽڵ�ռ�
			bt.lchild = createBiTree(bt.lchild);//�����������������
			bt.rchild = createBiTree(bt.rchild);//�����������������
		}
		return bt;
	}
	
	public void preOrder(LinkBiTNode bt){
		if (bt == null){
			return;//�ݹ���õĽ�������
		}
		System.out.println(bt.data.toString());//���ʸ��ڵ�
		preOrder(bt.lchild);//����ݹ����rt��������
		preOrder(bt.rchild);//����ݹ����rt��������
	}
	
	public void inOrder(LinkBiTNode bt){
		if (bt == null){
			return;//�ݹ���õĽ�������
		}
		inOrder(bt.lchild);//����ݹ����rt��������
		System.out.println(bt.data.toString());//���ʸ��ڵ�
		inOrder(bt.rchild);//����ݹ����rt��������
	}
	
	public void postOrder(LinkBiTNode bt){
		if (bt == null){
			return;//�ݹ���õĽ�������
		}
		postOrder(bt.lchild);//����ݹ����rt��������
		postOrder(bt.rchild);//����ݹ����rt��������
		System.out.println(bt.data.toString());//���ʸ��ڵ�
	}
}
