# 문제
- 플랫폼 : LeetCode
- 번호 : 0104
- 제목 : Maximum Depth of Binary Tree
- 난이도 : Easy
- root 이진 트리가 주어지면 최대 깊이를 반환
- 문제 : <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree" target="_blank">링크</a>

---

# 필요 지식
- 트리
- BFS

---

# 풀이
```python
from collections import deque
from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        q = deque([root])
        depth = 0
        while q:
            depth += 1
            for node in range(len(q)):
                cur = q.popleft()
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
        return depth
```
- 트리의 깊이를 탐색하기 위해 BFS를 사용한다.

---
