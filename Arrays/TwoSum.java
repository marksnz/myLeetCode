/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.

 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]. 
 */

import java.util.HashMap;

public class TwoSum {
  
    /* ADD YOUR CODE HERE */
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            hmap.put(nums[i], i);
        }
        for (int i : nums)
        {
            if (hmap.containsKey(target - i))
            {
                return new int[]{hmap.get(i) + 1, hmap.get(target - i) + 1};
            }
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        int[] nums = {2, 17, 11, 7};
        int target = 9;
        int[] ret = null;
        ret = new TwoSum().twoSum(nums, target);
        if (null != ret)
        {
            System.out.println("nums[" + ret[0] + "] + nums[" + ret[1] + "] = " + nums[ret[0] - 1] + " + " + nums[ret[1] - 1] + " = " + target);
        }
        else
        {
            System.out.println("No solution found!");
        }
    }
  
}
