# 문제
- 플랫폼 : 백준
- 번호 : 28235
- 제목 : 코드마스터 2023
- 난이도 : Bronze 5
- 문제 : <a href="https://www.acmicpc.net/problem/28235" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
dict = {"SONGDO": "HIGHSCHOOL", "CODE": "MASTER", "2023": "0611", "ALGORITHM": "CONTEST"}
word = input()
print(dict[word], end='')
```
- 정해진 입력에 대한 정해진 메시지를 출력하면 되므로 간단하게 딕셔너리를 사용했다.
  - java 등의 다른 언어의 경우 해시테이블 자료구조를 사용해서 해결하면 된다.
- 그냥 분기처리를 해도 될 듯.

