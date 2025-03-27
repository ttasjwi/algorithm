def solution(info, query):
    # 딕셔너리 초기화 : 가능한 모든 조합
    dic = init_dic()

    # info 를 읽어가면서, 딕셔너리에 점수 반영
    for i in info:
        update_dic_by_info(i, dic)

    # 이진탐색을 위해, 각 배열 정렬
    for arr in dic.values():
        arr.sort()

    answer = []

    # 쿼리를 파싱하고, 이진탐색을 통해 score 이상인 지원자 수를 매 케이스마다 계산
    for q in query:
        item, score = parse_query(q)
        result = binary_search(dic[item], score)
        answer.append(result)
    return answer

def init_dic():
    dic = {}
    for a in ['cpp', 'java', 'python', '-']:
        for b in ['backend', 'frontend', '-']:
            for c in ['junior', 'senior', '-']:
                for d in ['chicken', 'pizza', '-']:
                    dic[(a, b, c, d)] = []
    return dic

def update_dic_by_info(i, dic):
    arr = i.split()
    for a in [arr[0], '-']:
        for b in [arr[1], '-']:
            for c in [arr[2], '-']:
                for d in [arr[3], '-']:
                    dic[(a, b, c, d)].append(int(arr[4]))

def parse_query(q):
    arr = q.split()
    return (arr[0], arr[2], arr[4], arr[6]), int(arr[7])

# 배열에서 최초로 score 이상이 되는 인덱스를 찾고, 그 지점부터 시작하여 배열 끝까지의 원소 갯수 구하기
def binary_search(arr, score):
    lt = 0
    rt = len(arr) - 1
    min_idx = -1
    while lt <= rt:
        mid = (lt + rt) // 2
        if arr[mid] >= score:
            min_idx = mid
            rt = mid - 1
        else:
            lt = mid + 1
    if min_idx == -1:
        return 0
    else:
        return len(arr) - min_idx
