package org.example.sort;

import java.util.*;

public class Graph {
    private Map<String, Map<String, Integer>> directions;

    public Graph() {
        directions = new HashMap<>();
    }

    public void addDirection(String source, String destination, int weight) {
        directions.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
    }

    public List<String> findCheapestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            Map<String, Integer> neighbors = directions.getOrDefault(current, Collections.emptyMap());
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String next = neighbor.getKey();
                int weight = neighbor.getValue();
                int distance = distances.getOrDefault(current, Integer.MAX_VALUE) + weight;

                if (distance < distances.getOrDefault(next, Integer.MAX_VALUE)) {
                    distances.put(next, distance);
                    previous.put(next, current);
                    queue.add(next);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path;
    }
}
