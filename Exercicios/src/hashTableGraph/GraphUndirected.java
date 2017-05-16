package hashTableGraph;

import hashTable.HashTableEA;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by danilo on 29/04/17.
 */
public class GraphUndirected extends Graph {

    @Override
    public Edge getEdge(Vertex u, Vertex v) {
        Float edgeId = adjacencyMatrix.get(u.getId(), v.getId());
        Edge edge = null;

        // Verifica se a matriz de adjacencia possui uma Edge que liga os vertices.
        if (edgeId != null && edgeId != 0.0F) {
            Object objEdge = edges.findElem((int) (float) edgeId);

            if (objEdge != HashTableEA.NO_SUCH_KEY)
                edge = (Edge) objEdge;
        }

        return edge;
    }

    @Override
    public int inDegree(Vertex v) {
        return this.outDegree(v);
    }

    @Override
    public Iterator<Edge> outgoingEdges(Vertex v) {
        LinkedList<Edge> edges = new LinkedList<>();
        LinkedList keys = vertices.keys();

        for (Object key: keys) {
            Float idEdge = adjacencyMatrix.get(v.getId(), (Integer) key);

            if (idEdge != null && idEdge != 0.0F)
                edges.add((Edge) this.edges.findElem((int) (float)idEdge));
        }

        return edges.iterator();
    }

    @Override
    public Iterator<Edge> incomingEdges(Vertex v) {
        return outgoingEdges(v);
    }

    protected Edge saveEdge(Edge e) {
        edges.insertItem(e.getId(), e);
        adjacencyMatrix.add(e.getOriginVertex().getId(), e.getDestinationVertex().getId(), (float) e.getId());
        adjacencyMatrix.add(e.getDestinationVertex().getId(), e.getOriginVertex().getId(), (float) e.getId());
        return e;
    }
}
