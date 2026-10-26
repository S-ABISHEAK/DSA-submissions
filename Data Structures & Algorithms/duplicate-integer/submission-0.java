class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for(int num : nums){
            if(present.contains(num)){
                return true;
            }
            present.add(num);
        }
        return false;
    }
}