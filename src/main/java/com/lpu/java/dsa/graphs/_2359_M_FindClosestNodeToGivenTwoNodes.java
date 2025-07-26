package com.lpu.java.dsa.graphs;

import java.util.*;

public class _2359_M_FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {

        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int nodeCount = edges.length;//because in the edge array, we have a mapping for the lone nodes as -1

        // Stage 1: pre-processing, data structuring
        // 1. Building Adjacency Map from 1D array
        Map<Integer, List<Integer>> adjacencyMap = buildAdjacencyList(edges);

        // 2.1 Building Distance Map for my source node1, destinationNode: distance
        HashMap<Integer, Integer> node1DistanceMap = bfsForBuildingDistanceMapEnhanced(node1, adjacencyMap);

        // 2.2 Building Distance Map for my source node2, destinationNode: distance
        HashMap<Integer, Integer> node2DistanceMap = bfsForBuildingDistanceMapEnhanced(node2, adjacencyMap);

        int res = -1;//Default result = -1
        int resDistance = Integer.MAX_VALUE;

        // Stage 2: post-processing of data
        for (int i = 0; i < nodeCount; i++) {
            if (node1DistanceMap.containsKey(i) && node2DistanceMap.containsKey(i)) {
                int maxDistance = Math.max(node1DistanceMap.get(i), node2DistanceMap.get(i));
                if (maxDistance < resDistance) {
                    resDistance = maxDistance;
                    res = i;
                }
            }
        }

        return res;
    }


    /**
     * Builds an adjacency list from a given edges array.
     * Each edge element is represented as two integers depicting a direction: i -> edges [i].
     *
     * @param edges A 1D array where each element represents a directed edge i -> edges [i].
     * @return A HashMap representing the adjacency list, where keys are source vertices
     * and values are lists of their direct neighbors (destinations).
     */
    static public Map<Integer, List<Integer>> buildAdjacencyList(int[] edges) {
        // Initialize the HashMap to store the adjacency list.
        // Using Map interface for the variable type is generally good practice.
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int destination = edges[i];

/*            The computeIfAbsent method is used here for conciseness and elegance.
             It checks if 'source' (edge[0]) is already a key in the adjacencyList.
             If 'source' is NOT present, it creates a new ArrayList (using the lambda 'k -> new ArrayList<>()')
             and associates it with 'source', then returns this new list.
             If 'source' IS present, it simply returns the existing List associated with 'source'.
             In either case, the returned List (either new or existing) is then used to add the 'destination' (edge[1]).*/
            adjacencyList.computeIfAbsent(i, keySource -> new ArrayList<>()).add(destination);// 'i' is source node
        }

        return adjacencyList;
    }


    private static HashMap<Integer, Integer> bfsForBuildingDistanceMapEnhanced(int srcNode,
                                                                               Map<Integer, List<Integer>> adjacencyMap) {
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(srcNode, 0));
        distanceMap.put(srcNode, 0);

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            int distance = node.distance;


            List<Integer> neighbors = adjacencyMap.get(node.nodeIndex);
            if (neighbors != null) {//for lone nodes, it can be null
                for (Integer neighbor : neighbors) {
                    if (!distanceMap.containsKey(neighbor) && neighbor != -1) {//no need to calculate for the node who has no Neighbors
                        queue.addLast(new Node(neighbor, distance + 1));
                        distanceMap.put(neighbor, distance + 1);
                    }

                }
            }


        }
        return distanceMap;

    }


    private static class Node {
        int nodeIndex;
        int distance;

        public Node(int nodeIndex, int distance) {
            this.nodeIndex = nodeIndex;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nodeIndex=" + nodeIndex +
                    ", distance=" + distance +
                    '}';
        }
    }


    class NiceSolution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int[] dist1 = bfs(edges, node1);
            int[] dist2 = bfs(edges, node2);
            int n = edges.length;
            int resIdx = -1;
            int resDist = -1;

            for (int i = 0; i < n; i++) {
                if (dist1[i] != -1 && dist2[i] != -1) {
                    int dist = Math.max(dist1[i], dist2[i]);
                    if (resDist == -1 || dist < resDist) {
                        resDist = dist;
                        resIdx = i;
                    }
                }
            }
            return resIdx;
        }

        public int[] bfs(int[] edges, int node) {
            int n = edges.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            res[node] = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            int steps = 0;

            while (!q.isEmpty()) {
                int curr = q.poll();
                steps++;

                if (edges[curr] == -1) continue;

                int next = edges[curr];
                if (res[next] == -1 || steps < res[next]) { // redundant really
                    q.add(next);
                    res[next] = steps;
                }
            }
            return res;
        }
    }
}
