import java.util.Scanner;


public class LinkBiTree {
	private LinkBiTree(){}//私有构造方法，外边的类不能再建立对象
	private static LinkBiTree tree = new LinkBiTree();
	public static LinkBiTree getInstance(){
		return tree;
	}
	public LinkBiTNode bt;
	
	public LinkBiTNode createBiTree(LinkBiTNode bt){
		//以先序遍历序列构造二叉链表存储的二叉树
		char ch;
		Scanner scanner = new Scanner(System.in);
		ch = scanner.next().charAt(0);
		if (ch=='0'){
			bt = null;//读入0时，将相应节点置空
		}else{
			bt = new LinkBiTNode(ch, null,null);//生成节点空间
			bt.lchild = createBiTree(bt.lchild);//构造二叉树的左子树
			bt.rchild = createBiTree(bt.rchild);//构造二叉树的右子树
		}
		return bt;
	}
	
	public void preOrder(LinkBiTNode bt){
		if (bt == null){
			return;//递归调用的结束条件
		}
		System.out.println(bt.data.toString());//访问根节点
		preOrder(bt.lchild);//先序递归遍历rt的左子树
		preOrder(bt.rchild);//先序递归遍历rt的右子树
	}
	
	public void inOrder(LinkBiTNode bt){
		if (bt == null){
			return;//递归调用的结束条件
		}
		inOrder(bt.lchild);//中序递归遍历rt的左子树
		System.out.println(bt.data.toString());//访问根节点
		inOrder(bt.rchild);//中序递归遍历rt的右子树
	}
	
	public void postOrder(LinkBiTNode bt){
		if (bt == null){
			return;//递归调用的结束条件
		}
		postOrder(bt.lchild);//后序递归遍历rt的左子树
		postOrder(bt.rchild);//后序递归遍历rt的右子树
		System.out.println(bt.data.toString());//访问根节点
	}
}
