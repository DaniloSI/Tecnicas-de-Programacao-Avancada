package hashTableGraph;

import java.util.Iterator;

/**
 * Created by danilo on 29/04/17.
 */
public class GraphUndirected extends Graph {
    @Override
    public int outDegree(Vertex v) {
        return 0;
    }

    @Override
    public int inDegree(Vertex v) {
        return 0;
    }

    @Override
    public Iterator<Edge> outgoingEdges(Vertex v) {
        return null;
    }

    @Override
    public Iterator<Edge> incomingEdges(Vertex v) {
        return null;
    }

    @Override
    public Edge getEdge(Vertex u, Vertex v) {
        return null;
    }

    @Override
    public Edge insertEdge(Vertex u, Vertex v, Object x) {
        return null;
    }

    @Override
    public Edge insertEdge(Vertex u, Vertex v, Object x, String label) {
        return null;
    }
}
