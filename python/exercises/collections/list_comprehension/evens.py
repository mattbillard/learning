# string = input()
string = '8 11'

evens = [int(x) for x in string.split() if int(x) % 2 == 0]
print(evens)
