# BOJ 02525 : 오븐 시계
- 난이도 : Bronze 3
- 시간을 더하여 출력
- 문제 : [링크](https://www.acmicpc.net/problem/2525)

---  

## 풀이
```python
def main():
    hour, minute = map(int, input().split())
    append_minute = int(input())
    end_hour, end_minute = solution(hour, minute, append_minute)
    print(end_hour, end_minute, sep=' ', end='')


def solution(hour, minute, append_minute):
    full_time = hour * 60 + minute + append_minute

    end_hour = full_time // 60 % 24
    end_minute = full_time % 60
    return end_hour, end_minute


main()

```
- 모든 시간단위를 분으로 환산하여 합산한다
- 분을 60으로 나눈 몫은 시간인데, 24를 넘어가는 경우를 고려하여 이를 다시 24로 나눈 나머지만큼만 처리한다.
- 분을 60으로 나눈 나머지만큼이 실질적인 분이다.

---
