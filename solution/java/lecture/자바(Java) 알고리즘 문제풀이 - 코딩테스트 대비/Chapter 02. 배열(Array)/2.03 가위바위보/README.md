
# 2.03 가위바위보

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.03)

---

## 풀이
```java
    private static String solution(int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {

            if (a[i] == b[i]) {
                // 비길 때
                sb.append('D').append('\n');
            } else if (a[i] == 1 && b[i] == 3) {
                // 가위 보 -> A가 이길 때
                sb.append('A').append('\n');
            } else if (a[i] == 2 && b[i] == 1) {
                // 바위 가위 -> A가 이길 때
                sb.append('A').append('\n');
            } else if (a[i] == 3 && b[i] == 2) {
                // 보 바위 -> A가 이길 때
                sb.append('A').append('\n');
            } else {
                // B가 이길 때
                sb.append('B').append('\n');
            }
        }
        return sb.toString();
    }

```
- 단순한 분기 처리
- 반복문, 조건문 노가다 타이핑

---
