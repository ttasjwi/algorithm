# 문제
- 플랫폼 : 백준
- 번호 : 01068
- 제목 : 트리
- 난이도 : Gold 5
- 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1068" target="_blank">링크</a>

---

# 필요 지식
- DFS
- 트리

---

# 풀이
## 풀이1
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def dfs(node):
    global answer
    if target in children[node]:
        children[node].remove(target)
    if not children[node]:
        answer += 1
        return
    for child in children[node]:
        dfs(child)


n = int(input())
children = [set() for _ in range(n)]
root = 0
for idx, parent in enumerate(map(int, input().split())):
    if parent == -1:
        root = idx
    else:
        children[parent].add(idx)
target = int(input())
answer = 0
if target != root:
    dfs(root)
print(str(answer))
```
- children 이차원 리스트를 선언한다. 각 인덱스마다 자신의 자식을 기록한다.
  - 입력받을 때, 부모가 -1인 것은 root 취급한다.
- 지울 대상을 target으로 삼는다.
- 루트 노드를 시작으로 자식으로 순서대로 dfs를 수행한다.
  - 삭제 대상이 노드에 있으면 제거한다.
  - 자식이 없으면 리프노드이므로 카운팅하고 함수를 종료한다.
  - 자식이 있으면 자식을 dfs한다.(재귀 호출)

## 풀이2
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def dfs(parents, x):
    parents[x] = -2
    for i in range(len(parents)):
        if x == parents[i]:
            dfs(parents, i)


n = int(input())
parents = list(map(int, input().split()))
remove = int(input())
dfs(parents, remove)

answer = 0
for i in range(len(parents)):
    if parents[i] != -2 and i not in parents:
        answer += 1
print(str(answer))
```
- parents : 부모들을 순서대로 입력받아 저장
- remove : 제거 대상
- `dfs(parents, remove)` : 재귀적으로 remove와 그 자식들을 제거(-2 마킹)
  - parents에서 x 를 -2로 변경
  - parents에서 부모가 x인 것들을 찾아서 dfs 재귀호출

---
