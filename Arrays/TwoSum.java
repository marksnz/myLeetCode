/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.

 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]. 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
  
    /* ADD YOUR CODE HERE */
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
        	if (hmap.containsKey(nums[i])) 
        	{
        		hmap.get(nums[i]).add(i);				
			}
        	else 
        	{
        		List<Integer> ls = new ArrayList<>();
        		ls.add(i);
        		hmap.put(nums[i], ls);
			}
        }
        for (int i : nums)
        {
            if (hmap.containsKey(target - i))
            {
            	if (i*2 == target) 
            	{
					if (hmap.get(i).size() > 1) 
					{
						return new int[]{hmap.get(i).get(0), hmap.get(i).get(1)};
					}
				}
            	else 
            	{
            		return new int[]{hmap.get(i).get(0), hmap.get(target - i).get(0)};
				}
            }
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        int[] nums = {5, 5};//{2, 17, 11, 8};
        int target = 10;
        int[] ret = null;
        ret = new TwoSum().twoSum(nums, target);
        if (null != ret)
        {
            System.out.println("nums[" + ret[0] + "] + nums[" + ret[1] + "] = " + nums[ret[0]] + " + " + nums[ret[1]] + " = " + target);
        }
        else
        {
            System.out.println("No solution found!");
        }
    }
  
}
