package hashTableGraph;

/**
 * Created by danilo on 28/04/17.
 */
public class Edge {
    private int id;
    private Object dado;
    private String label;
    private Vertex originVertex;
    private Vertex destinationVertex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex getOriginVertex() {
        return originVertex;
    }

    public void setOriginVertex(Vertex originVertex) {
        this.originVertex = originVertex;
    }

    public Vertex getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(Vertex destinationVertex) {
        this.destinationVertex = destinationVertex;
    }

    @Override
    public String toString() {
        return label;
    }
}
