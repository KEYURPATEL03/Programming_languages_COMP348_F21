from collections import Counter

class Multiset:
    s=[1, 2, 3]

    def init(self, se):
        self.s=se

    def add(self, a):
        self.s.append(a)
        self.s.sort()

    def remove(self, value):
        self.s = [i for i in self.s if i != value]

    def m(self, value):
        return self.s.count(value)

    def union(self, newList):
        return list((Counter(self.se) | Counter(newList)).elements())

    def intersection(self, newList):
        return list((Counter(self.se) & Counter(newList)).elements())

    def difference(self, newList):
        return list((Counter(self.se) - Counter(newList)).elements())

    def gets(self):
        return self.s


m = Multiset()