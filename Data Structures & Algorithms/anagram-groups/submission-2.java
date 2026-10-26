class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String , List<String>> mp = new HashMap<>();

        for(String s : strs){

            int freq[] = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            //change the freq to an string for the key of the map

            String freq_str = Arrays.toString(freq);
            mp.putIfAbsent(freq_str , new ArrayList<>());
            mp.get(freq_str).add(s);
            
        }
        return new ArrayList<>(mp.values());
    }
}
