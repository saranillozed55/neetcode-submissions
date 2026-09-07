class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        map = {"}" : "{", ")" : "(", "]" : "["}

        for c in s:
            if c in map:
                #pop the top element if the the stack isn't empty, else use a dummy value
                top_elem = stack.pop() if stack else '#'

                if map[c] != top_elem:
                    return False
            else:
                #if opneing bracket, push to top of stack
                stack.append(c)
        return len(stack) == 0
