class Solution {
    public void sortColors(int[] nums) {

        int ones=0; int zeros =0; int twos = nums.length-1;


        while(ones<=twos){

            if(nums[ones]==0){
                nums[ones]=nums[zeros];
                nums[zeros]=0;
                ones++;zeros++;
            }else if(nums[ones]==2){
                nums[ones]=nums[twos];
                nums[twos]=2;
                twos--;
            }else{
                ones++;
            }
        }
        
    }
}