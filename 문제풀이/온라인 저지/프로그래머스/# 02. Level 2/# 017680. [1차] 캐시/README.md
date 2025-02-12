# 문제
- 플랫폼 : 프로그래머스
- 번호 : 017680
- 제목 : \[1차\] 캐시
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17680" target="_blank">링크</a>

---

# 필요 지식
- LRU
- 큐
- 해시

---

# 풀이

### 풀이1 : 단순히 큐만 사용한 방법
```python
from collections import deque

def solution(cacheSize, cities):
    cache = deque()

    time = 0
    for city in cities:
        city = city.lower()
        if city in cache:
            time += 1
            cache.remove(city)
            cache.append(city)
        else:
            time += 5
            if cacheSize:
                if len(cache) == cacheSize:
                    cache.popleft()
                cache.append(city)
    return time
```
- 파이썬의 데크는 연결리스트 구조로 되어 있어서, 맨앞-맨뒤 추가/제거 및, 중간 제거 시간 복잡도가 크지 않다.
- 캐시를 확인해서, 캐시에 city 가 있으면 캐시에서 제거했다가 다시 추가한다. (1초 경과)
- 캐시를 확인해서, 캐시에 city 가 없으면
  - 캐시 용량이 있을 때, 캐시가 가득 찼다면 가장 오래된 요소를 제거하고, 새 요소를 캐시에 추가한다.
- 최종적으로 수행시간을 반환한다.

### 풀이2: 연결리스트 노드 직접 제어 및 해싱을 이용한 최적화
```python
class LRUCache:
    class Node:
        def __init__(self, prev, next, data):
            self.prev = prev
            self.next = next
            self.data = data

    def __init__(self, capacity):
        self.capacity = capacity
        self.head = None
        self.tail = None
        self.size = 0
        self.dict = {}

    def contains(self, data):
        return data in self.dict

    def append(self, data):
        if not self.capacity:
            return
        if data in self.dict:
            node = self.dict[data]
            self.__unlink(node)
        elif self.size == self.capacity:
            self.__unlink(self.head)
        self.__link_to_tail(data)

    def __unlink(self, node):
        prev_node = node.prev
        next_node = node.next
        if prev_node:
            prev_node.next = next_node
        else:
            self.head = next_node

        if next_node:
            next_node.prev = prev_node
        else:
            self.tail = prev_node
        node.prev = None
        node.next = None
        self.size -= 1
        self.dict.pop(node.data)
        node.data = None

    def __link_to_tail(self, data):
        node = LRUCache.Node(self.tail, None, data)
        if not self.tail:
            self.head = node
        else:
            self.tail.next = node
        self.tail = node
        self.size += 1
        self.dict[data] = node

def solution(cacheSize, cities):
    cache = LRUCache(cacheSize)
    process_time = 0
    for city in cities:
        city = city.lower()
        if cache.contains(city):
            process_time += 1
        else:
            process_time += 5
        cache.append(city)
    return process_time
```
- LRU 클래스를 만들고 내부에 딕셔너리를 두고, 이중 연결리스트 구조를 직접 만들어 제어
  - 딕셔너리에는 (값, 노드 참조) 를 둔다.
  - 이중 연결리스트 노드는 앞 노드, 뒷노드 참조를 가지므로, 노드 참조 정보를 통해 중간 노드를 O(1) 로 접근해서 제거 가능

---
