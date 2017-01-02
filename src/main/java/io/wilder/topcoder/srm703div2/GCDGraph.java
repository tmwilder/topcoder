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

	private Map<Integer, Map<Integer, Integer>> factorCache;
	private Map<List<Integer>, Integer> gcdCache;
	private Set<Integer> visited;

	String possible(int n, int k, int x, int y){
		factorCache = new HashMap<>();
		gcdCache = new HashMap<>();
		visited = new HashSet<>();

		boolean possible = bfs(n, k, x, y);
		if (possible){
			return POSSIBLE;
		} else {
			return IMPOSSIBLE;
		}
	}

	private Integer gcd(int a, int b){
		List<Integer> items = new ArrayList<>();
		items.add(a);
		items.add(b);
		Collections.sort(items);
		if (gcdCache.containsKey(items)){
			return gcdCache.get(items);
		}

		Map<Integer, Integer> factorsA = primeFactors(a);
		Map<Integer, Integer> factorsB = primeFactors(b);

		int gcd = 1;
		for (Integer key: factorsA.keySet()){
			int count = Math.min(factorsA.get(key), factorsB.getOrDefault(key, 0));
			for (int i = 0; i < count; i++){
				gcd = gcd * key;
			}
		}
		return gcd;
	}

	private Map<Integer, Integer> primeFactors(int a){
		if (factorCache.containsKey(a)){
			return factorCache.get(a);
		}
		Map<Integer, Integer> factors = new HashMap<>();
		if (a < 4){
			return factors;
		}
		for (int i = 2; i*i <= a; i++){
			while (a % i == 0){
				if (!factors.containsKey(i)){
					factors.put(i, 1);
				} else {
					factors.put(i, factors.get(i) + 1);
				}
				a = a/i;
			}
		}
		if (a > 1){
			if (!factors.containsKey(a)){
				factors.put(a, 1);
			} else {
				factors.put(a, factors.get(a) + 1);
			}
		}
		factorCache.put(a, factors);
		return factors;
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
					System.out.println(visited.size());
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