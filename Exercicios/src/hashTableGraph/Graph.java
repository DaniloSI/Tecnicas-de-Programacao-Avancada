package hashTableGraph;

import hashTable.HashTable;
import hashTable.HashTableEA;
import hashTableMatriz.Matriz;

import java.util.Iterator;

/**
 * Created by danilo on 28/04/17.
 */
public abstract class Graph {

    protected int numVertices;
    protected int numEdges;
    protected HashTable vertices;
    protected HashTable edges;
    protected Matriz adjacencyMatrix;

    public Graph() {
        numVertices = 0;
        numEdges = 0;
        vertices = new HashTableEA();
        edges = new HashTableEA();
        adjacencyMatrix = new Matriz(0, 0);
    }

    /**
     * @return Quantidade de vertices.
     */
    public int numVertices() {
        return numVertices;
    }

    /**
     * @return Iterator para todos os vértices.
     */
    public Iterator<Vertex> vertices() {
        return vertices.elements().iterator();
    }

    /**
     * @return Quantidade de arestas.
     */
    public int numEdges() {
        return numEdges;
    }

    /**
     * @return Iterator para todas as arestas.
     */
    public Iterator<Edge> edges() {
        return edges.elements().iterator();
    }

    /**
     * @param u Vértice de origem.
     * @param v Vertice de destino.
     * @return Aresta que liga os vértices. Se não houver arestas, retorna null.
     */
    public abstract Edge getEdge(Vertex u, Vertex v);

    /**
     * Retorna um array contendo dois vértices associados à uma aresta. O primeiro
     * elemento do array é o vértice de origem. O segundo é o vértice de destino.
     *
     * @param e Aresta.
     * @return Array contendo os 2 vértices das extremidades da arestas.
     */
    public Vertex[] endVertices(Edge e) {
        Vertex[] vertices = new Vertex[2];

        vertices[0] = e.getOriginVertex();
        vertices[1] = e.getDestinationVertex();

        return vertices;
    }

    /**
     * @param v Vértice.
     * @param e Aresta incidente ao vértice.
     * @return O outro vértice relacionado.
     */
    public Vertex opposite(Vertex v, Edge e) {
        if (e.getOriginVertex().getId() == v.getId())
            return e.getDestinationVertex();
        else if (e.getDestinationVertex().getId() == v.getId())
            return e.getOriginVertex();
        else
            return null;
    }

    /**
     * @param v Vértice.
     * @return Quantidade de arestas saindo do vértice.
     */
    public abstract int outDegree(Vertex v);

    /**
     * @param v Vértice.
     * @return Quantidade de arestas chegando ao vértice. Para grafos não direcionados, a saída é a mesma de outDegree.
     */
    public abstract int inDegree(Vertex v);

    /**
     * @param v Vértice.
     * @return Iteração de todas as arestas saindo do vértice.
     */
    public abstract Iterator<Edge> outgoingEdges(Vertex v);

    /**
     * @param v Vértice.
     * @return Iteração de todas as arestas saindo do vértice.
     */
    public abstract Iterator<Edge> incomingEdges(Vertex v);

    /**
     * @param x Elemento a ser armazenado no vértice do grafo.
     * @return Vértice criado contendo o elemento.
     */
    public Vertex insertVertex(Object x) {
        Vertex newVertex = new Vertex();
        newVertex.setId(vertices.size());
        newVertex.setDado(x);

        vertices.insertItem(newVertex.getId(), newVertex);

        return newVertex;
    }

    /**
     * @param x Elemento a ser armazenado no vértice do grafo.
     * @param label Label do vertice.
     * @return Vértice criado contendo o elemento.
     */
    public Vertex insertVertex(Object x, String label) {
        Vertex newVertex = new Vertex();
        newVertex.setId(vertices.size());
        newVertex.setDado(x);
        newVertex.setLabel(label);

        vertices.insertItem(newVertex.getId(), newVertex);

        return newVertex;
    }

    /**
     * @param u Vértice um.
     * @param v Vértice dois.
     * @param x Elemento a ser armazenado na aresta.
     * @return Aresta criada com o elemento armazenado.
     */
    public abstract Edge insertEdge(Vertex u, Vertex v, Object x);

    /**
     * Remove do grafo o vértice e todas as suas arestas incidentes.
     * @param v Vértice a ser removido.
     */
    public void removeVertex(Vertex v) {

        int vertexTarget = 0;

        while (vertexTarget < vertices.size()) {
            Edge edgeRemove = getEdge(v, (Vertex) vertices.findElem(vertexTarget));

            if (edgeRemove != null)
                removeEdge(edgeRemove);
            else
                vertexTarget++;
        }

        // Remove da matriz de adjacencia.
        adjacencyMatrix.removeRowColumn(v.getId(), v.getId());

        // Desloca os vertices para um indice anterior.
        for (int vertexId = v.getId() + 1 ; vertexId < vertices.size() ; vertexId++) {
            Vertex vertex = (Vertex) vertices.findElem(vertexId);
            vertex.setId(vertexId - 1);
            vertices.insertItem(vertexId, vertex);
        }

        // Remove o vertice da "lista" de vertices.
        vertices.removeItem(vertices.size() - 1);
    }

    /**
     * Remove uma aresta 'e' do grafo.
     * @param e Aresta a ser removida.
     */
    public void removeEdge(Edge e) {
        int vId = e.getOriginVertex().getId();
        int uId = e.getDestinationVertex().getId();

        adjacencyMatrix.add(vId, uId, 0.0F);
        adjacencyMatrix.add(uId, vId, 0.0F);

        // Desloca as arestas para um indice anterior.
        for (int edgeId = e.getId() + 1 ; edgeId <= edges.size() ; edgeId++) {
            Edge edge = (Edge) edges.findElem(edgeId);
            edge.setId(edgeId - 1);

            edges.insertItem(edge.getId(), edge);
        }

        edges.removeItem(edges.size());
    }
}
