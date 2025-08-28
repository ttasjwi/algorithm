# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 3.1
- 제목 : 두 배열 합치기
- 오름차순 정렬된 배열을 합치기


---

# 필요 지식
- 투 포인터

---

## 풀이
```python
input()
arr1 = [int(x) for x in input().split()]
input()
arr2 = [int(x) for x in input().split()]

p1 = 0
p2 = 0
result = []
while p1 < len(arr1) and p2 < len(arr2):
    if arr1[p1] <= arr2[p2]:
        result.append(arr1[p1])
        p1 += 1
    else:
        result.append(arr2[p2])
        p2 += 1

while p1 < len(arr1):
    result.append(arr1[p1])
    p1 += 1
while p2 < len(arr2):
    result.append(arr2[p2])
    p2 += 1
print(*result, end = '')
```
- 각 배열에 포인터를 두고 비교하고, 더 작은 것을 순서대로 삽입하면서 각각 포인터 전진.
- 최종적으로 어느 반대쪽의 요소는 남아있을 수 있므로 각각 비울 것.

---

# 참고: 병합정렬 아이디어 설명
- 정렬된 배열은 투 포인터를 사용하면 O(N) 시간복잡도로 정렬 가능하다.
- 그런데, 임의의 배열을 쪼개고 쪼갠뒤 각각을 '정렬된 배열'들로 보고 오름차순 정렬을 시킨뒤 이들을 합쳐나가길 반복한다면?
- 이렇게 되면, 최종적으로는 O(NlogN) 시간복잡도로, 배열을 정렬할 수 있다.
