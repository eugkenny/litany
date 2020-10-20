package litany.util.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Kruskal<V, E extends Comparable<E>> {

    private class Edge implements Comparable<Edge> {
        V from;
        V to;
        E weight;

        Edge(V from, V to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        V from() {
            return from;
        }

        V to() {
            return to;
        }

        E weight() {
            return weight;
        }

        V opposite(V v) {
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

        public String toString() {
            return from + ", " + to + ", " + weight;
        }
    }

    LinkedList<V> marked;
    V source;

    public Graph<V, E> mst(Graph<V, E> graph) {
        Graph<V, E> result = new AdjacencyMapGraph<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (V v : graph) {
            for (V u : graph.neighbours(v)) {
                pq.add(new Edge(v, u, graph.getEdge(v, u)));
            }
        }

        for(V v : graph){
            result.addVertex(v);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            //System.out.println(e);

            marked = new LinkedList<>();
            source = e.from();

            if (!connected(result, e.from(), e.to()))
                result.addEdge(e.from(), e.to(), e.weight());
        }
        return result;
    }


        public boolean connected (Graph <V,E> g, V source, V target){

            marked.add(source);
            for (V v : g.neighbours(source)) {
                if ((!marked.contains(v)))
                    connected(g, v, target);
            }

            if(marked.contains(target))
                return true;

            return false;
        }

        public static void main (String[]args){
            Graph<Integer, Double> g = new AdjacencyMapGraph<>();

            g.addEdge(1, 2, 2.0);
            g.addEdge(1, 3, 4.0);
            g.addEdge(1, 4, 1.0);
            g.addEdge(2, 4, 3.0);
            g.addEdge(2, 5, 10.0);
            g.addEdge(3, 4, 2.0);
            g.addEdge(3, 6, 5.0);
            g.addEdge(4, 5, 7.0);
            g.addEdge(4, 6, 8.0);
            g.addEdge(4, 7, 4.0);
            g.addEdge(5, 7, 6.0);
            g.addEdge(6, 7, 1.0);


            Kruskal<Integer, Double> kruskal = new Kruskal<>();

            System.out.println(kruskal.mst(g));

        }
    }
