import org.graphstream.graph.Graph;

public interface GraphVisualiser {
    void convertGraph(DeviceGraph deviceGraph);
    Graph getGraph();
}
