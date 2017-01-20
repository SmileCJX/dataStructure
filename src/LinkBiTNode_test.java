
public class LinkBiTNode_test {
	public static void main(String[] args) {
		try{
			System.out.println("以先序遍历依次输入扩展的二叉树的前序序列:");
			LinkBiTree t = LinkBiTree.getInstance();
			t.bt = t.createBiTree(t.bt);
			travel(t);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void travel(LinkBiTree t){
		System.out.println("该二叉树的前序遍历为:");
		t.preOrder(t.bt);
		System.out.println();
		System.out.println("该二叉树的中序遍历为:");
		t.inOrder(t.bt);
		System.out.println();
		System.out.println("该二叉树的后序遍历为:");
		t.postOrder(t.bt);
	}
}
