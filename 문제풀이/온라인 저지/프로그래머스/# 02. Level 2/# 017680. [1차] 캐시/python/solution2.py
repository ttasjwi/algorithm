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
