package litany.util.graph;

public interface Graph<V,E> extends Iterable<V>{

    /**
     * The number of vertices in the graph
     *
     * @return the number of vertices in the graph
     */
    int order();

    /**
     * The number of edges in the graph
     *
     * @return the number of edges in the graph
     */
    int size();

    /**
     * Adds a vertex to the graph
     *
     * @param v the vertex to add to the graph
     */
    void addVertex(V  v);

    /**
     * Removes a vertex and all of it's incident edges
     * @param v the vertex to remove from the graph
     */
    void removeVertex(V v);

    /**
     * Returns whether the specified vertex is present on the graph
     * @return {@code true} if the specified vertex is on the graph, {@code false} otherwise
     */
    boolean hasVertex(V v);

    void addEdge(V u, V v, E e);

    boolean hasEdge(V u, V v);

    E getEdge(V u, V v);

    int degree(V v);

    Iterable<V> neighbours(V v);
}
