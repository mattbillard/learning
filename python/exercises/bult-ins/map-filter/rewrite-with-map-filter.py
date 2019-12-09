even = [0, 2, 4, 6, 8]
odd = [1, 3, 5, 7, 9]

# Non-functional code

length = len(even)

my_sum = []
i = 0
while i < length:
    my_sum.append(even[i] + odd[i])
    i = i + 1

remainders = [x % 3 for x in my_sum]

nonzero_remainders = [r for r in remainders if r]


# Rewritten with map, filter

my_sum = list(map(lambda e, o: e + o, even, odd))
remainders = list(map(lambda x: x % 3, my_sum))
nonzero_remainders = list(filter(lambda x: x != 0, remainders))

print(nonzero_remainders)
