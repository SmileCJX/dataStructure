import java.util.ArrayList;
import java.util.LinkedList;

public class AMWGraph {

	private ArrayList vertexList;// �洢�������
	private int[][] edges;// �ڽӾ��������洢��
	private int edgenum;// �ߵ���Ŀ
	//����ߵ���Ŀ
	public AMWGraph(int n) {
		// ��ʼ������һά���飬�ͱߵ���Ŀ
		edges = new int[n][n];
		vertexList = new ArrayList(n);
		edgenum = 0;
	}

	// �õ����ĸ���
	public int getNumOfVertex() {
		return vertexList.size();
	}

	// �õ��ߵ���Ŀ
	public int getNumOfEdges() {
		return edgenum;
	}

	// ���ؽ��i������
	public Object getValueByIndex(int i) {
		return vertexList.get(i);
	}

	// ����v1,v2��Ȩֵ
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// ������
	// add(int index, E element)
	// ��ָ����Ԫ�ز�����б��е�ָ��λ�á�
	public void insertVertex(Object vertex) {
//		System.out.println(vertexList.size());
		vertexList.add(vertexList.size(), vertex);
	}

	// ������
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edgenum++;
	}

	// ɾ�����
	public void deleteEdge(int v1, int v2) {
		edges[v1][v2] = 0;
		edgenum--;
	}

	// �õ���һ���ڽӽ����±�
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// ����ǰһ���ڽӽ����±���ȡ����һ���ڽӽ��
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// ˽�к�����������ȱ���
	private void depthFirstSearch(boolean[] isVisited, int i) {
		// ���ȷ��ʸý�㣬�ڿ���̨��ӡ����
		System.out.print(getValueByIndex(i) + "  ");
		// �øý��Ϊ�ѷ���
		isVisited[i] = true;

		int w = getFirstNeighbor(i);//
		while (w != -1) {
			if (!isVisited[w]) {
				depthFirstSearch(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	// ���⹫��������������ȱ���������ͬ��˽�к������ڷ�������
	public void depthFirstSearch() {
		boolean[] isVisited = new boolean[getNumOfVertex()];// ��¼����Ƿ��Ѿ������ʵ�����
		for (int i = 0; i < getNumOfVertex(); i++) {
			isVisited[i] = false;// �����нڵ�����Ϊδ����
		}
		for (int i = 0; i < getNumOfVertex(); i++) {
			// ��Ϊ���ڷ���ͨͼ��˵��������ͨ��һ������һ�����Ա������н��ġ�
			if (!isVisited[i]) {
				depthFirstSearch(isVisited, i);
			}
		}
	}

	// ˽�к�����������ȱ���
	private void broadFirstSearch(boolean[] isVisited, int i) {
		int u, w;
		LinkedList queue = new LinkedList();

		// ���ʽ��i
		System.out.print(getValueByIndex(i) + "  ");
		isVisited[i] = true;
		// ��������
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u = ((Integer) queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					// ���ʸý��
					System.out.print(getValueByIndex(w) + "  ");
					// ����ѱ�����
					isVisited[w] = true;
					// �����
					queue.addLast(w);
				}
				// Ѱ����һ���ڽӽ��
				w = getNextNeighbor(u, w);
			}
		}
	}

	// ���⹫��������������ȱ���
	public void broadFirstSearch() {
		boolean[] isVisited = new boolean[getNumOfVertex()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < getNumOfVertex(); i++) {
			// ��Ϊ���ڷ���ͨͼ��˵��������ͨ��һ������һ�����Ա������н��ġ�
			if (!isVisited[i]) {
				broadFirstSearch(isVisited, i);
			}
		}
	}
}