package io.wilder.topcoder.srm703div2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GCDGraph {
	public static final String POSSIBLE = "Possible";
	public static final String IMPOSSIBLE = "Impossible";

	String possible(int n, int k, int x, int y){

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
		LinkedList<Integer> currentFringe = new LinkedList<>();
		HashSet<Integer> currentVisited = new HashSet<>();
		LinkedList<Integer> otherFringe = new LinkedList<>();
		HashSet<Integer> otherVisited = new HashSet<>();

		currentFringe.add(x);
		otherFringe.add(y);
		currentVisited.add(x);
		otherVisited.add(y);

		LinkedList<Integer> tempFringe;
		HashSet<Integer> tempVisited;

		if (x == y){
			return true;
		}

		while (!currentFringe.isEmpty() && !otherFringe.isEmpty()){
			if (currentFringe.size() > otherFringe.size()){
				// Set current to the smaller fringe to improve average runtime by balancing searches and dying early
				// on small paths.
				tempFringe = currentFringe;
				tempVisited = currentVisited;
				currentFringe = otherFringe;
				currentVisited = otherVisited;
				otherFringe = tempFringe;
				otherVisited = tempVisited;
			}

			Integer current = currentFringe.pop();

			for (Integer neighbor: getNeighbors(current, n, k, currentVisited)) {
				if (otherVisited.contains(neighbor)){
					return true;
				}
				currentFringe.add(neighbor);
				currentVisited.add(neighbor);
			}
		}
		return false;
	}

	private List<Integer> getNeighbors(int x, int n, int k, HashSet<Integer> visited){
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