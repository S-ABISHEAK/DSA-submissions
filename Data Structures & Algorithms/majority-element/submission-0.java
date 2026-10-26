class Solution {
    public int majorityElement(int[] nums) {

        int ans = 0 , count = 0; // if count is 0 make the ans as current digit same then increase counter
        for(int num : nums){
            if(count == 0){
                ans = num;
            }
            //increase if same else reduce counter...
            count += (num == ans) ? 1 : -1;
        }
        return ans;
    }
}