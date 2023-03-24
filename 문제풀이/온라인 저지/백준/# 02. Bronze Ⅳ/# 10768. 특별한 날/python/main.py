month = int(input())
day = int(input())
print("After" if month > 2 or (month == 2 and day > 18) else "Special" if month == 2 and day == 18 else "Before")
