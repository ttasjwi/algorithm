from typing import List

count = 0


def solution(board: List[List[int]], moves: int) -> int:
    stack = []

    for move in moves:
        index = move - 1
        doll = extract_doll(board, index)
        put_doll(stack, doll)

    return count


def extract_doll(board: List[List[int]], index: int) -> int:
    current = 0
    for i in range(0, len(board)):
        current = board[i][index]
        if current > 0:
            board[i][index] = 0
            return current

    return current


def put_doll(stack: List[List[int]], doll: int) -> None:
    global count

    if doll == 0:
        return

    if len(stack) != 0 and stack[-1] == doll:
        stack.pop()
        count += 2
        return

    stack.append(doll)
