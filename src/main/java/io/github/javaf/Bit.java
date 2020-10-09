package io.github.javaf;

/**
 * The bit is a basic unit of information in information theory, computing.
 * This package includes bit twiddling hacks by Sean Eron Anderson and many
 * others.
 */
public final class Bit {
  private static final int[] DEBRUIJN_POS32 = {
    0,  9,  1, 10, 13, 21,  2, 29, 11, 14, 16, 18, 22, 25,  3, 30, 
    8, 12, 20, 28, 15, 17, 24,  7, 19, 27, 23,  6, 26,  5,  4, 31
  };
  
  private static final int[] MOD37_POS32 = {
    32, 0, 1, 26, 2, 23, 27, 0, 3, 16, 24, 30, 28, 11, 0, 13, 4, 7, 17, 0,
    25, 22, 31, 15, 29, 10, 12, 6, 0, 21, 14, 9, 5, 20, 8, 19, 18
  };

  
  /**
   * Counts bits set.
   * @param x an int
   * @return count
   */
  public static int count(int x) {
    x = x - ((x>>>1) & 0x55555555);
    x = (x & 0x33333333) + ((x>>>2) & 0x33333333);
    return ((x + (x>>>4) & 0x0F0F0F0F) * 0x01010101)>>>24;
  }

  /**
   * Counts bits set.
   * @param x a long
   * @return count
   */
  public static int count(long x) {
    x = x - ((x>>>1) & 0x5555555555555555L);
    x = (x & 0x3333333333333333L) + ((x>>>2) & 0x3333333333333333L);
    x = ((x + (x>>>4) & 0x0F0F0F0F0F0F0F0FL) * 0x0101010101010101L)>>>56;
    return (int) x;
  }


  /**
   * Gets a bit.
   * @param x an int
   * @param i bit index
   * @return bit
   */
  public static int get(int x, int i) {
    return (x>>>i) & 1;
  }

  /**
   * Gets a bit.
   * @param x a long
   * @param i bit index
   * @return bit
   */
  public static int get(long x, int i) {
    return (int) (x>>>i) & 1;
  }


  /**
   * Gets bits as per mask.
   * @param x an int
   * @param m bit mask
   * @return bits
   */
  public static int getAs(int x, int m) {
    return x & m;
  }

  /**
   * Gets bits as per mask.
   * @param x a long
   * @param m bit mask
   * @return bits
   */
  public static long getAs(long x, long m) {
    return x & m;
  }
  

  /**
   * Interleaves bits of two shorts.
   * @param x first short
   * @param y second short
   * @return int
   */
  public static int interleave(int x, int y) {
    x = (x | (x<<8)) & 0x00FF00FF;
    x = (x | (x<<4)) & 0x0F0F0F0F;
    x = (x | (x<<2)) & 0x33333333;
    x = (x | (x<<1)) & 0x55555555;
    y = (y | (y<<8)) & 0x00FF00FF;
    y = (y | (y<<4)) & 0x0F0F0F0F;
    y = (y | (y<<2)) & 0x33333333;
    y = (y | (y<<1)) & 0x55555555;
    return y | (x<<1);
  }
  
  /**
   * Interleaves bits of two ints.
   * @param x first int
   * @param y second int
   * @return interleaved long
   */
  public static long interleave(long x, long y) {
    x = (x | (x<<16)) & 0x0000FFFF0000FFFFL;
    x = (x | (x<<8)) & 0x00FF00FF00FF00FFL;
    x = (x | (x<<4)) & 0x0F0F0F0F0F0F0F0FL;
    x = (x | (x<<2)) & 0x3333333333333333L;
    x = (x | (x<<1)) & 0x5555555555555555L;
    y = (y | (y<<16)) & 0x0000FFFF0000FFFFL;
    y = (y | (y<<8)) & 0x00FF00FF00FF00FFL;
    y = (y | (y<<4)) & 0x0F0F0F0F0F0F0F0FL;
    y = (y | (y<<2)) & 0x3333333333333333L;
    y = (y | (y<<1)) & 0x5555555555555555L;
    return y | (x<<1);
  }
  

  /**
   * Merges bits as per mask.
   * @param x first int
   * @param y second int
   * @param m bit mask (0 => from x)
   * @return merged int
   */
  public static int merge(int x, int y, int m) {
    return x ^ ((x^y) & m);
  }

  /**
   * Merges bits as per mask.
   * @param x first long
   * @param y second long
   * @param m bit mask (0 => from x)
   * @return merged long
   */
  public static long merge(long x, long y, long m) {
    return x ^ ((x^y) & m);
  }


  /**
   * Gets 1-bit parity.
   * @param x an int
   * @return parity
   */
  public static int parity(int x) {
    x ^= x>>>16;
    x ^= x>>>8;
    x ^= x>>>4;
    x &= 0xF;
    return (0x6996>>>x) & 1;
  }
  
  /**
   * Gets 1-bit parity.
   * @param x a long
   * @return parity
   */
  public static int parity(long x) {
    x ^= x>>>32;
    x ^= x>>>16;
    x ^= x>>>8;
    x ^= x>>>4;
    x &= 0xF;
    return (0x6996>>>x) & 1;
  }

  /**
   * Gets n-bit parity.
   * @param x an int
   * @param n number of bits (1)
   * @return parity
   */
  public static int parity(int x, int n) {
    if (n == 1) return parity(x);
    int m = (1<<n) - 1, a = 0;
    while (x!=0) {
      a ^= x & m;
      x >>>= n;
    }
    return a;
  }
  
  /**
   * Gets n-bit parity.
   * @param x an int
   * @param n number of bits (1)
   * @return parity
   */
  public static int parity(long x, int n) {
    if (n == 1) return parity(x);
    long m = (1<<n) - 1, a = 0;
    while (x!=0) {
      a ^= x & m;
      x >>>= n;
    }
    return (int) a;
  }

  
  /**
   * Reverses all bits.
   * @param x an int
   * @return reversed int
   */
  public static int reverse(int x) {
    x = ((x>>>1) & 0x55555555) | ((x & 0x55555555)<<1);
    x = ((x>>>2) & 0x33333333) | ((x & 0x33333333)<<2);
    x = ((x>>>4) & 0x0F0F0F0F) | ((x & 0x0F0F0F0F)<<4);
    x = ((x>>>8) & 0x00FF00FF) | ((x & 0x00FF00FF)<<8);
    return (x>>>16) | (x<<16);
  }
  
  /**
   * Reverses all bits.
   * @param x a long
   * @return reversed long
   */
  public static long reverse(long x) {
    x = ((x>>>1) & 0x5555555555555555L) | ((x & 0x5555555555555555L)<<1);
    x = ((x>>>2) & 0x3333333333333333L) | ((x & 0x3333333333333333L)<<2);
    x = ((x>>>4) & 0x0F0F0F0F0F0F0F0FL) | ((x & 0x0F0F0F0F0F0F0F0FL)<<4);
    x = ((x>>>8) & 0x00FF00FF00FF00FFL) | ((x & 0x00FF00FF00FF00FFL)<<8);
    x = ((x>>>16) & 0x0000FFFF0000FFFFL) | ((x & 0x0000FFFF0000FFFFL)<<16);
    return (x>>>32) | (x<<32);
  }
  
  
  /**
   * Rotates bits.
   * @param x an int
   * @param n rotate amount (+ve: left, -ve: right)
   * @return rotated int
   */
  public static int rotate(int x, int n) {
    return n<0? x<<32+n | x>>>-n : x<<n | x>>32-n;
  }

  /**
   * Rotates bits.
   * @param x a long
   * @param n rotate amount (+ve: left, -ve: right)
   * @return rotated long
   */
  public static long rotate(long x, int n) {
    return n<0? x<<64+n | x>>>-n : x<<n | x>>64-n;
  }


  /**
   * Gets index of first set bit from LSB.
   * @param x an int
   * @return bit index
   */
  public static int scan(int x) {
    return MOD37_POS32[(-x & x) % 37];
  }
  
  /**
   * Gets index of first set bit from LSB.
   * @param x a long
   * @return bit index
   */
  public static int scan(long x) {
    int a = scan((int)(x & 0xFFFFFFFFL));
    int b = scan((int)(x>>>32));
    return a==32? b+32 : a;
  }
  

  /**
   * Gets index of first set bit from MSB.
   * @param x an int32
   * @return bit index
   */
  public static int scanReverse(int x) {
    x |= x>>>1;
    x |= x>>>2;
    x |= x>>>4;
    x |= x>>>8;
    x |= x>>>16;
    return DEBRUIJN_POS32[(x*0x07C4ACDD)>>>27];
  }
  
  /**
   * Gets index of first set bit from LSB.
   * @param x a long
   * @return bit index
   */
  public static int scanReverse(long x) {
    int a = scanReverse((int)(x & 0xFFFFFFFFL));
    int b = scanReverse((int)(x>>>32));
    return a==32? b+32 : a;
  }
  

  /**
   * Sets a bit.
   * @param x an int
   * @param i bit index
   * @param f bit value (1)
   * @return set int
   */
  public static int set(int x, int i, int f) {
    return (x & ~(1<<i)) | (f<<i);
  }

  /**
   * Sets a bit.
   * @param x a long
   * @param i bit index
   * @param f bit value (1)
   * @return set long
   */
  public static long set(long x, int i, int f) {
    return (x & ~(1<<i)) | ((long) f<<i);
  }


  /**
   * Sets bits as per mask.
   * @param x an int
   * @param m bit mask
   * @param f bit value (1)
   * @return set int
   */
  public static int setAs(int x, int m, int f) {
    return (x & ~m) | (-f & m);
  }

  /**
   * Sets bits as per mask.
   * @param x a long
   * @param m bit mask
   * @param f bit value (1)
   * @return set long
   */
  public static long setAs(long x, long m, int f) {
    return (x & ~m) | ((long) -f & m);
  }

  
  /**
   * Sign extends variable bit-width integer.
   * @param x variable bit-width int
   * @param w bit width (32)
   * @return sign-extended int
   */
  public static int signExtend(int x, int w) {
    w = 32-w;
    return (x<<w)>>w;
  }
  
  /**
   * Sign extends variable bit-width integer.
   * @param x variable bit-width long
   * @param w bit width (64)
   * @return sign-extended long
   */
  public static long signExtend(long x, int w) {
    w = 64-w;
    return (x<<w)>>w;
  }
  
  
  /**
   * Swaps bit sequences.
   * @param x an int
   * @param i first bit index
   * @param j second bit index
   * @param n bit width (1)
   * @return swapped int
   */
  public static int swap(int x, int i, int j, int n) {
      int t = ((x>>>i)^(x>>>j)) & ((1<<n)-1);
      return x ^ ((t<<i)|(t<<j));
  }
  
  /**
   * Swaps bit sequences.
   * @param x a long
   * @param i first bit index
   * @param j second bit index
   * @param n bit width (1)
   * @return swapped long
   */
  public static long swap(long x, int i, int j, int n) {
      long t = ((x>>>i)^(x>>>j)) & ((1L<<n)-1L);
      return x ^ ((t<<i)|(t<<j));
  }
  
  
  /**
   * Toggles a bit.
   * @param x an int
   * @param i bit index
   * @return toggled int
   */
  public static int toggle(int x, int i) {
    return x ^ (1<<i);
  }
  
  /**
   * Toggles a bit.
   * @param x a long
   * @param i bit index
   * @return toggled long
   */
  public static long toggle(long x, int i) {
    return x ^ (1<<i);
  }
  
  
  /**
   * Toggles bits as per mask.
   * @param x an int
   * @param m bit mask
   * @return toggled int
   */
  public static int toggleAs(int x, int m) {
    return x ^ m;
  }
  
  /**
   * Toggles bits as per mask.
   * @param x a long
   * @param m bit mask
   * @return toggled long
   */
  public static long toggleAs(long x, long m) {
    return x ^ m;
  }
}
