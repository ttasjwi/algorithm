# boj_2920

티어 : Bronze2

입력한 나열된 음계(숫자)의 증감 여부를 출력하기
문제 : <a href="https://www.acmicpc.net/problem/2920" target="_blank"> [링크]</a>
---  

## Answer : 백준 답안 제출용

- 풀이 내역 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_1000/Answer.java" target="_blank">gitHub</a>
- BufferedReader로 라인단위로 입력받음
- 공백문자열를 기준으로 문자 분리 후 각각 파싱, 배열에 저장(배열의 크기는 StringTokenizer을 통해 countTokens를 이욯하여 구함)
- 배열에 저장된 값들을 반복문을 통해 이전 인덱스의 값과 비교하여 증감상태를 지속적으로 확인
- 계속 값이 증가하면 ascending, 계속 값이 감소하면 descending, 증가 상태, 감소상태가 아니면 mixded를 반환함

---

## Review
- 문자열 "1 2 3 4 5 6 7 8", "8 7 6 5 4 3 2 1"과 비교하는 방법도 있고 이게 리소스와 속도면에서도 더 빠르긴 하겠지만, 이건 하드코딩 같아서 이렇게 비교하고 싶진 않았다.
- 배열을 정렬하여 비교하는 방법도 있긴함.