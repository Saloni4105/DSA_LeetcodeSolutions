class Solution {
    public boolean isAnagram(String s, String t) {
        // if lengths are not equal, can't be anagram
        if(s.length() != t.length())
        {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        // count character of s
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        // subtract using character of t
        for(int i=0; i<t.length(); i++)
        {
            char ch = t.charAt(i);
            if(!map.containsKey(ch))
            {
                return false; //charcter not present  
            }
            map.put(ch, map.get(ch) -1);
            if(map.get(ch) == 0)
            {
                map.remove(ch);
            }
        }
        // if map is empty, they are anagrams
        return map.isEmpty();
    }
}