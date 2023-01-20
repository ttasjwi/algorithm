def solution(absolutes, signs):
    return sum(absolutes if sign else -absolute
               for absolute, sign in zip(absolutes, signs))
