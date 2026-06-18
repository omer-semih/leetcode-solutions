# LeetCode 3: Longest Substring Without Repeating Characters
# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self,s: str) -> int :
        left = max_length = 0
        char_set = set() # Stores characters in the current window
        for right in range(len(s)) :
            # Shrink the window from the left until duplicate is removed
            while s[right] in char_set :
                char_set.remove(s[left])
                left += 1

            char_set.add(s[right])
            max_length = max(max_length, right-left+1) # Update max if current window is larger

        return max_length