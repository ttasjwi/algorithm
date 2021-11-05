# boj_1008

난이도 : Bronze5  
BOJ(백준) 1단계 - 입출력과 사칙연산

두 정수 A,B를 입력받은 다음 A/B를 출력하는 프로그램 작성(A/B)  
문제 : <a href="https://www.acmicpc.net/problem/1008" target="_blank"> [링크]</a>
---  

## Answer : 백준 답안 제출용

- 풀이 내역 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_1008/Answer.java" target="_blank">gitHub</a>
- BufferedReader로 라인단위로 입력받음
- 공백문자열 기준으로 문자 분리(StringTokenizer)
- 각각 int로 파싱(Integer.parseInt) -> int a, int b
- a,b를 나눈다. 이때 두 값중 적어도 하나는 double로 형변환 해야함. (int/int -> int 라서, 소숫점 아랫값이 버려짐)
- 결과값 출력

---