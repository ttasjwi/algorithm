# BOJ 02884 : 알람 시계
- 난이도 : Bronze 3
- 45분 전으로 알람 시간 맞추기
- 문제 : [링크](https://www.acmicpc.net/problem/2884)

---  

## 풀이
```python
def main():
    hour, minute = map(int, input().split())
    alarm_hour, alarm_minute = solution(hour, minute)
    print(alarm_hour, alarm_minute, sep=' ', end ='')


def solution(hour, minute):
    if minute >= 45:
        return hour, minute - 45
    else:
        if hour == 0:
            return 23, minute + 15
        return hour - 1, minute + 15


main()

```
- 시, 분을 입력받는다.
- 45분 전에 알람을 맞추기 위해 시간 계산을 수행한다.
- 이를 출력한다
