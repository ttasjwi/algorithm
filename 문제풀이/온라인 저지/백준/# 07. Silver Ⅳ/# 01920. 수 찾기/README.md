# 문제
- 플랫폼 : 백준
- 번호 : 01920
- 제목 : 수 찾기
- 난이도 : Silver 4
- N개의 정수 `A[1], A[2], …, A[N]`이 주어져 있을 때, 이 안에 추가로 입력되는 정수들이 존재하는지 알아내기
- 문제 : <a href="https://www.acmicpc.net/problem/1920" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시
- 이분탐색

---

# 풀이1 : 해시 사용
```python
input()
a = set(input().split())
input()
answer = '\n'.join('1' if x in a else '0' for x in input().split())
print(answer, end='')
```
- set을 통해 저장하면, 이후에 접근할 때는 O(1)로 접근할 수 있어서 빠르게 해당 숫자가 존재하는 지 확인할 수 있다.

---

# 풀이2
```python
a = None


def main():
    global a
    input()
    a = sorted(map(int, input().split()))
    input()
    answer = '\n'.join(binary_search(x) for x in map(int, input().split()))
    print(answer, end='')


def binary_search(x):
    lt = 0
    rt = len(a) - 1

    while lt <= rt:
        mid = (lt + rt) // 2
        if a[mid] == x:
            return '1'
        elif a[mid] > x:
            rt = mid - 1
        else:
            lt = mid + 1

    return '0'


if __name__ == '__main__':
    main()
```
- 이 문제의 출제의도는 이분탐색이였던 것 같다.
- 정렬 후 이분탐색을 하면서 찾고자하는 대상의 존재 여부를 파악한다.

---
