'''
If triangle is right triangle, output area

Sample Input 1:
5 3 4

Sample Output 1:
6.0

Sample Input 2:
4 3 2

Sample Output 2:
Not right
'''


class RightTriangle:
    def __init__(self, hyp, leg_1, leg_2):
        self.c = hyp
        self.a = leg_1
        self.b = leg_2

        a = self.a
        b = self.b
        c = self.c

        if c*c == a*a + b*b:
            area = 0.5 * a * b
            print(round(area, 1))
        else:
            print('Not right')


hyp, l1, l2 = list(map(lambda x: float(x), input().split()))

RightTriangle(hyp, l1, l2)
