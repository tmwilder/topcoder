package io.wilder.topcoder.srm703div2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GCDGraph {
	public static final String POSSIBLE = "Possible";
	public static final String IMPOSSIBLE = "Impossible";

	private Set<Integer> visited;

	String possible(int n, int k, int x, int y){
		visited = new HashSet<>();

		boolean possible = bfs(n, k, x, y);
		if (possible){
			return POSSIBLE;
		} else {
			return IMPOSSIBLE;
		}
	}

	private Integer gcd(int a, int b){
		if (a < b){
			int c = a;
			a = b;
			b = c;
		}

		if (b == 0) return a;
		return gcd(b, a%b);
	}

	private boolean bfs(int n, int k, int x, int y){
		LinkedList<Integer> fringe = new LinkedList<>();
		fringe.add(x);
		visited.add(x);

		while (!fringe.isEmpty()){
			Integer current = fringe.pop();
			if (current == y){
				return true;
			}

			for (Integer neighbor: getNeighbors(current, n, k)) {
				fringe.add(neighbor);
				visited.add(neighbor);
				if (visited.size() % 100 == 0){
					System.out.println("Visited: " + visited.size());
				}

				if (fringe.size() % 100 == 0){
					System.out.println("Fringe: " + fringe.size());
				}
			}
		}
		return false;
	}

	private List<Integer> getNeighbors(int x, int n, int k){
		List<Integer> neighbors = new ArrayList<>();
		for (int i = k+1; i <= n; i++){
			if (visited.contains(i) || i == x){
				continue;
			}
			int gcd = gcd(x, i);
			if (gcd > k){
				neighbors.add(i);
			}
		}
		return neighbors;
	}
}