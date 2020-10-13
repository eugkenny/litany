package litany.util.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AdjacencyMapGraph<V,E> implements Graph<V,E> {

    protected Map<V, Map<V,E>> adj;
    protected boolean directed;

    public AdjacencyMapGraph(){
        this(false);
    }

    public AdjacencyMapGraph(boolean directed){
        adj = new HashMap<>();
        this.directed = directed;
    }

    @Override
    public int order() {
        return adj.keySet().size();
    }

    @Override
    public int size() {
        int edges = 0;
        for(V v : adj.keySet()) {
            edges += degree(v);
        }
        if(!directed){
            edges /= 2;
        }
        return edges;
    }

    @Override
    public void addVertex(V v) {
        if(!hasVertex(v)){
            adj.put(v, new HashMap<>());
        }
    }

    @Override
    public void removeVertex(V v) {
        if(!hasVertex(v))
            return;
        for(V u : neighbours(v)){
            adj.get(u).remove(v);
        }
        adj.remove(v);
    }

    @Override
    public boolean hasVertex(V v) {
        return adj.containsKey(v);
    }

    public int degree(V v){
        return adj.get(v).size();
    }

    public Iterable<V> neighbours(V v){
        return adj.get(v).keySet();
    }

    @Override
    public void addEdge(V u, V v, E e) {
        if (adj.get(u) == null){
            addVertex(u);
        }
        if(adj.get(v) == null){
            addVertex(v);
        }

        adj.get(u).put(v, e);
        if (!directed) {
            adj.get(v).put(u, e);
        }
    }

    public boolean hasEdge(V u, V v){
        return adj.get(u).containsKey(v);
    }

    @Override
    public Iterator<V> iterator() {
        return adj.keySet().iterator();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices: {");
        for(V v: this){
            sb.append(v).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}\n");

        sb.append("Edges: {");
        for(V v : this){
            for(V u : adj.get(v).keySet()){
                sb.append("(").append(v).append(", ").append(u).append(", ").append(adj.get(v).get(u)).append(")").append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}\n");

        return sb.toString();
    }

    public static void main(String [] args){
        Graph<Integer, Integer> g = new AdjacencyMapGraph<>();
        g.addVertex(1);
        g.addVertex(3);
        g.addVertex(2);
        g.addEdge(1,2, 1);
        g.addEdge(1,3, 1);
        g.addEdge(2,4, 1);

        System.out.println(g);
        System.out.println("Adjacent: 2, 4 - "  + g.hasEdge(2,4));
        System.out.println("Adjacent: 3, 4 - "  + g.hasEdge(3,4));

        System.out.print("Neighbours: 2 - ");
        for (Integer i : g.neighbours(2)) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("Order: " + g.order());
        System.out.println("Size: " + g.size());

        System.out.println(g);

        g.removeVertex(1);

        System.out.println(g);

    }
}
