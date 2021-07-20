# Partition problem

## The problem

Given a set of natural positive numbers _S_, determine wether it can be partitioned into two subsets of equal sum.

## The solution

__Observation__ if the sum of all values in _S_ is odd, there can be no such partition.

We shall tackle this problem with a dynamic approach by defining _opt[i, j] -> bool_ to be _true_ iff the subset _S[1..j]_ of _S_ has a subset with sum _i_.

By fully constructing _opt_ we shall acquire the answer in _opt[s, n]_ where _n_ is the number of values in _S_ and _s_ is that half sum of values in _S_.

The construction of _opt_ is done according to the following recursive rules

1. _opt[0, j]  = true_ for all j < n. This is obvious, the empty set has sum 0
2. _opt[i, 0] = false_ for all 1 <= i <= s. This is obvious, any non-empty set will have sum greater than 0.
3. _opt[i, j] = opt[i, j-1] or opt[i - S[j-1], j-1]_. This is the core.
  - The lhs encodes the fact that once we have found a subsequence with the desired sum we can add any arbitrary value to the set and still the same subsequence is valid.
  - The rhs checks if there is a subsequence with the relevant sum excluding the last value of _S_. i.e, whether there is a subsequence of the prefix of j-1 values having the sub i-(lastvalue).

