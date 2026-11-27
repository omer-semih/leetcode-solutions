// LeetCode 785: Is Graph Bipartite?
// https://leetcode.com/problems/is-graph-bipartite/description/

class Solution {
    public boolean isBipartite(int[][] graph) {
        // -1 means the node has no color yet
        int[] color = new int [graph.length];
        
        for(int i=0;i<color.length;i++) color[i] = -1;

        // The graph can be disconnected, so try starting from every node
        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                // BFS from this node, coloring each neighbor the opposite color
                Queue<Integer> queue = new ArrayDeque<>(List.of(i));

                while(!queue.isEmpty()){
                    int s = queue.poll();
                    
                    for(int j=0;j<graph[s].length; j++) {
                        int neighbor = graph[s][j];
                        if(color[neighbor] == -1) {
                            // 1-color flips 0 into 1 and 1 into 0
                            color[neighbor] = 1-color[s];
                            queue.offer(neighbor);
                        }
                        // Two ends of an edge share a color, so the graph is not bipartite
                        else if(color[s] == color[neighbor]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}