---

# \[BOJ 02512\] 예산

= 난이도 : Silver3  
- 예산 총액이 주어졌을 때 각각의 예산을 조정하여, 각 예산들 중 적절한 최대 예산액수 구하기  
- 문제: <a href="https://www.acmicpc.net/problem/2512" target="_blank"> [링크]</a>  
- 소스 코드
  - 내 풀이 : <a href="src/Main.java" target="_blank">Main</a>

---  

# 내 풀이
```java
    int[] budgets = new int[N]; // 예산들

    for(int i=0; i<N; i++) {
        budgets[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(budgets); // 오름차순 정렬
```
- 값들을 입력받아서 배열로 저장해둔 뒤, 정렬한다.
- 정렬을 했으므로, 제일 끝 값은 최댓값이다.
```java
    int M = Integer.parseInt(br.readLine()); // 예산 총액
    while (sum(budgets) > M) { // 예산총액보다 합계가 클 때
        budgets[N-1] --; // 최댓값을 1 줄인다.
        for (int i=0; i<N; i++) {
            if (budgets[i] > budgets[N-1]) { // 각각의 값이 최댓값보다 클 경우
                budgets[i] --;
            }
        }
    }
    System.out.print(budgets[N-1]);
```
- 예산 총액을 입력받고, 예산 총액과 예산 배열의 합계를 비교하여, 합계가 더 클 경우
  - 최대 예산값을 1 감소시키고, 배열의 각 요소들을 탐색하여 최댓값보다 클 경우 1씩 삭감한다.
    - 이를 반복하여 예산총액이 합계보다 작거나 같게 되면, 반복을 탈출한다.
- 최종적으로 예산의 최댓값(예산 배열의 끝값)을 출력한다.

---