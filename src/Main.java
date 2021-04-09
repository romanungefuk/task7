public class Main {

    public static void main(String[] args) {
        TimeManager timeManager = new TimeManager();
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        for (int i = 0; i < graph.getSize(); i++) {
            System.out.print(i+":");
            graph.displayVertex(i);
        }

        System.out.println("*****************");

        graph.addEdge(0,1);
        graph.addEdge(1,4);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(6,7);

        timeManager.setStartTime();
        graph.depthFirstTraversal(0);
        timeManager.setEndTime();
        System.out.println("Обход графа в глубину занял " + timeManager.getRunTime() + " нс");
        System.out.println("*****************");

        timeManager.setStartTime();
        graph.widthFirstTraversal(0);
        timeManager.setEndTime();
        System.out.println("Обход графа в ширину занял " + timeManager.getRunTime() + " нс");

    }
}
