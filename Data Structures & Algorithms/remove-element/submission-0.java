class Solution {
    public int removeElement(int[] nums, int val) {

        int idx = 0;
        int si=0;
        while(si<nums.length){

            while(si<nums.length&&nums[si]==val){
                si++;
            }

            while(si<nums.length&&nums[si]!=val){
                nums[idx]=nums[si];
                si++;
                idx++;
            }
            si++;
            
        }

        return idx;
        
        
    }
}