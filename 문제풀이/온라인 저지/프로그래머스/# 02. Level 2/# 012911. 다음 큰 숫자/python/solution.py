def solution(n):
    target_bit_count = bin(n).count('1')
    while True:
        n += 1
        if bin(n).count('1') == target_bit_count:
            return n
