import sys

def solve(S):

    # i really hate single letter variables. but am trying to conform to algorithm style

    N = len(S)
    T = sum(S)

    if T % 2 == 1:
        return False

    T = T // 2

    # opt initialization.
    # first row is all True since it indicates 0 sum subsequence which is trivial.
    # rest are False by default.
    opt = [
        [True if row == 0 else False for column in range(0, N + 1)] 
        for row
        in range(0, T + 1)]

    for row in range(1, T + 1):
        for col in range(1, N + 1):
            # the core invokation: core[i, j]
            opt[row][col] = opt[row][col - 1] or opt[row - S[col - 1]][col - 1]

    return opt[T][N]


def main():
    partitionable = solve([int(value) for value in sys.argv[1:]])
    print("The set is partitionable" if partitionable else "The set is NOT partitionable") 
    
if __name__ == '__main__':
    main()
