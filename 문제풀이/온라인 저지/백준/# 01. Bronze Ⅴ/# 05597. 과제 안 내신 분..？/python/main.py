import io, os

input_all = io.BytesIO(os.read(0, os.fstat(0).st_size)).read

students = {str(i) for i in range(1, 30 + 1)} - set(input_all().decode().split())
answer = '\n'.join(sorted(students, key=lambda x: int(x)))
print(answer, end='')
