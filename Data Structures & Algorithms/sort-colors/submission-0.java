class Solution {
    public void sortColors(int[] nums) {
        //Dutch national Flag type...

        int low = 0 , mid = 0 , high = nums.length - 1;
        // swap low <=> mid if 0 and high <=> mid if 2 to push it to the back...

        while(mid <= high){
            
            // low denotes the place for 0 and high for 2...
            // so swap the low and mid for correct ) position 
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            // the position of 1 will automatically be correct...
            else if(nums[mid] == 1){
                mid++;
            }
            //same way for 2's position as in high...
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}