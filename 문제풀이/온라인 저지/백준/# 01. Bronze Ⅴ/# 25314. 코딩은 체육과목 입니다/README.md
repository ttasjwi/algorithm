# 문제
- 플랫폼 : 백준
- 번호 : 25314
- 제목 : 코딩은 체육과목 입니다
- 난이도 : Bronze 5
- 혜아가 N바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25314" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# Python
```python
print('long ' * (int(input()) // 4) + 'int')
```
- 입력을 4로 나눈 몫만큼 `long `을 반복작성하고, int를 뒤에 붙인다.
