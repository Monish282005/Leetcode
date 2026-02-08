class Solution(object):
    def mergeAdjacent(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack = []
        
        for num in nums:
            # While the current number matches the top of the stack,
            # they must be merged.
            while stack and stack[-1] == num:
                # Remove the top element and add it to our current value
                num += stack.pop()
            
            # Once no more merges are possible for this value, 
            # push the result onto the stack.
            stack.append(num)
            
        return stack