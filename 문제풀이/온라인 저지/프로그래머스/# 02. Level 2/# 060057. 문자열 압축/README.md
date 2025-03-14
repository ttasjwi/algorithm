# 문제
- 플랫폼 : 프로그래머스
- 번호 : 060057
- 제목 : 문자열 압축
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/60057" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
def solution(s):
    answer = len(s)
    
    # 쪼갤 단위 : 1, ... 문자 길이 절반 (그보다 넘어갈 경우 반복 자체가 안 됨)
    for unit in range(1, len(s) // 2 + 1):
        lt = 0
        rt = unit
        arr = []
        while rt <= len(s):
            pattern = s[lt:rt]
            count = 0
            
            # lt~rt 단위를 처음 패턴과 비교하고 같을 때마다 count 증가, lt 및 rt 를 unit 만큼 전진
            while rt <= len(s) and pattern == s[lt:rt]:
                count += 1
                lt += unit
                rt += unit
                
            # count 가 2 이상이면 반복되었다는 뜻이므로 숫자를 통해 압축 가능
            if count >= 2:
                arr.append(str(count))
            arr.append(pattern)
        
        # lt 가 s 길이보다 작은 값이면 그 만큼 문자열이 남아있으므로, 나머지는 전부 arr 에 추가
        if lt < len(s):
            arr.append(s[lt:])
            
        # 이렇게 만들어진 문자열의 길이를 length 라 할 때
        length = len(''.join(arr))
        
        # length 와 answer 비교 후 최솟값으로 answer 갱신
        if length < answer:
            answer = length
    return answer
```
