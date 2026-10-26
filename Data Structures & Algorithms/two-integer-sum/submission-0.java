class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer , Integer> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){

            int complement = target - nums[i];

            //check is the difference is logged in the map

            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement) , i}; //map.get gives the value value which is the index value
            }

            mp.put(nums[i] , i);

            
        }
        return new int[]{};
    }
}
