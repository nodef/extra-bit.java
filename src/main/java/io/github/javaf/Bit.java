package io.github.javaf;




/**
 * The bit is a basic unit of information in information theory, computing.
 * This package includes bit twiddling hacks by Sean Eron Anderson and many
 * others.<br>
 * 📦 <a href="https://search.maven.org/artifact/io.github.javaf/extra-bit">Central</a>,
 * 📜 <a href="https://repo1.maven.org/maven2/io/github/javaf/extra-bit/">Releases</a>,
 * 😺 <a href="https://github.com/javaf/hello-world/packages/575247">GitHub</a>,
 * 🐸 <a href="https://bintray.com/beta/#/bintray/jcenter/io.github.javaf:extra-bit">Bintray</a>,
 * 🦚 <a href="https://mvnrepository.com/artifact/io.github.javaf/extra-bit">MvnRepository</a>,
 * 📰 <a href="https://javaf.github.io/extra-bit/">Javadoc</a>,
 * 📘 <a href="https://github.com/javaf/extra-bit/wiki">Wiki</a>.
 */
public final class Bit {

  // CONSTANTS
  private static final int[] DEBRUIJN_POS32 = {
    0,  9,  1, 10, 13, 21,  2, 29, 11, 14, 16, 18, 22, 25,  3, 30,
    8, 12, 20, 28, 15, 17, 24,  7, 19, 27, 23,  6, 26,  5,  4, 31
  };

  private static final int[] MOD37_POS32 = {
    32, 0, 1, 26, 2, 23, 27, 0, 3, 16, 24, 30, 28, 11, 0, 13, 4, 7, 17, 0,
    25, 22, 31, 15, 29, 10, 12, 6, 0, 21, 14, 9, 5, 20, 8, 19, 18
  };




  // GET*, SET*, TOGGLE*, SWAP
  /**
   * Get a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/get">📘</a>
   * @param x an int
   * @param i bit index
   * @return bit
   *<pre>{@code
   *get(6, 0) == 0  // 110,0 ⇒ 0
   *get(6, 1) == 1  // 110,1 ⇒ 1
   *get(6, 2) == 1  // 110,2 ⇒ 1
   *}</pre>
   */
  public static int get(int x, int i) {
    return (x>>>i) & 1;
  }

  /**
   * Get a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/get">📘</a>
   * @param x a long
   * @param i bit index
   * @return bit
   *<pre>{@code
   *get(6, 0) == 0  // 110,0 ⇒ 0
   *get(6, 1) == 1  // 110,1 ⇒ 1
   *get(6, 2) == 1  // 110,2 ⇒ 1
   *}</pre>
   */
  public static int get(long x, int i) {
    return (int) (x>>>i) & 1;
  }



  /**
   * Get bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/getAs">📘</a>
   * @param x an int
   * @param m bit mask
   * @return bits
   *<pre>{@code
   *getAs(6, 4) == 4  // 110,100 ⇒ 100
   *getAs(6, 7) == 6  // 110,111 ⇒ 110
   *getAs(6, 5) == 4  // 110,101 ⇒ 100
   *}</pre>
   */
  public static int getAs(int x, int m) {
    return x & m;
  }

  /**
   * Get bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/getAs">📘</a>
   * @param x a long
   * @param m bit mask
   * @return bits
   *<pre>{@code
   *getAs(6, 4) == 4  // 110,100 ⇒ 100
   *getAs(6, 7) == 6  // 110,111 ⇒ 110
   *getAs(6, 5) == 4  // 110,101 ⇒ 100
   *}</pre>
   */
  public static long getAs(long x, long m) {
    return x & m;
  }



  /**
   * Set a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/set">📘</a>
   * @param x an int
   * @param i bit index
   * @param f bit value (1)
   * @return set int
   *<pre>{@code
   *set(6, 0, 1) == 7  // 110,0,1 ⇒ 111
   *set(6, 2, 1) == 6  // 110,2,1 ⇒ 110
   *set(6, 2, 0) == 2  // 110,2,0 ⇒ 010
   *}</pre>
   */
  public static int set(int x, int i, int f) {
    return (x & ~(1<<i)) | (f<<i);
  }

  /**
   * Set a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/set">📘</a>
   * @param x a long
   * @param i bit index
   * @param f bit value (1)
   * @return set long
   *<pre>{@code
   *set(6, 0, 1) == 7  // 110,0,1 ⇒ 111
   *set(6, 2, 1) == 6  // 110,2,1 ⇒ 110
   *set(6, 2, 0) == 2  // 110,2,0 ⇒ 010
   *}</pre>
   */
  public static long set(long x, int i, int f) {
    return (x & ~(1<<i)) | ((long) f<<i);
  }



  /**
   * Set bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/setAs">📘</a>
   * @param x an int
   * @param m bit mask
   * @param f bit value (1)
   * @return set int
   *<pre>{@code
   *setAs(8, 2, 1)          == 10    // 0x8 set 0x2      ⇒ 0xA
   *setAs(15, 3, 0)         == 12    // 0xF clear 0x3    ⇒ 0xC
   *setAs(0x1234, 0x430, 1) == 5684  // 0x1234 set 0x430 ⇒ 0x1634
   *}</pre>
   */
  public static int setAs(int x, int m, int f) {
    return (x & ~m) | (-f & m);
  }

  /**
   * Set bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/setAs">📘</a>
   * @param x a long
   * @param m bit mask
   * @param f bit value (1)
   * @return set long
   *<pre>{@code
   *setAs(8, 2, 1)          == 10    // 0x8 set 0x2      ⇒ 0xA
   *setAs(15, 3, 0)         == 12    // 0xF clear 0x3    ⇒ 0xC
   *setAs(0x1234, 0x430, 1) == 5684  // 0x1234 set 0x430 ⇒ 0x1634
   *}</pre>
   */
  public static long setAs(long x, long m, int f) {
    return (x & ~m) | ((long) -f & m);
  }



  /**
   * Toggle a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/toggle">📘</a>
   * @param x an int
   * @param i bit index
   * @return toggled int
   *<pre>{@code
   *toggle(6, 0) == 7  // 110,0 ⇒ 111
   *toggle(6, 1) == 4  // 110,1 ⇒ 100
   *toggle(6, 2) == 2  // 110,2 ⇒ 010
   *}</pre>
   */
  public static int toggle(int x, int i) {
    return x ^ (1<<i);
  }

  /**
   * Toggle a bit.
   * <a href="https://github.com/javaf/extra-bit/wiki/toggle">📘</a>
   * @param x a long
   * @param i bit index
   * @return toggled long
   *<pre>{@code
   *toggle(6, 0) == 7  // 110,0 ⇒ 111
   *toggle(6, 1) == 4  // 110,1 ⇒ 100
   *toggle(6, 2) == 2  // 110,2 ⇒ 010
   *}</pre>
   */
  public static long toggle(long x, int i) {
    return x ^ (1<<i);
  }



  /**
   * Toggle bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/toggleAs">📘</a>
   * @param x an int
   * @param m bit mask
   * @return toggled int
   *<pre>{@code
   *toggleAs(6, 1) == 7  // 110,000 ⇒ 111
   *toggleAs(6, 7) == 1  // 110,111 ⇒ 001
   *toggleAs(6, 3) == 5  // 110,011 ⇒ 101
   *}</pre>
   */
  public static int toggleAs(int x, int m) {
    return x ^ m;
  }

  /**
   * Toggle bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/toggleAs">📘</a>
   * @param x a long
   * @param m bit mask
   * @return toggled long
   *<pre>{@code
   *toggleAs(6, 1) == 7  // 110,000 ⇒ 111
   *toggleAs(6, 7) == 1  // 110,111 ⇒ 001
   *toggleAs(6, 3) == 5  // 110,011 ⇒ 101
   *}</pre>
   */
  public static long toggleAs(long x, long m) {
    return x ^ m;
  }



  /**
   * Swap bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/swap">📘</a>
   * @param x an int
   * @param i first bit index
   * @param j second bit index
   * @return swapped int
   *<pre>{@code
   *swap(6, 1, 0, 1)      == 5      // 110    ⇒ 101
   *swap(0x1234, 8, 4, 4) == 4900   // 0x1234 ⇒ 0x1324
   *swap(0x4AAB, 8, 0, 8) == 43850  // 0x4AAB ⇒ 0xAB4A
   *}</pre>
   */
  public static int swap(int x, int i, int j) {
    int t = ((x>>>i)^(x>>>j)) & 1;
    return x ^ ((t<<i)|(t<<j));
  }

  /**
   * Swap bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/swap">📘</a>
   * @param x a long
   * @param i first bit index
   * @param j second bit index
   * @return swapped long
   *<pre>{@code
   *swap(6, 1, 0, 1)      == 5      // 110    ⇒ 101
   *swap(0x1234, 8, 4, 4) == 4900   // 0x1234 ⇒ 0x1324
   *swap(0x4AAB, 8, 0, 8) == 43850  // 0x4AAB ⇒ 0xAB4A
   *}</pre>
   */
  public static long swap(long x, int i, int j) {
    long t = ((x>>>i)^(x>>>j)) & 1;
    return x ^ ((t<<i)|(t<<j));
  }

  /**
   * Swap bit sequences.
   * <a href="https://github.com/javaf/extra-bit/wiki/swap">📘</a>
   * @param x an int
   * @param i first bit index
   * @param j second bit index
   * @param n bit width (1)
   * @return swapped int
   *<pre>{@code
   *swap(6, 1, 0, 1)      == 5      // 110    ⇒ 101
   *swap(0x1234, 8, 4, 4) == 4900   // 0x1234 ⇒ 0x1324
   *swap(0x4AAB, 8, 0, 8) == 43850  // 0x4AAB ⇒ 0xAB4A
   *}</pre>
   */
  public static int swap(int x, int i, int j, int n) {
    int t = ((x>>>i)^(x>>>j)) & ((1<<n)-1);
    return x ^ ((t<<i)|(t<<j));
  }

  /**
   * Swap bit sequences.
   * <a href="https://github.com/javaf/extra-bit/wiki/swap">📘</a>
   * @param x a long
   * @param i first bit index
   * @param j second bit index
   * @param n bit width (1)
   * @return swapped long
   *<pre>{@code
   *swap(6, 1, 0, 1)      == 5      // 110    ⇒ 101
   *swap(0x1234, 8, 4, 4) == 4900   // 0x1234 ⇒ 0x1324
   *swap(0x4AAB, 8, 0, 8) == 43850  // 0x4AAB ⇒ 0xAB4A
   *}</pre>
   */
  public static long swap(long x, int i, int j, int n) {
    long t = ((x>>>i)^(x>>>j)) & ((1L<<n)-1L);
    return x ^ ((t<<i)|(t<<j));
  }




  // COUNT, PARITY, SCAN*
  /**
   * Count bits set.
   * <a href="https://github.com/javaf/extra-bit/wiki/count">📘</a>
   * @param x an int
   * @return count
   *<pre>{@code
   *count(7)  == 3  // 111    ⇒ 3
   *count(12) == 2  // 1100   ⇒ 2
   *count(63) == 6  // 111111 ⇒ 6
   *}</pre>
   */
  public static int count(int x) {
    x = x - ((x>>>1) & 0x55555555);
    x = (x & 0x33333333) + ((x>>>2) & 0x33333333);
    return ((x + (x>>>4) & 0x0F0F0F0F) * 0x01010101)>>>24;
  }

  /**
   * Count bits set.
   * <a href="https://github.com/javaf/extra-bit/wiki/count">📘</a>
   * @param x a long
   * @return count
   *<pre>{@code
   *count(7)  == 3  // 111    ⇒ 3
   *count(12) == 2  // 1100   ⇒ 2
   *count(63) == 6  // 111111 ⇒ 6
   *}</pre>
   */
  public static int count(long x) {
    x = x - ((x>>>1) & 0x5555555555555555L);
    x = (x & 0x3333333333333333L) + ((x>>>2) & 0x3333333333333333L);
    x = ((x + (x>>>4) & 0x0F0F0F0F0F0F0F0FL) * 0x0101010101010101L)>>>56;
    return (int) x;
  }



  /**
   * Get 1-bit parity.
   * <a href="https://github.com/javaf/extra-bit/wiki/parity">📘</a>
   * @param x an int
   * @return parity
   *<pre>{@code
   *parity(7, 1)  == 1   // 1,1,1   ⇒ 1
   *parity(5, 1)  == 0   // 1,0,1   ⇒ 0
   *parity(8, 2)  == 2   // 10,00   ⇒ 10
   *parity(63, 4) == 12  // 11,1111 ⇒ 1100
   *}</pre>
   */
  public static int parity(int x) {
    x ^= x>>>16;
    x ^= x>>>8;
    x ^= x>>>4;
    x &= 0xF;
    return (0x6996>>>x) & 1;
  }

  /**
   * Get 1-bit parity.
   * <a href="https://github.com/javaf/extra-bit/wiki/parity">📘</a>
   * @param x a long
   * @return parity
   *<pre>{@code
   *parity(7, 1)  == 1   // 1,1,1   ⇒ 1
   *parity(5, 1)  == 0   // 1,0,1   ⇒ 0
   *parity(8, 2)  == 2   // 10,00   ⇒ 10
   *parity(63, 4) == 12  // 11,1111 ⇒ 1100
   *}</pre>
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
   * Get n-bit parity.
   * <a href="https://github.com/javaf/extra-bit/wiki/parity">📘</a>
   * @param x an int
   * @param n number of bits (1)
   * @return parity
   *<pre>{@code
   *parity(7, 1)  == 1   // 1,1,1   ⇒ 1
   *parity(5, 1)  == 0   // 1,0,1   ⇒ 0
   *parity(8, 2)  == 2   // 10,00   ⇒ 10
   *parity(63, 4) == 12  // 11,1111 ⇒ 1100
   *}</pre>
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
   * Get n-bit parity.
   * <a href="https://github.com/javaf/extra-bit/wiki/parity">📘</a>
   * @param x an int
   * @param n number of bits (1)
   * @return parity
   *<pre>{@code
   *parity(7, 1)  == 1   // 1,1,1   ⇒ 1
   *parity(5, 1)  == 0   // 1,0,1   ⇒ 0
   *parity(8, 2)  == 2   // 10,00   ⇒ 10
   *parity(63, 4) == 12  // 11,1111 ⇒ 1100
   *}</pre>
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
   * Get index of first set bit from LSB.
   * <a href="https://github.com/javaf/extra-bit/wiki/scan">📘</a>
   * @param x an int
   * @return bit index
   *<pre>{@code
   *scan(7)  == 0  // 111     ⇒ 0
   *scan(12) == 2  // 1100    ⇒ 2
   *scan(64) == 6  // 1000000 ⇒ 6
   *}</pre>
   */
  public static int scan(int x) {
    return MOD37_POS32[(-x & x) % 37];
  }

  /**
   * Get index of first set bit from LSB.
   * <a href="https://github.com/javaf/extra-bit/wiki/scan">📘</a>
   * @param x a long
   * @return bit index
   *<pre>{@code
   *scan(7)  == 0  // 111     ⇒ 0
   *scan(12) == 2  // 1100    ⇒ 2
   *scan(64) == 6  // 1000000 ⇒ 6
   *}</pre>
   */
  public static int scan(long x) {
    int a = scan((int)(x & 0xFFFFFFFFL));
    int b = scan((int)(x>>>32));
    return a==32? b+32 : a;
  }



  /**
   * Get index of first set bit from MSB.
   * <a href="https://github.com/javaf/extra-bit/wiki/scanReverse">📘</a>
   * @param x an int32
   * @return bit index
   *<pre>{@code
   *scanReverse(13) == 3  // 1101 ⇒ 3
   *scanReverse(5)  == 2  // 101  ⇒ 2
   *scanReverse(1)  == 0  // 1    ⇒ 0
   *}</pre>
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
   * Get index of first set bit from LSB.
   * <a href="https://github.com/javaf/extra-bit/wiki/scanReverse">📘</a>
   * @param x a long
   * @return bit index
   *<pre>{@code
   *scanReverse(13) == 3  // 1101 ⇒ 3
   *scanReverse(5)  == 2  // 101  ⇒ 2
   *scanReverse(1)  == 0  // 1    ⇒ 0
   *}</pre>
   */
  public static int scanReverse(long x) {
    int a = scanReverse((int)(x & 0xFFFFFFFFL));
    int b = scanReverse((int)(x>>>32));
    return a==32? b+32 : a;
  }




  // MERGE, INTERLEAVE, ROTATE, REVERSE, SIGNEXTEND
  /**
   * Merge bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/merge">📘</a>
   * @param x first int
   * @param y second int
   * @param m bit mask (0 ⇒ from x)
   * @return merged int
   *<pre>{@code
   *merge(0x12, 0x24, 0x0F)       == 20     // 0x14
   *merge(0x1234, 0xABCD, 0x0F0F) == 6973   // 0x1B3D
   *merge(0xAAAA, 0xBBBB, 0x3333) == 48059  // 0xBBBB
   *}</pre>
   */
  public static int merge(int x, int y, int m) {
    return x ^ ((x^y) & m);
  }

  /**
   * Merge bits as per mask.
   * <a href="https://github.com/javaf/extra-bit/wiki/merge">📘</a>
   * @param x first long
   * @param y second long
   * @param m bit mask (0 ⇒ from x)
   * @return merged long
   *<pre>{@code
   *merge(0x12, 0x24, 0x0F)       == 20     // 0x14
   *merge(0x1234, 0xABCD, 0x0F0F) == 6973   // 0x1B3D
   *merge(0xAAAA, 0xBBBB, 0x3333) == 48059  // 0xBBBB
   *}</pre>
   */
  public static long merge(long x, long y, long m) {
    return x ^ ((x^y) & m);
  }



  /**
   * Interleave bits of two shorts.
   * <a href="https://github.com/javaf/extra-bit/wiki/interleave">📘</a>
   * @param x first short
   * @param y second short
   * @return int
   *<pre>{@code
   *interleave(0x0000, 0xFFFF) == 1431655765  // 0x55555555
   *interleave(0x1234, 0x1234) == 51121968    // 0x030C0F30
   *interleave(0x1234, 0x4321) == 302845473   // 0x120D0E21
   *}</pre>
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
   * Interleave bits of two ints.
   * <a href="https://github.com/javaf/extra-bit/wiki/interleave">📘</a>
   * @param x first int
   * @param y second int
   * @return interleaved long
   *<pre>{@code
   *interleave(0x0000, 0xFFFF) == 1431655765  // 0x55555555
   *interleave(0x1234, 0x1234) == 51121968    // 0x030C0F30
   *interleave(0x1234, 0x4321) == 302845473   // 0x120D0E21
   *}</pre>
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
   * Rotate bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/rotate">📘</a>
   * @param x an int
   * @param n rotate amount (+ve: left, -ve: right)
   * @return rotated int
   *<pre>{@code
   *rotate(0x11112222, 4)  == 286401057  // 0x11122221
   *rotate(0x11112222, -4) == 554766882  // 0x21111222
   *}</pre>
   */
  public static int rotate(int x, int n) {
    return n<0? x<<32+n | x>>>-n : x<<n | x>>32-n;
  }

  /**
   * Rotate bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/rotate">📘</a>
   * @param x a long
   * @param n rotate amount (+ve: left, -ve: right)
   * @return rotated long
   *<pre>{@code
   *rotate(0x11112222, 4)  == 286401057  // 0x11122221
   *rotate(0x11112222, -4) == 554766882  // 0x21111222
   *}</pre>
   */
  public static long rotate(long x, int n) {
    return n<0? x<<64+n | x>>>-n : x<<n | x>>64-n;
  }



  /**
   * Reverse all bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/reverse">📘</a>
   * @param x an int
   * @return reversed int
   *<pre>{@code
   *reverse(0xFFFF0000) == 65535      // 0x0000FFFF
   *reverse(0x00AABBCC) == 870143232  // 0x33DD5500
   *reverse(0x1234)     == 742916096  // 0x2C480000
   *}</pre>
   */
  public static int reverse(int x) {
    x = ((x>>>1) & 0x55555555) | ((x & 0x55555555)<<1);
    x = ((x>>>2) & 0x33333333) | ((x & 0x33333333)<<2);
    x = ((x>>>4) & 0x0F0F0F0F) | ((x & 0x0F0F0F0F)<<4);
    x = ((x>>>8) & 0x00FF00FF) | ((x & 0x00FF00FF)<<8);
    return (x>>>16) | (x<<16);
  }

  /**
   * Reverse all bits.
   * <a href="https://github.com/javaf/extra-bit/wiki/reverse">📘</a>
   * @param x a long
   * @return reversed long
   *<pre>{@code
   *reverse(0xFFFF0000) == 65535      // 0x0000FFFF
   *reverse(0x00AABBCC) == 870143232  // 0x33DD5500
   *reverse(0x1234)     == 742916096  // 0x2C480000
   *}</pre>
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
   * Sign extend variable bit-width integer.
   * <a href="https://github.com/javaf/extra-bit/wiki/signExtend">📘</a>
   * @param x variable bit-width int
   * @param w bit width (32)
   * @return sign-extended int
   *<pre>{@code
   *signExtend(15, 4) == -1  // 1111 ⇒ -1
   *signExtend(3, 3)  == 3   // 011  ⇒ 3
   *signExtend(4, 3)  == -4  // 100  ⇒ -4
   *}</pre>
   */
  public static int signExtend(int x, int w) {
    w = 32-w;
    return (x<<w)>>w;
  }

  /**
   * Sign extend variable bit-width integer.
   * <a href="https://github.com/javaf/extra-bit/wiki/signExtend">📘</a>
   * @param x variable bit-width long
   * @param w bit width (64)
   * @return sign-extended long
   *<pre>{@code
   *signExtend(15, 4) == -1  // 1111 ⇒ -1
   *signExtend(3, 3)  == 3   // 011  ⇒ 3
   *signExtend(4, 3)  == -4  // 100  ⇒ -4
   *}</pre>
   */
  public static long signExtend(long x, int w) {
    w = 64-w;
    return (x<<w)>>w;
  }
}
