# 배열을 이용한 스택 구현
class Stack:
    def __init__(self, capacity):
        self.array = [None] * capacity
        self.capacity = capacity
        self.top = -1

    def push(self, x):
        if self.top == self.capacity - 1:
            raise Exception("Stack is full")
        self.top += 1
        self.array[self.top] = x

    def pop(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        item = self.array[self.top]
        self.array[self.top] = None
        self.top -= 1
        return item

    def peek(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        return self.array[self.top]

    def is_empty(self):
        return self.top == -1

stack = Stack(capacity=5)
stack.push(1)
stack.push(2)
stack.push(3)
print(f"{stack.pop()}") # 3
print(f"{stack.pop()}") # 2
print(f"{stack.pop()}") # 1
