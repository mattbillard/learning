test_dict = {"a": 43, "b": 1233, "c": 8}

items = list(test_dict.items())
minimum = items[0]
maximum = items[0]

for key, value in items
    if value < minimum[1]:
        minimum = (key, value)
    if value > maximum[1]:
        maximum = (key, value)

print('min: {}'.format(minimum[0]))
print('max: {}'.format(maximum[0]))
