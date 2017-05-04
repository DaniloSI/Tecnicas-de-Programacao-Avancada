package hashTableGraph;

import java.util.Iterator;

/**
 * Created by danilo on 30/04/17.
 */
public class GraphMain {

    public static void main(String[] args) {
        Graph grafo = new GraphDirected();
        Vertex a = grafo.insertVertex(1, "a");
        Vertex b = grafo.insertVertex(2, "b");
        Vertex c = grafo.insertVertex(3, "c");

        grafo.insertEdge(a, b, "Aresta a-b");
        grafo.insertEdge(b, c, "Aresta b-c");
        grafo.insertEdge(a, c, "Aresta a-c");

        Iterator edgesIterator = grafo.edges();

        while (edgesIterator.hasNext()) {
            Edge edge = (Edge) edgesIterator.next();
            Vertex[] vertices = grafo.endVertices(edge);

            System.out.println("Vertice tail: " + vertices[0]);
            System.out.println("Vertice head: " + vertices[1]);
        }
    }

}
