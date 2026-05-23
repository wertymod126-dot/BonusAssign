# DIJKSTRA'S Algorithm for finding shortest path

Student: Adilbek Shangerey

Group:SE-2513

**The Edge Class**

This class acts as a blueprint for a single relationship (or connection) in the graph. In an unweighted graph, you only need to store the target integer. However, because this is a weighted graph, a dedicated class is required to bind all three essential characteristics of a connection together.


**The WeightedGraph Class**

This is the core manager class. It builds the graph network structure and implements the algorithm to find the shortest path.

The dijkstra(int start) Method Logic

This method is where the pathfinding mechanics execute. Here is exactly what happens when it is called:

  State Arrays Allocation: Two local primitive arrays are created:

  double[] dist: Keeps track of the current shortest known distance from the start vertex to every other vertex.

  boolean[] visited: Keeps track of vertices whose absolute minimum distances have been locked in and finalized.

  Initialization:

  Arrays.fill(dist, Double.MAX_VALUE) sets all initial paths to infinity because we do not know any routes yet.

  dist[start] = 0 sets the distance to the starting point to zero because you are already there.

The Main Loop: The loop runs V times (once for every vertex):

  It calls findMinDistanceVertex to get the closest unprocessed vertex u.

  If u == -1 or its distance is infinity, it means the remaining vertices are entirely disconnected from our starting point, so the loop terminates early (break).
It flags visited[u] = true, meaning we have officially found the absolute shortest way to reach u.

Edge Relaxation:
    The method pulls up the list of neighbors for u (adj[u]). For every outgoing edge leading to a neighbor v, it computes a potential new path cost: dist[u] + edge.weight.
    If this new cost is strictly less than the previously recorded distance in dist[v], relaxation occurs, and dist[v] is updated with the cheaper value.
