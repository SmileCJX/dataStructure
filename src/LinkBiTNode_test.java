
public class LinkBiTNode_test {
	public static void main(String[] args) {
		try{
			System.out.println("�������������������չ�Ķ�������ǰ������:");
			LinkBiTree t = LinkBiTree.getInstance();
			t.bt = t.createBiTree(t.bt);
			travel(t);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void travel(LinkBiTree t){
		System.out.println("�ö�������ǰ�����Ϊ:");
		t.preOrder(t.bt);
		System.out.println();
		System.out.println("�ö��������������Ϊ:");
		t.inOrder(t.bt);
		System.out.println();
		System.out.println("�ö������ĺ������Ϊ:");
		t.postOrder(t.bt);
	}
}
