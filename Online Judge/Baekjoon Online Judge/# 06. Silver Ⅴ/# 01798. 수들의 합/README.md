---

# \[BOJ 01798\]   

난이도 : Silver5  
지정 입력값을 쪼갰을 때 최대한 쪼갤 수 있는 서로 다른 자연수의 갯수  
문제 : <a href="https://www.acmicpc.net/problem/1798" target="_blank"> [링크]</a>  
소스 코드 : <a href="src/Main.java" target="_blank">gitHub</a>  

---  

# 풀이

입력값 long S(S의 입력한도가 4,294,967,295이므로, long으로 받아야한다.)에 대하여

원본 S를 O라고 하면
```
S = S  // n == 1
  == 1 + (S-1) // n == 2
  == 1 + 2 + (S-1-2) // n ==3
  == 1 + 2 + ... + (S-1-2-3) // n == 4
  == ...
```  

와 같이 S에서 n을 제하면서, 분리할 수 있다.
이때 분리된 숫자들의 갯수를 n이라 하면, 다음번 작업을 수행했을 때 새로 분리되어질 숫자값은 n이 될 것이다.

이때 S-n이 n보다 클 경우 더 이상 쪼갰을 때 중복값이 발생하게 되므로, 더 이상 서로다른 숫자로 분리할 수 없게 된다.

---

```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        br.close();

        int n = 1; // 숫자의 갯수
        while (S-n>n) {
            S -= n++;
        }
        System.out.println(n);
    }
}

```

## 후기
- 예시로 입력된 값 200에 대하여 n을 증가시켜가면서 대입해나간 뒤 일반화 시켰다.
- 늙어서 그런가 이런거 생각이 빨리 빨리 안 된다. ㅜㅜ

---