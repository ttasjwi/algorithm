
# 1.12 암호

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.12)

---

## 풀이 : 내 풀이
```java
        private static String solution(String line, int n) {
            StringBuilder mainSb = new StringBuilder();

            for (int i=0; i<n; i++) {

                StringBuilder subSb = new StringBuilder();

                for (int j=0; j<7; j++) {
                    int index = 7*i + j;
                    if (line.charAt(index) == '#') {
                        subSb.append(1);
                    } else {
                        subSb.append(0);
                    }
                }
                int value = Integer.parseInt(subSb.toString(), 2);
                mainSb.append((char) value);
            }
            return mainSb.toString();
        }
```
- 강사님은 replace 등의 메서드를 사용했는데 이건 시간비용이 좀 드는 메서드들이다.
- 문자열은 불변객체기 때문에 매번 객체를 생성하는 비용이 발생하고, StringBuilder를 사용하는 것이 시간적으로 유리하다.
- 각 인덱스별로 `#`은 1로, `*`은 0으로 변환하여 서브 StringBuilder에 저장
- 서브 StringBuilder에 저장된 문자열을 2진수 파싱한 뒤 char로  형변환하여 메인 StringBuilder에 append

---
