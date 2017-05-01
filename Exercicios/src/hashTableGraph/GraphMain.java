package hashTableGraph;

/**
 * Created by danilo on 30/04/17.
 */
public class GraphMain {

    public static void main(String[] args) {
        Graph grafo = new GraphDirected();
        Vertex a = grafo.insertVertex("a");
        Vertex b = grafo.insertVertex("b");
        Vertex c = grafo.insertVertex("c");

        Edge ab = grafo.insertEdge(a, b, "Aresta a-b");
        Edge bc = grafo.insertEdge(b, c, "Aresta b-c");
        Edge ac = grafo.insertEdge(a, c, "Aresta a-c");

        System.out.println(grafo.getEdge(a, c).getDado());
        System.out.println(grafo.opposite(a, ac).getDado());

        grafo.removeVertex(c);

        System.out.println(grafo.opposite(a, ac).getDado());
    }

}
