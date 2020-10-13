package litany.util.graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch<V,E> {

    Graph<V,E> g;
    V source;
    LinkedList<V> marked;

    public DepthFirstSearch(){
        marked = new LinkedList<>();
    }

    public List<V> dfs(Graph<V,E> g, V source){
        this.g = g;
        this.source = source;
        marked.add(source);
        for(V v : g.neighbours(source)){
            if((!marked.contains(v)))
                dfs(g, v);
        }

        return marked;

    }

    public static void main(String[] args) {
        Graph<Integer, Integer> g = new AdjacencyMapGraph<>();

        g.addEdge(1,2, 1);
        g.addEdge(1,5, 1);
        g.addEdge(1,9, 1);
        g.addEdge(2,3, 1);
        g.addEdge(5,6, 1);
        g.addEdge(5,8, 1);
        g.addEdge(9,10, 1);
        g.addEdge(3,4, 1);
        g.addEdge(6,7, 1);

        DepthFirstSearch dfs = new DepthFirstSearch();

        List<Integer> result = dfs.dfs(g, 1);

        for (Integer  i : result){
            System.out.print(i + ", ");
        }
    }
}
