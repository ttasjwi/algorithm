import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i=0; i< strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String anagram = String.valueOf(charArr);

            if (!anagrams.containsKey(anagram)) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagrams.put(anagram, newList);
            } else {
                anagrams.get(anagram).add(strs[i]);
            }
        }
        return new ArrayList<>(anagrams.values());
    }

}
