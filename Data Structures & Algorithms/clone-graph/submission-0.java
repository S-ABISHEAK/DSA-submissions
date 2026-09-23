/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        //MAPS the real : copy node to manage the visited nature 
        Map<Node , Node> cpy_mp = new HashMap<>();
        return dfs(node , cpy_mp);
    }

    public Node dfs(Node node , Map<Node , Node> mp){

        if(node == null){
            return null;
        }

        // If the node already present within the map return the map value (key : real , value : copy)
        if(mp.containsKey(node)){
            return mp.get(node);
        }

        // Create a new copy node is not present in the map
        Node cpy = new Node(node.val);
        mp.put(node , cpy);
        
        // To get the neighbours just get the neighbours of REAL node and apply dfs on them
        for(Node neigh : node.neighbors){
            cpy.neighbors.add(dfs(neigh , mp));
        }

        return cpy;
    }
}