def solution(n):
    cache = {}
    base = [[1, 1], [1, 0]]
    return matrix_power(base, n, cache)[0][0]

def matrix_power(matrix, n, cache):
    if n == 1:
        return matrix
    if n in cache:
        return cache[n]
    half = matrix_power(matrix, n//2, cache)
    cache[n] = multiply_matrix(multiply_matrix(half, half), matrix) if n % 2 else multiply_matrix(half, half)
    return cache[n]

def multiply_matrix(a,b):
    result = [[0] * len(b[0]) for _ in range(len(a))]
    for i in range(len(a)):
        for j in range(len(b[0])):
            for k in range(len(b)):
                result[i][j] += (a[i][k] * b[k][j])
                result[i][j] %= 1234567
    return result
