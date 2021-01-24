package io.github.javaf;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Writing this test sparked some ideas.
 * Don't assume size in bits.
 * Don't assume start position.
 *
 * NOTE:
 * Programming does involve a lot of finger labor!
 * Survival instinct triggered.
 */
public class BitTest {

  public BitTest() {
  }

  @BeforeAll
  public static void setUpClass() {
  }

  @AfterAll
  public static void tearDownClass() {
  }

  @BeforeEach
  public void setUp() {
  }

  @AfterEach
  public void tearDown() {
  }




  // GET*, SET*, TOGGLE*, SWAP
  @Test
  public void testGet_int() {
    System.out.println("get(x, i)");
    int a;
    a = Bit.get(6, 0);
    assertEquals(0, a);
    // 0 (110,0 => 0)

    a = Bit.get(6, 1);
    assertEquals(1, a);
    // 1 (110,1 => 1)

    a = Bit.get(6, 2);
    assertEquals(1, a);
    // 1 (110,2 => 1)
  }

  @Test
  public void testGet_long() {
    System.out.println("get(x, i)");
    int a;
    a = Bit.get(6L, 0);
    assertEquals(0, a);
    // 0 (110,0 => 0)

    a = Bit.get(6L, 1);
    assertEquals(1, a);
    // 1 (110,1 => 1)

    a = Bit.get(6L, 2);
    assertEquals(1, a);
    // 1 (110,2 => 1)
  }



  @Test
  public void testGetAs_int() {
    System.out.println("getAs(x, m)");
    int a;
    a = Bit.getAs(6, 4);
    assertEquals(4, a);
    // 4 (110,100 => 100)

    a = Bit.getAs(6, 7);
    assertEquals(6, a);
    // 6 (110,111 => 110)

    a = Bit.getAs(6, 5);
    assertEquals(4, a);
    // 4 (110,101 => 100)
  }

  @Test
  public void testGetAs_long() {
    System.out.println("getAs(x, m)");
    long a;
    a = Bit.getAs(6L, 4L);
    assertEquals(4L, a);
    // 4 (110,100 => 100)

    a = Bit.getAs(6L, 7L);
    assertEquals(6L, a);
    // 6 (110,111 => 110)

    a = Bit.getAs(6L, 5L);
    assertEquals(4L, a);
    // 4 (110,101 => 100)
  }



  @Test
  public void testSet_int() {
    System.out.println("set(x, i, f)");
    int a;
    a = Bit.set(6, 0, 1);
    assertEquals(7, a);
    // 7 (110,0,1 => 111)

    a = Bit.set(6, 2, 1);
    assertEquals(6, a);
    // 6 (110,2,1 => 110)

    a = Bit.set(6, 2, 0);
    assertEquals(2, a);
    // 2 (110,2,0 => 010)
  }

  @Test
  public void testSet_long() {
    System.out.println("set(x, i, f)");
    long a;
    a = Bit.set(6L, 0, 1);
    assertEquals(7L, a);
    // 7 (110,0,1 => 111)

    a = Bit.set(6L, 2, 1);
    assertEquals(6L, a);
    // 6 (110,2,1 => 110)

    a = Bit.set(6L, 2, 0);
    assertEquals(2L, a);
    // 2 (110,2,0 => 010)
  }



  @Test
  public void testSetAs_int() {
    System.out.println("setAs(x, m, f)");
    int a;
    a = Bit.setAs(8, 2, 1);
    assertEquals(10, a);
    // 10 (0x8 set 0x2 => 0xA)

    a = Bit.setAs(15, 3, 0);
    assertEquals(12, a);
    // 12 (0xF clear 0x3 => 0xC)

    a = Bit.setAs(0x1234, 0x430, 1);
    assertEquals(5684, a);
    // 5684 (0x1234 set 0x430 => 0x1634)
  }

  @Test
  public void testSetAs_long() {
    System.out.println("setAs(x, m, f)");
    long a;
    a = Bit.setAs(8L, 2L, 1);
    assertEquals(10L, a);
    // 10 (0x8 set 0x2 => 0xA)

    a = Bit.setAs(15L, 3L, 0);
    assertEquals(12L, a);
    // 12 (0xF clear 0x3 => 0xC)

    a = Bit.setAs(0x1234L, 0x430L, 1);
    assertEquals(5684L, a);
    // 5684 (0x1234 set 0x430 => 0x1634)
  }



  @Test
  public void testToggle_int() {
    System.out.println("toggle(x, i)");
    int a;
    a = Bit.toggle(6, 0);
    assertEquals(7, a);
    // 7 (110,0 => 111)

    a = Bit.toggle(6, 1);
    assertEquals(4, a);
    // 4 (110,1 => 100)

    a = Bit.toggle(6, 2);
    assertEquals(2, a);
    // 2 (110,2 => 010)
  }

  @Test
  public void testToggle_long() {
    System.out.println("toggle(x, i)");
    long a;
    a = Bit.toggle(6L, 0);
    assertEquals(7L, a);
    // 7 (110,0 => 111)

    a = Bit.toggle(6L, 1);
    assertEquals(4L, a);
    // 4 (110,1 => 100)

    a = Bit.toggle(6L, 2);
    assertEquals(2L, a);
    // 2 (110,2 => 010)
  }



  @Test
  public void testToggleAs_int() {
    System.out.println("toggleAs(x, m)");
    int a;
    a = Bit.toggleAs(6, 1);
    assertEquals(7, a);
    // 7 (110,001 => 111)

    a = Bit.toggleAs(6, 7);
    assertEquals(1, a);
    // 1 (110,111 => 001)

    a = Bit.toggleAs(6, 3);
    assertEquals(5, a);
    // 5 (110,011 => 101)
  }

  @Test
  public void testToggleAs_long() {
    System.out.println("toggleAs(x, m)");
    long a;
    a = Bit.toggleAs(6L, 1L);
    assertEquals(7L, a);
    // 7 (110,001 => 111)

    a = Bit.toggleAs(6L, 7L);
    assertEquals(1L, a);
    // 1 (110,111 => 001)

    a = Bit.toggleAs(6L, 3L);
    assertEquals(5L, a);
    // 5 (110,011 => 101)
  }



  @Test
  public void testSwap_int() {
    System.out.println("swap(x, i, j, n)");
    int a;
    a = Bit.swap(6, 1, 0, 1);
    assertEquals(5, a);
    // 5 (110 => 101)

    a = Bit.swap(0x1234, 8, 4, 4);
    assertEquals(4900, a);
    // 4900 (0x1234 => 0x1324)

    a = Bit.swap(0x4AAB, 8, 0, 8);
    assertEquals(43850, a);
    // 43850 (0x4AAB => 0xAB4A)
  }

  @Test
  public void testSwap_long() {
    System.out.println("swap(x, i, j, n)");
    long a;
    a = Bit.swap(6L, 1, 0, 1);
    assertEquals(5L, a);
    // 5 (110 => 101)

    a = Bit.swap(0x1234L, 8, 4, 4);
    assertEquals(4900L, a);
    // 4900 (0x1234 => 0x1324)

    a = Bit.swap(0x4AABL, 8, 0, 8);
    assertEquals(43850L, a);
    // 43850 (0x4AAB => 0xAB4A)
  }




  // COUNT, PARITY, SCAN*
  @Test
  public void testCount_int() {
    System.out.println("count(x)");
    int a;
    a = Bit.count(7);
    assertEquals(3, a);
    // 3 (111 => 3)

    a = Bit.count(12);
    assertEquals(2, a);
    // 2 (1100 => 2)

    a = Bit.count(63);
    assertEquals(6, a);
    // 6 (111111 => 6)
  }

  @Test
  public void testCount_long() {
    System.out.println("count(x)");
    int a;
    a = Bit.count(7L);
    assertEquals(3, a);
    // 3 (111 => 3)

    a = Bit.count(12L);
    assertEquals(2, a);
    // 2 (1100 => 2)

    a = Bit.count(63L);
    assertEquals(6, a);
    // 6 (111111 => 6)
  }



  @Test
  public void testParity_int() {
    System.out.println("parity(x)");
    int a;
    a = Bit.parity(7);
    assertEquals(1, a);
    // 1 (1,1,1 => 1)

    a = Bit.parity(5);
    assertEquals(0, a);
    // 0 (1,0,1 => 0)
  }

  @Test
  public void testParity_long() {
    System.out.println("parity(x)");
    int a;
    a = Bit.parity(7L);
    assertEquals(1, a);
    // 1 (1,1,1 => 1)

    a = Bit.parity(5L);
    assertEquals(0, a);
    // 0 (1,0,1 => 0)
  }

  @Test
  public void testParity_int_int() {
    System.out.println("parity(x, n)");
    int a;
    a = Bit.parity(8, 2);
    assertEquals(2, a);
    // 2 (10,00 => 10)

    a = Bit.parity(63, 4);
    assertEquals(12, a);
    // 12 (11,1111 => 1100)
  }

  @Test
  public void testParity_long_int() {
    System.out.println("parity(x, n)");
    int a;
    a = Bit.parity(8L, 2);
    assertEquals(2, a);
    // 2 (10,00 => 10)

    a = Bit.parity(63L, 4);
    assertEquals(12, a);
    // 12 (11,1111 => 1100)
  }



  @Test
  public void testScan_int() {
    System.out.println("scan(x)");
    int a;
    a = Bit.scan(7);
    assertEquals(0, a);
    // 0 (111 => 0)

    a = Bit.scan(12);
    assertEquals(2, a);
    // 2 (1100 => 2)

    a = Bit.scan(64);
    assertEquals(6, a);
    // 6 (1000000 => 6)
  }

  @Test
  public void testScan_long() {
    System.out.println("scan(x)");
    int a;
    a = Bit.scan(7L);
    assertEquals(0, a);
    // 0 (111 => 0)

    a = Bit.scan(12L);
    assertEquals(2, a);
    // 2 (1100 => 2)

    a = Bit.scan(64L);
    assertEquals(6, a);
    // 6 (1000000 => 6)
  }



  @Test
  public void testScanReverse_int() {
    System.out.println("scanReverse(x)");
    int a;
    a = Bit.scanReverse(13);
    assertEquals(3, a);
    // 3 (1101 => 3)

    a = Bit.scanReverse(5);
    assertEquals(2, a);
    // 2 (101 => 2)

    a = Bit.scanReverse(1);
    assertEquals(0, a);
    // 0 (1 => 0)
  }

  @Test
  public void testScanReverse_long() {
    System.out.println("scanReverse(x)");
    int a;
    a = Bit.scanReverse(13L);
    assertEquals(3, a);
    // 3 (1101 => 3)

    a = Bit.scanReverse(5L);
    assertEquals(2, a);
    // 2 (101 => 2)

    a = Bit.scanReverse(1L);
    assertEquals(0, a);
    // 0 (1 => 0)
  }




  // MERGE, INTERLEAVE, ROTATE, REVERSE, SIGNEXTEND
  @Test
  public void testMerge_int() {
    System.out.println("merge(x, y, m)");
    int a;
    a = Bit.merge(0x12, 0x24, 0x0F);
    assertEquals(0x14, a);
    // 20 (0x14)

    a = Bit.merge(0x1234, 0xABCD, 0x0F0F);
    assertEquals(0x1B3D, a);
    // 6973 (0x1B3D)

    a = Bit.merge(0xAAAA, 0xBBBB, 0x3333);
    assertEquals(0xBBBB, a);
    // 48059 (0xBBBB)
  }

  @Test
  public void testMerge_long() {
    System.out.println("merge(x, y, m)");
    long a;
    a = Bit.merge(0x12L, 0x24L, 0x0FL);
    assertEquals(0x14L, a);
    // 20 (0x14)

    a = Bit.merge(0x1234L, 0xABCDL, 0x0F0FL);
    assertEquals(0x1B3DL, a);
    // 6973 (0x1B3D)

    a = Bit.merge(0xAAAAL, 0xBBBBL, 0x3333L);
    assertEquals(0xBBBBL, a);
    // 48059 (0xBBBB)
  }



  @Test
  public void testInterleave_int() {
    System.out.println("interleave(x, y)");
    int a;
    a = Bit.interleave(0x0000, 0xFFFF);
    assertEquals(0x55555555, a);
    // 1431655765 (0x55555555)

    a = Bit.interleave(0x1234, 0x1234);
    assertEquals(0x030C0F30, a);
    // 51121968 (0x030C0F30)

    a = Bit.interleave(0x1234, 0x4321);
    assertEquals(0x120D0E21, a);
    // 302845473 (0x120D0E21)
  }

  @Test
  public void testInterleave_long() {
    System.out.println("interleave(x, y)");
    long a;
    a = Bit.interleave(0x0000L, 0xFFFFL);
    assertEquals(0x55555555L, a);
    // 1431655765 (0x55555555)

    a = Bit.interleave(0x1234L, 0x1234L);
    assertEquals(0x030C0F30L, a);
    // 51121968 (0x030C0F30)

    a = Bit.interleave(0x1234L, 0x4321L);
    assertEquals(0x120D0E21L, a);
    // 302845473 (0x120D0E21)
  }



  @Test
  public void testRotate_int() {
    System.out.println("rotate(x, n)");
    int a;
    a = Bit.rotate(0x11112222, 4);
    assertEquals(0x11122221, a);
    // 286401057 (0x11122221)

    a = Bit.rotate(0x11112222, -4);
    assertEquals(0x21111222, a);
    // 554766882 (0x21111222)
  }

  @Test
  public void testRotate_long() {
    System.out.println("rotate(x, n)");
    long a;
    a = Bit.rotate(0x1111222233334444L, 4);
    assertEquals(0x1112222333344441L, a);
    // 0x1112222333344441

    a = Bit.rotate(0x1111222233334444L, -4);
    assertEquals(0x4111122223333444L, a);
    // 0x4111122223333444
  }



  @Test
  public void testReverse_int() {
    System.out.println("reverse(x)");
    int a;
    a = Bit.reverse(0xFFFF0000);
    assertEquals(0x0000FFFF, a);
    // 65535 (0x0000FFFF)

    a = Bit.reverse(0x00AABBCC);
    assertEquals(0x33DD5500, a);
    // 870143232 (0x33DD5500)

    a = Bit.reverse(0x1234);
    assertEquals(0x2C480000, a);
    // 742916096 (0x2C480000)
  }

  @Test
  public void testReverse_long() {
    System.out.println("reverse(x)");
    long a;
    a = Bit.reverse(0xFFFFFFFF00000000L);
    assertEquals(0x00000000FFFFFFFFL, a);
    // 0x00000000FFFFFFFF

    a = Bit.reverse(0x0000AAAABBBBCCCCL);
    assertEquals(0x3333DDDD55550000L, a);
    // 0x3333DDDD55550000

    a = Bit.reverse(0x11223344L);
    assertEquals(0x22CC448800000000L, a);
    // 0x22CC448800000000
  }



  @Test
  public void testSignExtend_int() {
    System.out.println("signExtend(x, w)");
    int a;
    a = Bit.signExtend(15, 4);
    assertEquals(-1, a);
    // -1 (1111 => -1)

    a = Bit.signExtend(3, 3);
    assertEquals(3, a);
    // 3  (011 => 3)

    a = Bit.signExtend(4, 3);
    assertEquals(-4, a);
    // -4 (100 => -4)
  }

  @Test
  public void testSignExtend_long() {
    System.out.println("signExtend(x, w)");
    long a;
    a = Bit.signExtend(15L, 4);
    assertEquals(-1L, a);
    // -1 (1111 => -1)

    a = Bit.signExtend(3L, 3);
    assertEquals(3L, a);
    // 3  (011 => 3)

    a = Bit.signExtend(4L, 3);
    assertEquals(-4L, a);
    // -4 (100 => -4)
  }
}
