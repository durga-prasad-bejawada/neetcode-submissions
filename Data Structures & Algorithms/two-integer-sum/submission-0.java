class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans [] = new int [2];
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            int remain = target-curr;
            if(sumMap.containsKey(remain)){
                ans[0]=sumMap.get(remain);
                ans[1]=i;
            }
            sumMap.put(curr,i);
        }
        return ans;
        
    }
}
