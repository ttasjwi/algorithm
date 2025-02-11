# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012985
- 제목 : 예상 대진표
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12985" target="_blank">링크</a>

---

# 필요 지식
- 구현
- 수학

---

# 풀이

### 풀이1 : 수학
```python
def solution(n, a, b):
    answer = 0
    persons = [i + 1 for i in range(n)]

    while persons:
        answer += 1
        new_persons = []
        for i in range(0, len(persons), 2):
            if (persons[i] == a and persons[i + 1] == b) or (persons[i] == b and persons[i + 1] == a):
                return answer
            elif persons[i] == a or persons[i + 1] == a:
                new_persons.append(a)
            elif persons[i] == b or persons[i + 1] == b:
                new_persons.append(b)
            else:
                new_persons.append(persons[i])
        persons = new_persons
    return -1
```
- 배열을 순서대로 순회하면서 연속한 두 쌍의 번호를 확인하고 우승자를 다시 새 배열에 할당한다.
- 양쪽에 a, b가 있는 순간까지 answer 를 증가시킨다.
- 문제에서 시키는 대로 풀이하는 직관적 방식


### 풀이2 : 수학
```python
def solution(n, a, b):
    answer = 0
    a = a - 1
    b = b - 1
    while a != b:
        answer += 1
        a >>= 1
        b >>= 1
    return answer
```
- 2로 나눠서 나누어 떨어지는 연산을 따지기에는 0,1,2,3... 순으로 따지는게 편해서 우선 a,b에서 1을 차감한 값을 각각 a, b에 재할당했다.
- 라운드가 지나갈 때마다 우승자의 번호는 1/2 로 변하는데, a, b 가 언젠가는 그 번호가 같아지는 순간이 발생한다.
  - 이 순간이 둘이 만나는 순간이다.
- a, b가 같아 질 때까지 다음을 반복한다.
  - answer를 증가시킨다.
  - a, b 를 각각 절반으로 나누고 재할당한다.
- answer를 출력한다.
