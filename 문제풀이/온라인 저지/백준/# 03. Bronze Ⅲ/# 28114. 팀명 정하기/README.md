# 문제
- 플랫폼 : 백준
- 번호 : 28114
- 제목 : 팀명 정하기
- 난이도 : Bronze 3
- 첫번째, 두번째 방법으로 만든 팀명을 각각 출력
- 문제 : <a href="https://www.acmicpc.net/problem/28114" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
p, y, s = [], [], []

for _ in range(3):
    i, j, k = input().split()
    p.append(int(i))
    y.append(int(j))
    s.append(k)
print(''.join(map(str, sorted(map(lambda x: x % 100, y)))))
print(''.join(map(lambda x: s[p.index(x)][0], sorted(p, reverse=True))))
```
- p는 문제 갯수 배열, y는 입학 연도 배열, s는 성씨 배열이다.
- sorted 함수는 원본 iterable을 변경하지 않고 새로 정렬된 결과를 가져오기 때문에 이번 문제에 쓰기 좋다.
- 각 라인 입력을 순서대로 p, y, s 에 타입에 맞게 저장한다.
- 첫번째 출력 요구사항은 y의 요소를 100으로 나눈 나머지를 오름차순 정렬하여 문자열로 순서대로 붙인 것이다.
- 두번째 출력 요구사항은 p의 요소를 내림차순 정렬하여, 해당 횟수만큼 푼 사람의 순서대로 앞글자를 결합하는 것이다.
  - 여기선, 요소가 3개밖에 없으니까 index 함수를 사용해서 접근했는데 만약 요소가 더 많아졌다면 별도로 해시테이블 자료구조를 써야했을 것이다.

---
