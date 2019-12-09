text = '5 8 2 7 8 8 2 4'
search = '8'
# text = input()
# search = input()

arr = text.split()

matches = []
for index in range(len(arr)):
    if arr[index] == search:
        matches.append(str(index))

result = ' '.join(matches) if len(matches) > 0 else 'not found'
print(result)
