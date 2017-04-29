package hashTableGraph;

import hashTable.HashTable;
import hashTable.HashTableEA;
import hashTableMatriz.Matriz;

import java.util.Iterator;

/**
 * Created by danilo on 28/04/17.
 */
public abstract class Graph {

    private int numVertices;
    private int numEdges;
    private HashTable vertices;
    private HashTable edges;
    private Matriz adjacencyMatrix;
    private int newIdVertex;
    private int newIdEdge;

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
    int numVertices() {
        return numVertices;
    }

    /**
     * @return Iterator para todos os vértices.
     */
    Iterator<Vertex> vertices() {
        return vertices.elements().iterator();
    }

    /**
     * @return Quantidade de arestas.
     */
    int numEdges() {
        return numEdges;
    }

    /**
     * @return Iterator para todas as arestas.
     */
    Iterator<Edge> edges() {
        return edges.elements().iterator();
    }

    /**
     * @param u Vértice de origem.
     * @param v Vertice de destino.
     * @return Aresta que liga os vértices. Se não houver arestas, retorna null.
     */
    abstract Edge getEdge(Vertex u, Vertex v);

    /**
     * Retorna um array contendo dois vértices associados à uma aresta. O primeiro
     * elemento do array é o vértice de origem. O segundo é o vértice de destino.
     *
     * @param e Aresta.
     * @return Array contendo os 2 vértices das extremidades da arestas.
     */
    Vertex[] endVertices(Edge e) {
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
    Vertex opposite(Vertex v, Edge e) {
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
    abstract int outDegree(Vertex v);

    /**
     * @param v Vértice.
     * @return Quantidade de arestas chegando ao vértice. Para grafos não direcionados, a saída é a mesma de outDegree.
     */
    abstract int inDegree(Vertex v);

    /**
     * @param v Vértice.
     * @return Iteração de todas as arestas saindo do vértice.
     */
    abstract Iterator<Edge> outgoingEdges(Vertex v);

    /**
     * @param v Vértice.
     * @return Iteração de todas as arestas saindo do vértice.
     */
    abstract Iterator<Edge> incomingEdges(Vertex v);

    /**
     * @param x Elemento a ser armazenado no vértice do grafo.
     * @return Vértice criado contendo o elemento.
     */
    Vertex insertVertex(Object x) {
        Vertex newVertex = new Vertex();
        newVertex.setId(getNewIdVertex());
        newVertex.setDado(x);

        vertices.insertItem(newVertex.getId(), newVertex);

        return newVertex;
    }

    /**
     * @param u Vértice um.
     * @param v Vértice dois.
     * @param x Elemento a ser armazenado na aresta.
     * @return Aresta criada com o elemento armazenado.
     */
    Edge insertEdge(Vertex u, Vertex v, Object x) {
        Edge newEdge = new Edge();
        newEdge.setId(getNewIdEdge());
        newEdge.setOriginVertex(u);
        newEdge.setDestinationVertex(v);
        newEdge.setDado(x);

        edges.insertItem(newEdge.getId(), newEdge);

        return newEdge;
    }

    // TODO: Implementar os métodos abaixo.

    /**
     * Remove do grafo o vértice e todas as suas arestas incidentes.
     * @param v Vértice a ser removido.
     */
    abstract void removeVertex(Vertex v);

    /**
     * Remove uma aresta 'e' do grafo.
     * @param e Aresta a ser removida.
     */
    abstract void removeEdge(Edge e);

    private int getNewIdVertex() {
        int newId = this.newIdVertex;

        this.newIdVertex++;

        return newId;
    }

    private int getNewIdEdge() {
        int newId = this.newIdEdge;

        this.newIdEdge++;

        return newId;
    }

}
