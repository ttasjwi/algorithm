class Node:
    def __init__(self, item, next):
        self.item = item  # 요소
        self.next = next  # 다음 노드


class Stack:

    def __init__(self):
        self.last = None

    def push(self, item):
        self.last = Node(item, self.last) # 새로 삽입하는 데이터를 마지막 요소로 하고, 현재 요소의 next로, 기존의 last를 둠

    def pop(self):
        item = self.last.item # 마지막 요소의 item을 추출
        self.last = self.last.next # 마지막 요소의 next에 위치한 요소를 마지막 요소로 함
        return item


stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)

for _ in range(5):
    print(stack.pop())
