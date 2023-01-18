def solution(order):
    order = str(order)
    return sum(map(lambda x: order.count(x), ['3', '6', '9']))

