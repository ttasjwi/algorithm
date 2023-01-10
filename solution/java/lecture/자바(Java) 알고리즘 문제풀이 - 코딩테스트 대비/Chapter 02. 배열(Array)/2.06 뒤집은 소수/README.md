
# 2.06 뒤집은 소수

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.06)

---

## 풀이 : 뒤집고, 소수 판별
```java
    private static String solution(String[] words) {
        StringBuilder sb = new StringBuilder();

        boolean[] isCompositeNumber = new boolean[100001];
        isCompositeNumber[1] = true;

        for (int i=2; i<isCompositeNumber.length; i++) {
            if (!isCompositeNumber[i]) {
                for (int j=i+i; j<isCompositeNumber.length; j +=i) {
                    isCompositeNumber[j] = true;
                }
            }
        }

        for (int i=0; i< words.length; i++) {
            int reverseNumber = Integer.parseInt(new StringBuilder(words[i]).reverse().toString());
            if (!isCompositeNumber[reverseNumber]) {
                sb.append(reverseNumber).append(' ');
            }
        }
        return sb.toString();
    }
```
- 숫자 범위 100000 이하의 자연수이므로 1~100000 사이의 소수를 일괄적으로 '에라토스테네스의 체' 방식을 사용하여 판별했다.
  - 다만 이게 너무 시간적으로 비싼 로직이긴 하다.
  - 하지만 숫자의 갯수가 매우 많은 경우를 고려해보면 나쁘진 않다.
- 숫자를 뒤집는다.
  - 숫자를 뒤집는 방법이 여러가지 있긴한데, 나는 StringBuilder.reverse를 통해 문자열을 뒤집고 이를 파싱했다.
  - 강사님은 이 부분을 while문 돌려서 나머지, 몫 로직을 사용하여 뒤집는 방식을 사용했는데 이를 아래에 후술하겠다.

---

### 내가 숫자를 뒤집은 방법
```java
int reverseNumber = Integer.parseInt(new StringBuilder(words[i]).reverse().toString());
```
- StringBuilder.reverse 활용

### 강사님의 숫자를 뒤집은 방법
```java
    private static int reverseNumber(int number) {
        int reverseNumber = 0;
        int tmp;
        
        while(number > 0) { // 숫자가 0보다 큰 동안 반복 돌린다.
            tmp = number%10; // 일의 자리 숫자를 추출한다.
            reverseNumber = reverseNumber * 10 + tmp; // 숫자 뒤에 일의 자리 숫자를 덧붙인다.
            number = number/10; // number를 10으로 나누어, 자리수를 끝을 줄인다.
        }
        return reverseNumber;
    }
```
- while문을 돌릴 때 number가 0보다 큰 동안에만 돌린다.
- tmp에는 숫자 끝자리를 저장한다.
- reverseNumber에는 숫자 끝자리를 차례로 뒤에 덧붙인 숫자값을 갱신하여 저장한다.
- 숫자 끝자리를 추출하여 저장하고 나면, 원본 숫자 끝자리를 없애기 위해 `/10`연산을 취한다.

---