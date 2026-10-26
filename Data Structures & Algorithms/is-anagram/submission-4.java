class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int n = s.length();
        int check[] = new int[26];

        for(int i = 0 ; i < n ; i++){

            check[s.charAt(i) - 'a']++;
            check[t.charAt(i) - 'a']--;
        }

        for(int x : check){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
}
