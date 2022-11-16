# a)Implementation using a regular function using loops and parallel assignments
def lucas_seq(seq):
    q = []
    if seq < 0:
        print("wrong input...")
    if seq == 1:
        print("[2]")
    if seq >= 1:
        q.append(2)
    if seq >= 2:
        q.append(1)
        a = 2
        b = 1
        for _ in range(2, seq):
            temp = a+b
            a = b
            b = temp
            q.append(temp)
        return q


seq = int(input("Enter the value of n to print the lucas sequence: "))
print(lucas_seq(seq))

# b) Implementation using a generator function.

seq_gen = int(input("\nEnter the value of n to print the lucas sequence(using the generator function): "))


def lucas_seq_gen(seq_gen):
    if seq_gen < 0:
        print("wrong input...")
    else:
        x, y = 2, 1
        for _ in range(seq_gen):
            yield x
            x, y = y, x + y


print(list(lucas_seq_gen(seq_gen)))
