package io.wilder.topcoder.srm704div2;

import java.util.Arrays;

public class SwapAndArithmetic {
	static final String POSSIBLE = "Possible";
	static final String IMPOSSIBLE = "Impossible";

	String able(int[] x){
		int[] ascending = x.clone();
		Arrays.sort(ascending);
		int[] descending = ascending.clone();
		descending = reverse(descending);

		if (isArithmetic(ascending) || isArithmetic(descending)){
			return POSSIBLE;
		} else {
			return IMPOSSIBLE;
		}
	}

	private int[] reverse(int[] input){
		for (int i = 0; i < (input.length / 2); i++){
			int temp = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = temp;
		}
		return input;
	}

	private boolean isArithmetic(int[] input){
		if (input.length < 3){
			return true;
		} else {
			Integer delta = input[1] - input[0];
			for (int i = 1; i < input.length - 1; i++){
				Integer newDelta = input[i+1] - input[i];
				if (!newDelta.equals(delta)){
					// Delta is not consistent, return false.
					return false;
				}
			}
		}
		// If all pairs match, return true.
		return true;
	}
}
