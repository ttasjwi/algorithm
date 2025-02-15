def solution(phone_book):
    phone_set = set(phone_book)

    for phone in phone_book:
        for i in range(len(phone) - 1):
            if phone[:i + 1] in phone_set:
                return False
    return True
