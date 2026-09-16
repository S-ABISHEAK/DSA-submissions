class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // use an HASHMAP to store the frequencies as KEY and strings as values...

        Map<String , List<String>> mp = new HashMap<>();

        // iterate through the strings to get their frequencies in arrays

        for(String s : strs){

            int freq[] = new int[26]; // get the freq for every other string
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            // convert the freq array to an string and store it as the KEY...
            String freq_str_key = Arrays.toString(freq);
            mp.putIfAbsent(freq_str_key , new ArrayList<>()); // runs only if key is not there 
            mp.get(freq_str_key).add(s);
        }
        return new ArrayList<>(mp.values()); // brings out all the values that are in the form of list...
    }
}
