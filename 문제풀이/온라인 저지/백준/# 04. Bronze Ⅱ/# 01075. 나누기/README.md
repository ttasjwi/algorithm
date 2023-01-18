
# \[BOJ_01075\] 나누기 

- 난이도 : Bronze2
- 브루트포스 알고리즘
- 문제: <a href="https://www.acmicpc.net/problem/1075" target="_blank"> [링크]</a>

---

## 풀이방식
```java
    public static void main(String[] args) throws IOException {
        int n = readInt()/100*100;
        int f = readInt();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<100; i++) {
            if ((n+i)%f == 0) {
                if (i < 10) {
                    sb.append(0).append(i);
                } else {
                    sb.append(i);
                }
                break;
            }
        }
        System.out.print(sb);
    }
```
- 주어진 n의 백의자리 아래 부분을 지우기 위해 `/100` 후 `*100` 했다.
- 0~99를 반복해서 나누어 떨어지는 지 여부를 판별한다.
  - 출력 시 0~9는 앞에 0을 붙여야하므로 이에 따른 분기문을 작성했다

---

## 시간 복잡도
- 0~99까지 총 100번을 반복돌려서 문제를 해결
- 항상 일정한 연산횟수이므로 시간복잡도는 O(1)

---