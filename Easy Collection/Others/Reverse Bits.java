/*
Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++){
            result <<= 1; // shift reslut to left by 1 bit, we only need 31 shifts. so shift with 0 is fine
            result += n&1; //get last bit of n, bitwise and for last bit
            n >>= 1; // shift n to right by 1 bit
        }
        return result;
    }
}