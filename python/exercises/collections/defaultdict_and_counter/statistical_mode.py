'''
Find the mode (most common value)
'''

from collections import Counter

# line = '1 7 3 3 8 9 10 5 5 5 4 1 5 6'
# line = 'red green yellow red orange blue purple'
line = input()

words = line.split()
freq_counter = Counter(words)

print(freq_counter.most_common(1)[0][0])
