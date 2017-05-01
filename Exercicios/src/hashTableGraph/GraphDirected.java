package hashTableGraph;

import hashTable.HashTableChain;
import hashTable.HashTableEA;

import java.util.Iterator;

/**
 * Created by danilo on 29/04/17.
 */
public class GraphDirected extends Graph {

    @Override
    Edge getEdge(Vertex u, Vertex v) {
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
    int outDegree(Vertex v) {
        return 0;
    }

    @Override
    int inDegree(Vertex v) {
        return 0;
    }

    @Override
    Iterator<Edge> outgoingEdges(Vertex v) {
        return null;
    }

    @Override
    Iterator<Edge> incomingEdges(Vertex v) {
        return null;
    }

    @Override
    Edge insertEdge(Vertex u, Vertex v, Object x) {
        Edge newEdge = new Edge();
        newEdge.setId(edges.size() + 1);
        newEdge.setOriginVertex(u);
        newEdge.setDestinationVertex(v);
        newEdge.setDado(x);

        edges.insertItem(newEdge.getId(), newEdge);
        adjacencyMatrix.add(u.getId(), v.getId(), (float) newEdge.getId());
        adjacencyMatrix.add(v.getId(), u.getId(), (float) newEdge.getId());

        return newEdge;
    }
}
