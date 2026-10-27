class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int ans[] = new int[k];
        
        // Add the values into thte map key = numvalues , value = frequency

        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num , freq.getOrDefault(num , 0) + 1);
        }

        // In Priority Queue put [value , key] as arrays
        PriorityQueue<int[]> heap = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        for(Map.Entry<Integer , Integer> entry : freq.entrySet()){
            heap.offer(new int[]{entry.getValue() , entry.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        }

        //the heap stores in ascending order of he frequency values as arr[0] used in heap
        for(int i = 0 ; i < k ; i++){
            ans[i] = heap.poll()[1]; // get the real array value
        }
        return ans;
    }
}
