import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Node> node_list;
    private List<Edge> edge_list;
    private Map<String, String> attributes;
    public Graph() {
        node_list  = new ArrayList<Node>();
        edge_list  = new ArrayList<Edge>();
        attributes = Collections.emptyMap();
    }

    public Graph(Map<String, String> attributes) {
        this();
        this.attributes = attributes;
    }

    public Collection<Node> getNodes() {
        return node_list;
    }

    public Collection<Edge> getEdges() {
        return edge_list;
    }

    public Graph node(String name) {
        node_list.add(new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        node_list.add(new Node(name, attributes));
        return this;
    }

    public Graph edge(String start, String end) {
        edge_list.add(new Edge(start, end));
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        edge_list.add(new Edge(start, end, attributes));
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
