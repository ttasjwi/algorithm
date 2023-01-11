# Programmers 120823 : 직각삼각형 출력하기
- 난이도 : Level 0
- 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120823)

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++) {
            for (int j =1; j<=i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
```
- 별찍기

---
