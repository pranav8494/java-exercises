package com.pp.hackerRank.ds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.TreeMultimap;

public class CountingOnTreeV2 {
	
	public static class Node{
		protected int value;
		protected int nodeId;
		protected List<Node> children = new ArrayList<CountingOnTreeV2.Node>();
		protected Node parent = null;
		
		public Node(int value, int nodeId){
			this.value = value;
			this.nodeId = nodeId;
		}
		
		public Node(int value, int nodeId, Node parent){
		
			this.value = value;
			this.parent = parent;
			this.nodeId = nodeId;
		}
		
		public void addChild(Node node){
			this.children.add(node);
		}
	}

    // Complete the solve function below.
    private static int[] solve(int[] c, int[][] tree, int[][] queries) {
    	
    	TreeMultimap<Integer, Integer> treeAsMap = TreeMultimap.create();
    	Node[] treeMap = new Node[c.length];
    	Node root = null;
    	
    	for(int i = 0; i < c.length; i++){
    		
    		Node tempNode = new Node(c[i], i+1);
    		treeMap[i] = tempNode;
    		if(root == null){
    			root  = tempNode;
    		}
    	}
    	
    	for(int i=0; i<tree.length; i++){
    		Node parentNode = treeMap[tree[i][0]];
    		Node childNode = treeMap[tree[i][1]];
    		
    		parentNode.children.add(childNode);
    		childNode.parent = parentNode;
    	}
    	
    	int[] result = new int[queries.length]; 
    	for(int i=0; i < queries.length; i++){
    		int counter = 0;
    		if(queries[i].length == 4){
    			List<Node> path1 = findPath(treeMap[queries[i][0]], treeMap[queries[i][1]], null, treeMap);
    			List<Node> path2 = findPath(treeMap[queries[i][2]], treeMap[queries[i][3]], null, treeMap);
    			for(Node a : path1){
    				for(Node b : path2){
    					if(a.nodeId != b.nodeId && a.value == b.value){
    						counter++;
    					}
    				}
    			}
    		}
    		result[i] = counter;
    	}  	

    	return result;
    }

    // complete findPath method and it should be solved.
	private static ArrayList<Node> findPath(Node i, Node j, Node lastNode, Node[] treeMap) {
		ArrayList<Node> path = new ArrayList<Node>();

		/*
		Collection<Integer> values = treeAsMap.get(i);
		if (values.contains(j)) {
			path.add(j);
			path.add(i);
		} else {
			for (int temp : values) {
				if (temp != lastNode) {
					ArrayList<Integer> pathFromHere = findPath(temp, j, i, treeAsMap);
					if (pathFromHere.size() > 0) {
						path.addAll(pathFromHere);
						path.add(i);
						return path;
					}
				}
			}
		}
		*/
		return path;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int cItr = 0; cItr < n; cItr++) {
            int cItem = Integer.parseInt(cItems[cItr]);
            c[cItr] = cItem;
        }

        int[][] tree = new int[n-1][2];

        for (int treeRowItr = 0; treeRowItr < n-1; treeRowItr++) {
            String[] treeRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int treeColumnItr = 0; treeColumnItr < 2; treeColumnItr++) {
                int treeItem = Integer.parseInt(treeRowItems[treeColumnItr]);
                tree[treeRowItr][treeColumnItr] = treeItem;
            }
        }

        int[][] queries = new int[q][4];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int queriesColumnItr = 0; queriesColumnItr < 4; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr]);
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = solve(c, tree, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
            	System.out.println("\n");
            }
        }

        scanner.close();
    }

}
