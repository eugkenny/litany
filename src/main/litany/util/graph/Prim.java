package litany.util.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim<V,E extends Comparable<E>> {

    private class Edge implements Comparable<Edge>{
        V from;
        V to;
        E weight;

        Edge(V from, V to, E weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        V from(){
            return from;
        }

        V to(){
            return to;
        }

        E weight(){
            return weight;
        }

        V opposite(V v){
            if (v.equals(from))
                return to;
            if (v.equals(to))
                return from;
            else throw new RuntimeException("Illegal endpoint");
        }

        @Override
        public int compareTo(Edge other) {
            return weight.compareTo(other.weight);
        }

        public String toString(){
            return from + ", " + to + ", " + weight;
        }
    }

    public Graph<V, E> mst(Graph<V, E> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<V> marked = new LinkedList<>();
        Graph<V,E> result = new AdjacencyMapGraph<>();

        V start = graph.iterator().next();
        marked.add(start);
        result.addVertex(start);

        for(V v : graph.neighbours(start)){
            pq.add(new Edge(start, v, graph.getEdge(start, v)));
        }

        while(!pq.isEmpty()){
            Edge e = pq.remove();
            if(!marked.contains(e.to())) {
                marked.add(e.to());
                result.addEdge(e.from(), e.to(), (e.weight()));

                //System.out.println(e);
                for(V v : graph.neighbours(e.to())){
                    pq.add(new Edge(e.to(), v, graph.getEdge(e.to, v)));
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {
        Graph<Integer, Double> g = new AdjacencyMapGraph<>(true);

        g.addEdge(1,2, 2.0);
        g.addEdge(1,3, 4.0);
        g.addEdge(1,4, 1.0);
        g.addEdge(2,4, 3.0);
        g.addEdge(2,5, 10.0);
        g.addEdge(3,4, 2.0);
        g.addEdge(3,6, 5.0);
        g.addEdge(4,5, 7.0);
        g.addEdge(4,6, 8.0);
        g.addEdge(4,7, 4.0);
        g.addEdge(5,7, 6.0);
        g.addEdge(6,7, 1.0);


        Prim<Integer, Double> prim = new Prim<>();

        System.out.println(prim.mst(g));
    }
}
