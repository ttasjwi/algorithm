---
# \[BOJ 02581\] 소수

난이도 : Silver5
지정 범위 내의 소수의 최솟값 및 합 출력  
문제 : <a href="https://www.acmicpc.net/problem/2581" target="_blank"> [링크]</a>
소스 코드 : <a href="src/Main.java" target="_blank">gitHub</a>

---  

# 1. 소수란?
- 1보다 큰 자연수 중에서, 1과 자기 자신만을 약수로 가지는 자연수
  - 예> 2, 3, 5, 7, 11, ...

---

# 2. 소수판별법

## 2.1 소수판별법 (1) : 2이상 n 미만의 모든 수로 나눠보기

- n==1 : 소수가 아니다.
- n==2 : 소수
- n이 1 또는 2가 아닐 경우
  - 2이상 n 미만의 수로 나눠보길 반복하다가, 나누어 떨어지는 경우가 있을 경우 소수가 아니다.
- 시간 복잡도 : O(N)
  - n 미만의 수까지 모두 검사해야하는 문제가 발생함
  - n뿐만 아니라, n까지의 모든 소수의 갯수를 판별하는 경우 시간 복잡도가 O(N^2)로 풀어남.


```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        br.close();

        boolean[] isNotPrimeNumber = new boolean[n-m+1]; // 소수면 false, 소수가 아니면 true;

        for (int number=m; number<=n; number++) { //  m부터 n까지 각 숫자에 대하여
            if (number==1) {
                isNotPrimeNumber[number-m] = true; // m이 1이면, 소수가 아니다.
                continue;
            }
            if (number == 2) {
                continue;
            }
            if (isNotPrimeNumber[number-m] == true) continue;

            for (int devisor=2; devisor<number; devisor++) {
                if (number%devisor == 0) isNotPrimeNumber[number-m] = true;
            }
        }

        int sum = 0;
        int min = -1;

        for (int i=isNotPrimeNumber.length-1; i>=0; i--) {
            if (isNotPrimeNumber[i] == false) {
                sum += i+m;
                min = i+m;
            }
        }

        if (min == -1) {
            System.out.println(min);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(sum).append('\n').append(min);
            System.out.println(sb);
        }

    }
}
```

  
---

## 2.2 소수판별법 (2) : 2이상 sqrt(n) 이하의 모든 자연수로 나눠보기

- n==1 : 소수가 아니다.
- n==2 : 소수
- n이 1 또는 2가 아닐 경우
  - 2이상 root(n)이하의 수로 나눠보길 반복하다가, 나누어 떨어지는 경우가 있을 경우 소수가 아니다.
- 시간 복잡도 : O(root n)
  - n뿐만 아니라, n까지의 모든 소수의 갯수를 판별하는 경우 시간 복잡도가 O(N root N)으로 불어남. (root n의 알고리즘을 n번 반복)

```
...
        for (int devisor=2; devisor<=Math.sqrt(number); devisor++) { // 위의 경우에서 걸러지지 않은 상황에서, 2이상 root n 이하의 정수로 계속 나눴을 때
            if (number%devisor == 0) isNotPrimeNumber[number-m] = true; // devisor로 나눴을 때 나누어 떨어지는 경우가 존재하면 소수가 아니다.
        }
    }
...
```


---

## 2.3 소수판별법 (3) : 에라토스테네스의 체와 접목

1부터 n까지 수 중에서 소수인지 아닌지를 판별하기

- n==1 : 소수가 아니다.
- 나누는 수를 devisor라고 할 때 devisor=2부터, devisor=root(n) 이하의 가장 큰 정수까지 반복하여 다음 작업을 수행한다.
  - devisor을 제외한 devisor의 배수(단, n 이하)는 소수가 아니므로 검사 대상에서 제외한다.
  - devisor가 이미 위에서 제외됐다면, 그 devisor의 작업은 수행하지 않는다.
  - 이 작업을 계속 반복하고 남아있는 수들이 소수다.

```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int m = Integer.parseInt(br.readLine());
        final int n = Integer.parseInt(br.readLine());
        br.close();

        boolean[] isNotPrimeNumber = new boolean[n+1]; // 0~n
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;

        for (int devisor=2; devisor<=Math.sqrt(n) ; devisor++) {
            if (isNotPrimeNumber[devisor]==true) continue;
            for (int multiple = devisor * 2; multiple< isNotPrimeNumber.length; multiple+= devisor) {
                isNotPrimeNumber[multiple] = true;
            }
        }

        int sum = 0;
        int min = -1;

        for (int i=m; i<=n; i++) {
            if (isNotPrimeNumber[i] == false) {
                sum += i; // 소수의 합
                if (min==-1) min = i; // 소수의 최솟값 갱신
            }
        }

        if (min == -1) { // 소수가 없는 경우
            System.out.println(min);
        } else { // 소수가 있는 경우
            StringBuilder sb = new StringBuilder();
            sb.append(sum).append('\n').append(min);
            System.out.println(sb);
        }

    }
}
```

---

# 후기

- 정수론이 제일 어렵다.
- 프로그래밍 공부하는데 정수론까지 공부하는게 맞는걸까?
- 시간 복잡도는 뭘까?

---
