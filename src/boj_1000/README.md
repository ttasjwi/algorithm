# boj_1000

난이도 : Bronze5  
BOJ(백준) 1단계 - 입출력과 사칙연산

입력으로 정수 2개를 입력받고, 이들의 합을 반환하기(A+B)  
문제 : <a href="https://www.acmicpc.net/problem/1000" target="_blank"> [링크]</a>
---  

## Answer : 백준 답안 제출용

- 풀이 내역 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_1000/Answer.java" target="_blank">gitHub</a>
- BufferedReader로 라인단위로 입력받음
- 공백문자열를 기준으로 문자 분리 후 각각 파싱
- 파싱값들을 합산하여 출력

---

## Review
- 실제로 자바파일 작성 시에는 메서드 하나 당 하나의 기능을 하도록 해야함.
- 하지만 알고리즘에서는 그냥 속도가 킹왕짱이니까 메서드 분리는 오히려 리소스를 잡아먹는다...