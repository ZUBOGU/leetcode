/*
Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.
*/
class Solution {
    public int countPrimes(int n) {
        boolean[] list = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (list[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    list[i*j] = true;
                }
            }
        }
        return count;
    }
}