# LeetCode 00819 : Most Common Word
- 난이도 : Easy
- 금지된 단어를 제외한 가장 흔하게 등장하는 단어 출력
- 문제 : [링크](https://leetcode.com/problems/most-common-word/)

---

## 지식

### 정규 표현식을 이용한 필터링
```python
import re
re.sub('pattern', 'replace', 'word')
```
- word에서, pattern(정규표현식)에 맞는 문자를 찾아 replace 문자열로 변환한다.

### 리스트 컴프리헨션
```python
results = [result for ... if...]
```
- 반복을 통하여 결과 result를 만든다. 이때 if문의 조건에 부합하는 것만 요소로 갖도록 한다.

### collection.defaultdict()
- 보통 딕셔너리에서 없는 key에 값을 조회하면 하면, 오류가 발생하는데, defaultdict는 없는 값을 조회하면, 해당 키에 대한 기본값을 생성해준다.

### collection.Counter(items)
- 인자로 전달된 요소들의 등장 횟수를 딕셔너리로 카운팅하여 저장한다. 최종적으로는 한 번 더 래핑한 collections.Counter 클래스 형태가 된다.
- 여기서 가장 빈도 수가 높은 요소를 추출할 때는, `most_common(k)`을 사용하면, 가장 빈도가 높은 k개의 요소를 리스트로 추출한다.

---

## 풀이

### 풀이1 : 리스트 컴프리헨션 + defaultdict를 이용한 카운팅
```python
import collections
import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word
                 for word in re.sub(r'\W', ' ', paragraph).lower().split()
                 if word not in banned]
        counts = collections.defaultdict(int)
        for word in words:
            counts[word] += 1
        return max(counts, key=counts.get)


```
- 리스트 컴프리헨션을 사용해 문자열을 필터링하고 리스트에 순서대로 분리해 저장한다.
    - `r'\W'` == `r'[^a-zA-Z0-9_]` : 영문자, 숫자, 언더 스코어가 아닌 모든 문자
    - `r'\w'` == `r'[a-zA-Z0-9_]` : 영문자, 숫자, 언더스코어
    - 이 방법을 사용하면, 마침표, 쉼표 등을 공백 문자로 변환해준다.
    - 대소문자를 구분하지 않으므로 일괄적으로 소문자화한다.
    - 분리하면 리스트가 되는데, 이 상태에서, for문을 통해 하나 하나 돌면서 banned에 속하는 문자열을 제외한 문자열만 리스트에 담는다.
- `collections.dafaultdict(int)` : 기본값으로 정수 0을 가질 수 있는 딕셔너리를 생성한다.
- 단어를 만날 때마다 카운팅을 1 증가시킨다.
- 최종적으로, 카운터에서, 최대 카운트를 가지는 문자열을 반환시키면 된다.

### 풀이2 : 리스트 컴프리헨션 + Counter를 이용한 카운팅
```python
from collections import Counter
import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word
                 for word in re.sub(r'\W', ' ', paragraph).lower().split()
                 if word not in banned]
        counts = Counter(words)
        return counts.most_common(1)[0][0]
```
- Counter를 생성하고, `most_common(1)`을 호출하여 가장 빈번하게 등장한 카운팅 튜플(문자열, 횟수)을 리스트로 얻어온다.
- 0번째에 위치한 카운팅 튜플을 얻어온뒤(문자열, 횟수)
- 0번 인덱스에 위치한 문자열을 반환하면 된다.

---
