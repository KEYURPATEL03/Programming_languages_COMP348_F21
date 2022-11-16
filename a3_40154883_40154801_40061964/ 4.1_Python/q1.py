# Recursive Function Definition for lucas sequence, which receives one parameter.
def lucas(n):
    # base cases
    if n == 0:
        return 2
    elif n == 1:
        return 1
    else:
        return lucas(n-1)+lucas(n-2)  # Recursive call


# Driver Program
seq = int(input("Enter a 'n' until which you want to print the Lucas Sequence: "))

if seq <= 0:
    print("Enter a Natural number, to get an output.")
else:
    print("Lucas sequence:")

    for i in range(seq):
        if lucas(i) < seq:
            print(lucas(i))
            i += 1
