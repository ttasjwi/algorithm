# BOJ 02480 : 주사위 세개
- 난이도 : Bronze 4
- 주사위를 던져서 같은 눈의 갯수에 따라 상금 다르게 부여
- 문제 : [링크](https://www.acmicpc.net/problem/2480)

---  

## 풀이
```python
def main():
    a, b, c = sorted(map(int, input().split()))
    price = solution(a, b, c)
    print(price, end='')


def solution(a, b, c):
    if a == c:  # 세 눈이 모두 같다
        return 10000 + a * 1000
    elif a != b and b != c: # 모두 다르다
        return c * 100
    else: # 두 가지가 같을 때
        return 1000 + b * 100


main()
```
- 입력값을 오름차순 정렬한다.
- 첫값과 끝값이 같을 때는 세 눈에 모두 같다는 것을 의미한다. 이에 따른 상금을 부여하고 리턴
- 셋이 모두 다른 경우에 대해서 c가 가장 큰 눈이므로, 이에 따른 상금을 부여하고 리턴
- 그 외의 경우는 두 개의 눈이 같은 경우인데 이 경우 b가 무조건 같은 눈이다. 이에 따른 상금을 부여하고 리턴한다.
