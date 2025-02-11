def solution(A, B):
    return [[sum(a*b for a,b  in zip(a_row, b_col)) for b_col in zip(*B)] for a_row in A]
