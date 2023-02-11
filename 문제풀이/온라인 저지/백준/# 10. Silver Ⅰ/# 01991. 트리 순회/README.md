# 문제
- 플랫폼 : 백준
- 번호 : 01991
- 제목 : 트리 순회
- 난이도 : Silver 1
- 이진 트리가 주어질 때 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1991" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- 트리

---

# 풀이
```python
import sys

print = sys.stdout.write


def main():
    input = sys.stdin.readline
    nodes = {}
    for i in range(int(input())):
        v, l, r = input().split()
        nodes[v] = (l if l != '.' else None, r if r != '.' else None)
    pre_order_dfs(nodes, 'A')
    print('\n')
    in_order_dfs(nodes, 'A')
    print('\n')
    post_order_dfs(nodes, 'A')


def pre_order_dfs(nodes, node):
    if not node:
        return
    print(node)
    pre_order_dfs(nodes, nodes[node][0])
    pre_order_dfs(nodes, nodes[node][1])


def in_order_dfs(nodes, node):
    if not node:
        return
    in_order_dfs(nodes, nodes[node][0])
    print(node)
    in_order_dfs(nodes, nodes[node][1])


def post_order_dfs(nodes, node):
    if not node:
        return
    post_order_dfs(nodes, nodes[node][0])
    post_order_dfs(nodes, nodes[node][1])
    print(node)


main()
```
- 전위 순회 : 루트 - 왼쪽 - 오른쪽
- 중위 순회 : 왼쪽 - 루트 - 오른쪽
- 후위 순회 : 왼쪽 - 오른쪽 - 루트

---
