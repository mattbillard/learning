text = 'First ladies rule the State and state the rule: ladies first'
# text = input()

arr = [word for word in text.split() if word.endswith('s')]
result = '_'.join(arr)

print(result)
