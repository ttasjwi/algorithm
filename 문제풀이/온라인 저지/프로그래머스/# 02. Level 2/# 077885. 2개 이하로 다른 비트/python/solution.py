def solution(numbers):
    return [convert(number) for number in numbers]


def convert(number):

    # 홀수인 경우
    # xxxxxxx1 로 끝난다. 이 경우 오른쪽 끝에서부터 가장 먼저 발견되는 0의 위치를 기준으로 다음 자리 1로 증가시키고 그 뒤 숫자를 0으로 만들면 된다.
    # 예) 1101 -> 1110 (비트 2개 바꾸기)
    # 예) 1111 -> 01111 -> 10111 (비트 2개 바꾸기)
    if number % 2:
        bit_str = '0' + bin(number)[2:] # 앞에 0을 붙인 이진 문자열
        right_zero_idx = bit_str.rfind('0') # 오른쪽에서부터 찾았을 때 처음 0이 발견되는 인덱스

        bit_arr = list(bit_str)
        bit_arr[right_zero_idx] = '1' # right_zero_idx 위치는 '1'로 바꾸기
        bit_arr[right_zero_idx + 1] = '0' # right_zero_idx + 1 은 '0' 으로 바꾸기

        return int(''.join(bit_arr), 2)

    # 짝수인 경우 : xxxx0 으로 끝나는데,
    # 뒤의 0을 1로 바꾸기만 하면 됨. 즉 값을 1 증가시키기만 하면 된다.
    else:
        return number + 1
