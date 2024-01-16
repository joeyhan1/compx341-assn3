import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.graphstream.ui.view.Viewer;

/**
 * GraphClass Class
 * 
 * GraphClass Class holds methods which helps the Encost Class such as display(), getDevices() and etc.
 * It also uses the graph stream library.
 * 
 */
public class GraphClass {
    //Linkedlist of all the devices
    private LinkedList<Device> devices;
    //Graphstream library
    private Graph graph;
    
    //Constructor
    public GraphClass() {
        devices = new LinkedList<>();
        graph = new SingleGraph("DeviceGraph");
    }

    //Method which returns a list of devices from the devices list
    public List<Device> getDevices() {
        return devices;
    }

    //Method which add device to the devices list which has all the devices
    public void addDevice(Device device) {
        devices.add(device);
    }

    //Method which display the graph in a renderer based on the SDS 1 graph visualisation without formatting
    public void display() {
        //GS 1.3 renderer
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        //CSS path
        String cssFilePath = new Scanner(GraphClass.class.getResourceAsStream("stylesheet.css"), "UTF-8").useDelimiter("\\A").next();
        //Adding css file path for external stylesheet
        graph.addAttribute("ui.stylesheet", cssFilePath);
        //Looping through all the devices in the devices linked list
        for(int i = 0; i < devices.size(); i++) {
            if(devices.get(i).getProductCategory() == "Encost Wifi Routers") {
                Node nodeRouter = graph.addNode(devices.get(i).getDeviceID());
                nodeRouter.setAttribute("Device", devices.get(i));
                nodeRouter.setAttribute("ui.class", "router");
                //Changing Shapes depending on whether they can send or receive or both
                if(devices.get(i).canReceive() == true && devices.get(i).canSend() == true) {
                    nodeRouter.addAttribute("ui.style", "shape: circle;");
                } else if(devices.get(i).canReceive() == true) {
                    nodeRouter.addAttribute("ui.style", "shape: box;");
                } else if(devices.get(i).canSend() == true) {
                    nodeRouter.addAttribute("ui.style", "shape: cross;");
                }
            }
            if(devices.get(i).getProductCategory() == "Encost Hubs/Controllers") {
                Node nodeHub = graph.addNode(devices.get(i).getDeviceID());
                nodeHub.setAttribute("Device", devices.get(i));
                nodeHub.setAttribute("ui.class", "hub");
                if(devices.get(i).getRouterConnection() != null) {
                    addEdge(devices.get(i));
                }
                //Changing Shapes depending on whether they can send or receive or both
                if(devices.get(i).canReceive() == true && devices.get(i).canSend() == true) {
                    nodeHub.addAttribute("ui.style", "shape: circle;");
                } else if(devices.get(i).canReceive() == true) {
                    nodeHub.addAttribute("ui.style", "shape: box;");
                } else if(devices.get(i).canSend() == true) {
                    nodeHub.addAttribute("ui.style", "shape: cross;");
                }
            }
            if(devices.get(i).getProductCategory() == "Encost Smart Lighting") {
                Node nodeLighting = graph.addNode(devices.get(i).getDeviceID());
                nodeLighting.setAttribute("Device", devices.get(i));
                nodeLighting.setAttribute("ui.class", "lighting");
                if(devices.get(i).getRouterConnection() != null) {
                    addEdge(devices.get(i));
                }
                //Changing Shapes depending on whether they can send or receive or both
                if(devices.get(i).canReceive() == true && devices.get(i).canSend() == true) {
                    nodeLighting.addAttribute("ui.style", "shape: circle;");
                } else if(devices.get(i).canReceive() == true) {
                    nodeLighting.addAttribute("ui.style", "shape: box;");
                } else if(devices.get(i).canSend() == true) {
                    nodeLighting.addAttribute("ui.style", "shape: cross;");
                }
            }
            if(devices.get(i).getProductCategory() == "Encost Smart Appliances") {
                Node nodeAppliance = graph.addNode(devices.get(i).getDeviceID());
                nodeAppliance.setAttribute("Device", devices.get(i));
                nodeAppliance.setAttribute("ui.class", "appliance");
                if(devices.get(i).getRouterConnection() != null) {
                    addEdge(devices.get(i));
                }
                //Changing Shapes depending on whether they can send or receive or both
                if(devices.get(i).canReceive() == true && devices.get(i).canSend() == true) {
                    nodeAppliance.addAttribute("ui.style", "shape: circle;");
                } else if(devices.get(i).canReceive() == true) {
                    nodeAppliance.addAttribute("ui.style", "shape: box;");
                } else if(devices.get(i).canSend() == true) {
                    nodeAppliance.addAttribute("ui.style", "shape: cross;");
                }
            }
            if(devices.get(i).getProductCategory() == "Encost Smart Whiteware") {
                Node nodeWhiteware = graph.addNode(devices.get(i).getDeviceID());
                nodeWhiteware.setAttribute("Device", devices.get(i));
                nodeWhiteware.setAttribute("ui.class", "whiteware");
                if(devices.get(i).getRouterConnection() != null) {
                    addEdge(devices.get(i));
                }
                //Changing Shapes depending on whether they can send or receive or both
                if(devices.get(i).canReceive() == true && devices.get(i).canSend() == true) {
                    nodeWhiteware.addAttribute("ui.style", "shape: circle;");
                } else if(devices.get(i).canReceive() == true) {
                    nodeWhiteware.addAttribute("ui.style", "shape: box;");
                } else if(devices.get(i).canSend() == true) {
                    nodeWhiteware.addAttribute("ui.style", "shape: cross;");
                }
            }
        }
        //Image node which shows all the different colour and shapes meanings
        Node imageNode = graph.addNode("imgNode");
        imageNode.setAttribute("ui.class", "imgNode");

        //Display the graph
        Viewer viewer = graph.display();
        
        //Checking whether there is any devices in the linked list
        if(devices.size() == 0) {
            System.out.println("No DEVICES");
        }
    }

    //Method to add edges to devices
    private void addEdge(Device device) {
        Node sourceNode = graph.getNode(device.getRouterConnection().getDeviceID());
        Node targetNode = graph.getNode(device.getDeviceID());
        graph.addEdge(sourceNode + ":" + targetNode, sourceNode, targetNode);
    }

    //Method to get a list of devices from product category inputted
    public List<Device> getDevicesByCategory(String category) {
        List<Device> filteredDevices = new ArrayList<>();

        for (Device device : devices) {
            if (device.getProductCategory().equals(category)) {
                filteredDevices.add(device);
            }
        }

        return filteredDevices;
    }

    //Method to get a list of devices from product type inputted
    public List<Device> getDevicesByType(String type) {
        List<Device> filteredDevices = new ArrayList<>();

        for (Device device : devices) {
            if (device.getProductType().equals(type)) {
                filteredDevices.add(device);
            }
        }

        return filteredDevices;
    }

    //Method to get a list of devices from product name inputted
    public List<Device> getDevicesByProduct(String productName) {
        List<Device> filteredDevices = new ArrayList<>();

        for (Device device : devices) {
            if (device.getProductName().equals(productName)) {
                filteredDevices.add(device);
            }
        }

        return filteredDevices;
    }
}
