package org.example;

import org.example.sort.BinarySearch;
import org.example.sort.Graph;
import org.example.sort.SimpleTree;

import java.util.List;

import static org.example.sort.BinarySearch.search;
import static org.example.sort.FastSort.quickSort;
import static org.example.sort.MergeSort.mergeSort;

public class Main {
    public static void main(String[] args) {

        int[] arrayForSearch = {2, 3, 3, 6, 8, 8, 12, 17, 23};
        int key = 23;
        int index = search(arrayForSearch, key);

        if (index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element " + key +
                    " found at index " + index);

        int[] num = {12, 7, 4, 5, 3, 2, 1, 10};
        SimpleTree tree = new SimpleTree();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);

        System.out.print("Depth First Traversal: ");
        tree.traverseDepthFirst();

        System.out.println();

        System.out.print("Breadth First Traversal: ");
        tree.traverseBreadthFirst();
        System.out.println("Merge sort sorted:");

        mergeSort(num, 0, num.length - 1);
        for (int i : num){
            System.out.println(i + " ");
        }

        System.out.println("Quick sort sorted:");

        quickSort(num, 0, 7);

        for (int i : num){
            System.out.println(i + " ");
        }



        Graph graph = new Graph();
        graph.addDirection("A", "B", 5);
        graph.addDirection("A", "C", 3);
        graph.addDirection("B", "D", 2);
        graph.addDirection("B", "E", 4);
        graph.addDirection("C", "E", 1);
        graph.addDirection("C", "F", 6);
        graph.addDirection("D", "G", 8);
        graph.addDirection("E", "G", 3);
        graph.addDirection("E", "H", 7);
        graph.addDirection("F", "H", 2);
        graph.addDirection("G", "H", 1);

        List<String> cheapestPath = graph.findCheapestPath("A", "H");
        System.out.println("Cheapest Path: " + String.join(" - ", cheapestPath));
    }


}