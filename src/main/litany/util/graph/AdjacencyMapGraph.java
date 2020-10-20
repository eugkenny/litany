package litany.util.graph;

import java.util.*;

public class AdjacencyMapGraph<V,E> implements Graph<V,E> {

    protected Map<V, Map<V,E>> out;
    protected Map<V, Map<V,E>> in;

    protected boolean directed;

    public AdjacencyMapGraph(){
        this(false);
    }

    public AdjacencyMapGraph(boolean directed){
        out = new HashMap<>();
        in = new HashMap<>();
        this.directed = directed;
    }

    @Override
    public int order() {
        return out.keySet().size();
    }

    @Override
    public int size() {
        int edges = 0;
        for(V v : out.keySet()) {
            edges += degree(v);
        }
        return edges;
    }

    @Override
    public void addVertex(V v) {
        if(!hasVertex(v)){
            out.put(v, new HashMap<>());
            in.put(v, new HashMap<>());
        }
    }

    @Override
    public void removeVertex(V v) {
        if(!hasVertex(v))
            return;
        for(V u : neighbours(v)){
            out.get(u).remove(v);
            in.get(u).remove(v);
        }
        out.remove(v);
        in.remove(v);
    }

    @Override
    public boolean hasVertex(V v) {
        return out.containsKey(v);
    }

    @Override
    public int degree(V v){
        return out.get(v).size();
    }

    public Iterable<V> neighbours(V v){
        if(directed)
            return out.get(v).keySet();
        else{
            Set<V> neighbours = new HashSet<>(out.get(v).keySet());
            neighbours.addAll(in.get(v).keySet());
            return neighbours;
        }
    }

    @Override
    public void addEdge(V u, V v, E e) {
        if (out.get(u) == null){
            addVertex(u);
        }
        if(out.get(v) == null){
            addVertex(v);
        }

        out.get(u).put(v, e);
        in.get(v).put(u, e);
    }

    public boolean hasEdge(V u, V v){
        return out.get(u).containsKey(v) || in.get(u).containsKey(v);
    }

    public E getEdge(V u, V v){
        if (directed)
            return out.get(u).get(v);
        else{
            if(out.get(u).get(v) != null)
                return out.get(u).get(v);
            else
                return in.get(u).get(v);
        }
    }

    @Override
    public Iterator<V> iterator() {
        return out.keySet().iterator();
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
            for(V u : out.get(v).keySet()) {
                sb.append("(").append(v);
                if (directed)
                    sb.append(" -> ");
                else
                    sb.append(" - ");

                sb.append(u).append(", ").append(out.get(v).get(u)).append(")").append(", ");
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
        System.out.println("Adjacent: 4, 2 - "  + g.hasEdge(4,2));
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
