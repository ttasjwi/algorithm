bits_a = [True if bit == '1' else False for bit in bin(int(input()))[2:].rjust(32, '0')]
bits_b = [not bit for bit in bits_a]

carry = True
for idx in range(len(bits_b) - 1, -1, -1):
    if not carry:
        break
    bits_b[idx], carry = bits_b[idx] != carry, bits_b[idx] and carry

answer = len([1 for bit_a, bit_b in zip(bits_a, bits_b) if bit_a != bit_b])
print(answer, end='')
