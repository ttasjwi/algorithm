def solution(files):
    # 1. convert 를 통해 튜플로 변환 (head, number, 원래 인덱스, 원본 파일)
    # 2. 튜플 정렬
    # 3. 원본 파일명 배열로 변환
    return list(map(lambda x: x[3], sorted([convert(index, file) for index, file in enumerate(files)])))

def convert(index, file):
    lt = -1

    # 숫자가 시작되는 지점 찾기
    for i in range(len(file)):
        if file[i].isdigit():
            lt = i
            break

    rt = lt + 1
    for i in range(rt, len(file)):
        # 마지막까지 갔는데 계속 숫자인 경우(뒤에 tail 이 빈 문자열인 경우)도 고려해야함
        if i == len(file) - 1 and file[i].isdigit():
            rt = len(file)

        # 처음 숫자가 아닌 문자를 발견하면
        elif not file[i].isdigit():
            rt = i
            break
    head = file[:lt].lower() # 숫자 전까지 head
    number = int(file[lt:rt]) # 숫자 구간
    return head, number, index, file
