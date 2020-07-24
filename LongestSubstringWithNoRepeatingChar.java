/*
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 * 
 * Input: String="aaabcdfcbbb"
 * Output: 3
 */

import java.util.*;

public class LongestSubstringWithNoRepeatingChar {

	public static int findMaxSubstring(String str) {
		
		int maxLength = 0, windowStart = 0;
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			char rightChar = str.charAt(windowEnd);
			hm.put(rightChar, hm.getOrDefault(rightChar, 0)+1);
			
			while(hm.get(rightChar) > 1) {
				
				char leftChar = str.charAt(windowStart);
				
				hm.put(leftChar, hm.get(leftChar)-1);
				
				if(hm.get(leftChar) == 0) {
					
					hm.remove(leftChar);
				}
				
				windowStart++;
				
			}
			
			maxLength = Math.max(maxLength, windowEnd-windowStart+1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="subarray";
		
		System.out.println(findMaxSubstring(str));
	}

}
