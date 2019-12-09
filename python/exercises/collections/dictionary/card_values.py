values = { 'Jack':11, 'Queen':12, 'King':13, 'Ace':14 }
total = 0
count = 6

for i in range(count):
    card = input()
    if values.get(card) != None:
        total += values.get(card)
    else:
        total += int(card)
      
print(total/count)