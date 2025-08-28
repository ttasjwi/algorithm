# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.03
- 제목 : 가위바위보
- 연속해서 가위바위보를 할 때 각 줄에 각 회의 승자를 출력

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
input()
answer = []
for a, b in zip(input().split(), input().split()):
    # 비기는 경우
    if a == b:
        answer.append('D')
    else:
        # A가 이기는 경우
        # 가위/보, 바위/가위, # 보/바위 
        if (a == '1' and b == '3') or (a == '2' and b == '1') or (a == '3' and b == '2'):
            answer.append('A')
            
        # B가 이기는 경우 : 그 외
        else:
            answer.append('B')
print('\n'.join(answer), end='')
```
- zip 사용해서 두 반복자를 엮음
1. 두 요소가 같으면 비김
2. 그 외 
   1) A가 이긴 경우 처리
   2) else로 나머지는 B가 이긴 경우 처리

---
