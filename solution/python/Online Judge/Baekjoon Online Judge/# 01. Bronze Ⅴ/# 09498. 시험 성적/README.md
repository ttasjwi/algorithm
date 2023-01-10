# BOJ 09498 : 시험 성적
- 난이도 : Bronze 5
- 조건문 사용해보기
- 문제 : [링크](https://www.acmicpc.net/problem/9498)

---

## 풀이
```python
def main():
    score = int(input())
    grade = get_grade(score)
    print(grade, end='')


def get_grade(score):
    if score >= 90:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 60:
        return 'D'
    else:
        return 'F'


main()

```
- 점수를 입력받고, 조건문을 통해 등급을 얻어온 뒤 출력한다.

---
