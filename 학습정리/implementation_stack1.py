# 연결리스트를 이용한 스택 구현

class Stack:
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self):
        self.head = None

    def push(self, data):
        head = self.head
        new_node = Stack.Node(data)
        new_node.next = head
        self.head = new_node

    def pop(self):
        head = self.head
        if not head:
            raise IndexError('Stack is empty')
        next_node = head.next
        self.head = next_node
        return head.data

    def peek(self):
        head = self.head
        if not head:
            raise IndexError('Stack is empty')
        return head.data

    def is_empty(self):
        return self.head is None

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
print(f"{stack.pop()}") # 3
print(f"{stack.pop()}") # 2
print(f"{stack.pop()}") # 1

