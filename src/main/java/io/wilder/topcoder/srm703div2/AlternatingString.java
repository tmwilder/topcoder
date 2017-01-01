package io.wilder.topcoder.srm703div2;

public class AlternatingString {
	public int maxLength(String s){
		int maximum = 0;
		for (int i = 0; i < s.length(); i++){
			maximum = Math.max(maximum, getAlternatingLength(s, i));
		}
		return maximum;
	}

	private int getAlternatingLength(String s, int index){
		int length = 1;
		while (index + 1 < s.length()){
			if (s.charAt(index) != s.charAt(index + 1)){
				length++;
				index++;
			} else {
				break;
			}
		}
		return length;
	}
}