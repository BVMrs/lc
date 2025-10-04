package nc150.arrays;

import scala.concurrent.impl.FutureConvertersImpl;

import java.util.Arrays;

public class p0020_4_median_of_two_sorted_arrays {
  
  public static void main(String[] args) {
    int[] nums1 = new int[] { 1, 4, 7 };
    int[] nums2 = new int[] { 2, 5 };
    
    double result = findMedianSortedArrays(nums1, nums2);
    
    System.out.println(result);
  }
  
  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double ans = 0.0;
    
    int numsS = nums1.length + nums2.length;
    int k = numsS / 2;

    if (numsS % 2 == 1) {
      ans =  findMedianSortedArraysHelper(nums1, nums2, k, 0, nums1.length - 1, 0, nums2.length - 1);
    } else {
      ans =
          (double) (findMedianSortedArraysHelper(nums1, nums2, k, 0, nums1.length - 1,0, nums2.length - 1) +
        findMedianSortedArraysHelper(nums1, nums2, k - 1, 0, nums1.length - 1, 0, nums2.length - 1)) / 2;
    }
    
    return ans;
  }
  
  private static int findMedianSortedArraysHelper(int[] nums1, int[] nums2, int k, int l1, int r1, int l2, int r2) {
    if (r1 < l1) {
      return nums2[k - l1];
    }
    if (r2 < l2) {
      return nums1[k - l2];
    }
    
    int mid1 = l1 + (r1 - l1) / 2;
    int mid2 = l2 + (r2 - l2) / 2;
    
    if (mid1 + mid2 < k) {
      // search lower part
      if (nums1[mid1] > nums2[mid2]) {
        return findMedianSortedArraysHelper(nums1, nums2, k, l1, r1, mid2 + 1, r2);
      }
      else {
        return findMedianSortedArraysHelper(nums1, nums2, k, mid1 + 1, r1, l2, r2);
      }
    } else {
      if (nums1[mid1] > nums2[mid2]) {
        return findMedianSortedArraysHelper(nums1, nums2, k, l1, mid1 - 1, l2, r2);
      }
      else {
        return findMedianSortedArraysHelper(nums1, nums2, k, l1, r1, l2, mid2 - 1);
      }
    }
  }
  
  
  static int solve(int[] nums1, int[] nums2, int k, int l1, int r1, int l2, int r2) {
    if (r1 < l1) {
      return nums2[k - l1];
    }
    if (r2 < l2) {
      return nums1[k - l2];
    }
    
    int mid1 = (l1 + r1) / 2, mid2 = (l2 + r2) / 2;
    int aValue = nums1[mid1], bValue = nums2[mid2];
    
    // If k is in the right half of nums1 + nums2, remove the smaller left half.
    if (mid1 + mid2 < k) {
      if (aValue > bValue) {
        return solve(nums1, nums2, k, l1, r1, mid2 + 1, r2);
      } else {
        return solve(nums1, nums2, k, mid1 + 1, r1, l2, r2);
      }
    }
    // Otherwise, remove the larger right half.
    else {
      if (aValue > bValue) {
        return solve(nums1, nums2, k, l1, mid1 - 1, l2, r2);
      } else {
        return solve(nums1, nums2, k, l1, r1, l2, mid2 - 1);
      }
    }
  }
}
