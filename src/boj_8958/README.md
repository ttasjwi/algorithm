# boj_8958

난이도 : Bronze2  

- OX문자열을 받아서 총점 구하기(연속 O이면 추가점수)
- 문제 : <a href="https://www.acmicpc.net/problem/8958" target="_blank"> [링크]</a>
---  

### Answer : 백준 답안 제출용

- 소스코드 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_8958/Answer.java" target="_blank">gitHub</a>
- BufferedReader로 테스트 케이스의 갯수를 입력받음.
- 테스트 케이스만큼 이하의 내용을 반복
    - 사용자로부터 OX 결과를 입력받음
    - 입력받은 문자열을 char[]로 변환한다.
    - char[]의 각 인덱스에 접근하여 문자(O,X)를 순차적으로 확인한다. 
      - 정답('O')이면 bonus를 증가, bonus만큼 총점(score)에 합산한다.
      - 오답이면 bonus를 0으로 초기화한다.
    - score를 StringBuilder에 append, 그리고 개행문자('\n')도 append한다.
- StringBuilder에 저장된 값을 출력한다.

---

## Review
- 연속적으로 정답일 경우 점수를 어떻게 줄지 고민하다가 bonus 변수를 따로 생각하게 됐다.