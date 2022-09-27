def main():
    score = int(input())
    grade = get_grade(score)
    print(grade, end='')


def get_grade(score):
    if score >= 90:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 60:
        return 'D'
    else:
        return 'F'


main()
