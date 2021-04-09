import java.util.*;

public class Graph {
    private final int GRAPH_SIZE = 32;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int size;

    public Graph() {
        vertexList = new Vertex[GRAPH_SIZE];
        adjacencyMatrix = new int[GRAPH_SIZE][GRAPH_SIZE];
        size = 0;
        for (int i = 0; i < GRAPH_SIZE; i++) {
            for (int j = 0; j < GRAPH_SIZE; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String name) {
        vertexList[size++] = new Vertex(name);
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyMatrix[vertex1][vertex2] = 1;
        adjacencyMatrix[vertex2][vertex1] = 1;
    }

    public void displayVertex(int vertexNumber) {
        System.out.println(vertexList[vertexNumber].getName());
    }

    public int getSize() {
        return size;
    }

    private int[] getAdjacentVertexList (int vertexNumber) {
        int[] vertexList = new int[GRAPH_SIZE];
        Arrays.fill(vertexList,0);
        int listIndex = 0;
        for (int i = 0; i < GRAPH_SIZE; i++) {
            if (adjacencyMatrix[vertexNumber][i] == 1) {
                vertexList[listIndex++] = i;
            }
        }
        return vertexList;
    }

    public void depthFirstTraversal (int startVertexIndex) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedList = new LinkedHashSet<>();
        stack.push(startVertexIndex);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visitedList.contains(vertex)) {
                visitedList.add(vertex);
                for (int v: getAdjacentVertexList(vertex)) {
                    stack.push(v);
                }
            }
        }
        for (int i :
                visitedList) {
            displayVertex(i);
        }
    }

    public void widthFirstTraversal (int startVertexIndex) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedList = new LinkedHashSet<>();
        queue.add(startVertexIndex);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (!visitedList.contains(vertex)) {
                visitedList.add(vertex);
                for (int v: getAdjacentVertexList(vertex)) {
                    queue.add(v);
                }
            }
        }
        for (int i :
                visitedList) {
            displayVertex(i);
        }
    }

}
