# 문제
- 번호 : 120842
- 제목 : 2차원으로 만들기
- 난이도 : Level 0
- num_list를 주어진 조건에 따라 2차원 배열로 바꿔 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120842)

---

# 필요 알고리즘
- 기본적인 반복문
- 주기성(나머지)

---

# 풀이1
```java
public class Solution1 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];

        for (int i=0; i<answer.length; i++) {
            for (int j=0; j<answer[0].length; j++) {
                answer[i][j] = num_list[i*n+j];
            }
        }
        return answer;
    }
}
```

---

# 풀이2
```java
public class Solution2 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];

        for (int i=0; i<num_list.length; i++) {
            answer[i/n][i%n] = num_list[i];
        }
        return answer;
    }
}
```

---
