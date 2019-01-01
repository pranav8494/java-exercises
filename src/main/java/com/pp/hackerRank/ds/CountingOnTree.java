package com.pp.hackerRank.ds;

import java.io.*;
import java.util.*;

import com.google.common.collect.TreeMultimap;

/**
 * Source: 
 * </br>1. <a href="https://www.hackerrank.com/challenges/counting-on-a-tree/problem">Hacker Rank: Counting On a Tree</a>
 * @author ppandey
 *
 */
public class CountingOnTree {

    // Complete the solve function below.
    static int[] solve(int[] c, int[][] tree, int[][] queries) {
    	
    	TreeMultimap<Integer, Integer> treeAsMap = TreeMultimap.create();
    	for(int i=0; i<tree.length; i++){
    		treeAsMap.put(tree[i][0], tree[i][1]);
    		treeAsMap.put(tree[i][1], tree[i][0]);
    	}
    	
    	int[] result = new int[queries.length]; 
    	for(int i=0; i < queries.length; i++){
    		int counter = 0;
    		if(queries[i].length == 4){
    			List<Integer> path1 = findPath(queries[i][0], queries[i][1], 0, treeAsMap);
    			List<Integer> path2 = findPath(queries[i][2], queries[i][3], 0, treeAsMap);
    			for(Integer a : path1){
    				for(Integer b : path2){
    					if(a != b && c[a-1] == c[b-1]){
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
	private static ArrayList<Integer> findPath(int i, int j, int lastNode, TreeMultimap<Integer, Integer> treeAsMap) {
		ArrayList<Integer> path = new ArrayList<Integer>();

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

