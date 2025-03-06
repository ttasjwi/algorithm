def solution(arrayA, arrayB):
    gcd_a = gcd_arr(arrayA)  # 배열 A 원소를 모두 나눌 수 있는 최대의 수(A 배열 최대공약수)
    gcd_b = gcd_arr(arrayB)  # 배열 B 원소를 모두 나눌 수 있는 최대의 수(B 배열 최대공약수)

    result_a = 0
    result_b = 0

    # A 배열을 gcd_b 로 모두 나눌 수 있는지
    if cannot_divide(arrayA, gcd_b):
        result_a = gcd_b

    # B 배열을 gcd_a 로 모두 나눌 수 있는 지
    if cannot_divide(arrayB, gcd_a):
        result_b = gcd_a

    # 두 결과 중 더 큰 값
    return max(result_a, result_b)


def cannot_divide(arr, d):
    for e in arr:
        if not e % d:
            return False
    return True


def gcd_arr(arr):
    result = arr[0]
    for i in range(1, len(arr)):
        result = gcd(result, arr[i])
    return result


def gcd(a, b):
    if a < b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)
