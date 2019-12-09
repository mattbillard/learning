'''
Create a program that calculates how many objects in the list object_list have the same hash value as some other element in the list. The output should be the number of those objects. If there are no matching hash values, the output should be 0.

For example, if object_list = [1, 397, 27468, -95, 1309, 397, -539874, -240767, -95, 397], the output should be 5.

Keep in mind that not every object in the list may be hashable!
'''

from collections import Counter, Hashable

object_list = [1, 397, 27468, -95, 1309, 397, -539874, -240767, -95, 397]

hashes = [x for x in object_list if isinstance(x, Hashable)]
counter = Counter(hashes)

result = 0
for hashh, count in counter.items():
    if count > 1:
        result += count

print(result)
