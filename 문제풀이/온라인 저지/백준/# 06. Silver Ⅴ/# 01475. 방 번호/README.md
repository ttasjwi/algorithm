# 문제
- 플랫폼 : 백준
- 번호 : 01475
- 제목 : 방 번호
- 난이도 : Silver 5
- 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
- 문제 : <a href="https://www.acmicpc.net/problem/1475" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
answer = 0
num_set = [0] * 9  # 0~8

for ch in input():
    require = int(ch)
    if require == 9:
        require = 6
    if num_set[require] == 0:
        answer += 1
        num_set = [num + 2 if idx == 6 else num + 1 for idx, num in enumerate(num_set)]
    num_set[require] -= 1
print(answer)
```
- num_set : 가진 플라스틱 숫자 카운터. 6과 9를 같은 것으로 취급하므로 6, 9 의 카운트는 6번 인덱스를 공유한다.
- 문자 하나하나마다 다음을 반복한다.
  - 문자를 숫자로 변환한다. (require)
  - require가 9이면 6으로 변환한다.
  - num_set에서 require의 카운트가 0이면 숫자 세트를 새로 구입해야 하는 경우이므로 answer를 증가시키고, 숫자 세트를 구입해서 리필한다.
    - 이때, 6번 인덱스는 2개씩 추가한다.(9와 6을 구조적으로 같게 보기 위해)
  - require 카운트를 1 감소시킨다.
- 최종 answer를 출력한다.

---
