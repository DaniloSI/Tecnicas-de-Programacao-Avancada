package hashTableGraph;

import hashTable.HashTableEA;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by danilo on 29/04/17.
 */
public class GraphDirected extends Graph {

    @Override
    public Edge getEdge(Vertex u, Vertex v) {
        Float edgeId = adjacencyMatrix.get(u.getId(), v.getId());

        if (edgeId == null || edgeId == 0.0F) {
            edgeId = adjacencyMatrix.get(v.getId(), u.getId());
        }

        if (edgeId != null && edgeId != 0.0F) {
            Object objEdge = edges.findElem((int) (float) edgeId);
            return (objEdge != HashTableEA.NO_SUCH_KEY) ? (Edge) objEdge : null;
        }

        else
            return null;
    }

    @Override
    public int inDegree(Vertex v) {
        int inDegree = 0;
        LinkedList keys = vertices.keys();

        for (Object key: keys) {
            if (adjacencyMatrix.get((Integer) key, v.getId()) != 0)
                inDegree++;
        }

        return inDegree;
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
        LinkedList<Edge> edges = new LinkedList<>();
        LinkedList keys = vertices.keys();

        for (Object key: keys) {
            Float idEdge = adjacencyMatrix.get((Integer) key, v.getId());

            if (idEdge != null && idEdge != 0.0F)
                edges.add((Edge) this.edges.findElem((int) (float)idEdge));
        }

        return edges.iterator();
    }

    @Override
    protected Edge saveEdge(Edge e) {
        edges.insertItem(e.getId(), e);
        adjacencyMatrix.add(e.getOriginVertex().getId(), e.getDestinationVertex().getId(), (float) e.getId());
        return e;
    }
}
