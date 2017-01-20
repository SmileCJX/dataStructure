import java.util.Scanner;

public class LinkBiTNode {
	public Object data;
	public LinkBiTNode lchild;
	public LinkBiTNode rchild;
	
	LinkBiTNode(Object elem,LinkBiTNode lchildval,LinkBiTNode rchildval){
		data = elem;
		lchild = lchildval;
		rchild = rchildval;
	}
	
	LinkBiTNode(LinkBiTNode lchildval,LinkBiTNode rchildval){
		lchild = lchildval;
		rchild = rchildval;
	}
}
