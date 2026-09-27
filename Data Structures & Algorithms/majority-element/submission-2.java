class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int count =1;
        int prev = nums[0];
        int maxNum=nums[0];
        int max=1;

        for(int i=1;i<nums.length;i++){

            if(prev==nums[i]){
                count++;
            }else{
               
               if(count>max){
                max = count;  
                maxNum=prev;
               }

                prev=nums[i];
                count=1;

            }

        }

            if(count>max){
                maxNum=prev;
            }

        return maxNum;
        
    }
}