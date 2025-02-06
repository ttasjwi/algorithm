# 연결 리스트를 이용한 큐 구현
class Queue:
    class Node:
        def __init__(self, data):
            self.next = None
            self.data = data

    def __init__(self):
        self.head = None
        self.tail = None

    def enqueue(self, data):
        new_node = Queue.Node(data)
        if self.is_empty():
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

    def peek(self):
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.head.data

    def dequeue(self):
        if self.is_empty():
            raise IndexError("Queue is empty")
        data = self.head.data
        next_node = self.head.next

        if self.head is self.tail:
            self.tail = None
        self.head = next_node
        return data

    def is_empty(self):
        return self.head is None

    def to_list(self):
        result = []
        cur = self.head
        while cur:
            result.append(cur.data)
            cur = cur.next
        return result

q = Queue()
q.enqueue(4)
q.enqueue(2)
q.enqueue(3)
print(q.to_list())
print(q.dequeue())
print(q.to_list())
