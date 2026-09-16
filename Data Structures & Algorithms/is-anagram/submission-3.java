class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){ // Without this we will hit string index out of bound error
            return false;
        }

        int n = s.length();
        int freq[] = new int[26];

        for(int i = 0 ; i < n ; i++){

            // add chars from the first string , remove chars fom the second string

            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--; 
        }

        for(int x : freq){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
}
