from sys import stdin, stdout

stack = []


def main():
    lines = stdin.readlines()
    lines.pop()
    for line in lines:
        stdout.write('yes\n' if is_valid_line(line) else 'no\n')


def is_valid_line(line):
    stack.clear()
    for char in line:
        if char in '[(':
            stack.append(char)
        elif char == ']':
            if len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            else:
                return False
        elif char == ')':
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                return False
    return not stack


main()
