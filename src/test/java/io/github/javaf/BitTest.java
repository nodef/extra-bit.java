/*
 * The MIT License
 *
 * Copyright 2020 wolfram.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.github.javaf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author wolfram
 */
public class BitTest {
  
  public BitTest() {
  }

  @org.junit.jupiter.api.BeforeAll
  public static void setUpClass() throws Exception {
  }

  @org.junit.jupiter.api.AfterAll
  public static void tearDownClass() throws Exception {
  }

  @org.junit.jupiter.api.BeforeEach
  public void setUp() throws Exception {
  }

  @org.junit.jupiter.api.AfterEach
  public void tearDown() throws Exception {
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

  /**
   * Test of count method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testCount_int() {
    System.out.println("count");
    int x = 0;
    int expResult = 0;
    int result = Bit.count(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of count method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testCount_long() {
    System.out.println("count");
    long x = 0L;
    long expResult = 0L;
    long result = Bit.count(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of get method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testGet_int_int() {
    System.out.println("get");
    int x = 0;
    int i = 0;
    int expResult = 0;
    int result = Bit.get(x, i);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of get method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testGet_long_int() {
    System.out.println("get");
    long x = 0L;
    int i = 0;
    int expResult = 0;
    int result = Bit.get(x, i);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testGetAs_int_int() {
    System.out.println("getAs");
    int x = 0;
    int m = 0;
    int expResult = 0;
    int result = Bit.getAs(x, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testGetAs_long_long() {
    System.out.println("getAs");
    long x = 0L;
    long m = 0L;
    long expResult = 0L;
    long result = Bit.getAs(x, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of interleave method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testInterleave_int_int() {
    System.out.println("interleave");
    int x = 0;
    int y = 0;
    int expResult = 0;
    int result = Bit.interleave(x, y);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of interleave method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testInterleave_long_long() {
    System.out.println("interleave");
    long x = 0L;
    long y = 0L;
    long expResult = 0L;
    long result = Bit.interleave(x, y);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of merge method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testMerge_3args_1() {
    System.out.println("merge");
    int x = 0;
    int y = 0;
    int m = 0;
    int expResult = 0;
    int result = Bit.merge(x, y, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of merge method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testMerge_3args_2() {
    System.out.println("merge");
    long x = 0L;
    long y = 0L;
    long m = 0L;
    long expResult = 0L;
    long result = Bit.merge(x, y, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of parity method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testParity_int() {
    System.out.println("parity");
    int x = 0;
    int expResult = 0;
    int result = Bit.parity(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of parity method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testParity_long() {
    System.out.println("parity");
    long x = 0L;
    int expResult = 0;
    int result = Bit.parity(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of parity method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testParity_int_int() {
    System.out.println("parity");
    int x = 0;
    int n = 0;
    int expResult = 0;
    int result = Bit.parity(x, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of parity method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testParity_long_int() {
    System.out.println("parity");
    long x = 0L;
    int n = 0;
    int expResult = 0;
    int result = Bit.parity(x, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of reverse method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testReverse_int() {
    System.out.println("reverse");
    int x = 0;
    int expResult = 0;
    int result = Bit.reverse(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of reverse method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testReverse_long() {
    System.out.println("reverse");
    long x = 0L;
    long expResult = 0L;
    long result = Bit.reverse(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of rotate method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testRotate_int_int() {
    System.out.println("rotate");
    int x = 0;
    int n = 0;
    int expResult = 0;
    int result = Bit.rotate(x, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of rotate method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testRotate_long_int() {
    System.out.println("rotate");
    long x = 0L;
    int n = 0;
    long expResult = 0L;
    long result = Bit.rotate(x, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of scan method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testScan_int() {
    System.out.println("scan");
    int x = 0;
    int expResult = 0;
    int result = Bit.scan(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of scan method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testScan_long() {
    System.out.println("scan");
    long x = 0L;
    int expResult = 0;
    int result = Bit.scan(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of scanReverse method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testScanReverse_int() {
    System.out.println("scanReverse");
    int x = 0;
    int expResult = 0;
    int result = Bit.scanReverse(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of scanReverse method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testScanReverse_long() {
    System.out.println("scanReverse");
    long x = 0L;
    int expResult = 0;
    int result = Bit.scanReverse(x);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of set method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSet_3args_1() {
    System.out.println("set");
    int x = 0;
    int i = 0;
    int f = 0;
    int expResult = 0;
    int result = Bit.set(x, i, f);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of set method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSet_3args_2() {
    System.out.println("set");
    long x = 0L;
    int i = 0;
    int f = 0;
    long expResult = 0L;
    long result = Bit.set(x, i, f);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSetAs_3args_1() {
    System.out.println("setAs");
    int x = 0;
    int m = 0;
    int f = 0;
    int expResult = 0;
    int result = Bit.setAs(x, m, f);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSetAs_3args_2() {
    System.out.println("setAs");
    long x = 0L;
    long m = 0L;
    int f = 0;
    long expResult = 0L;
    long result = Bit.setAs(x, m, f);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of signExtend method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSignExtend_int_int() {
    System.out.println("signExtend");
    int x = 0;
    int w = 0;
    int expResult = 0;
    int result = Bit.signExtend(x, w);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of signExtend method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSignExtend_long_int() {
    System.out.println("signExtend");
    long x = 0L;
    int w = 0;
    long expResult = 0L;
    long result = Bit.signExtend(x, w);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of swap method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSwap_4args_1() {
    System.out.println("swap");
    int x = 0;
    int i = 0;
    int j = 0;
    int n = 0;
    int expResult = 0;
    int result = Bit.swap(x, i, j, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of swap method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testSwap_4args_2() {
    System.out.println("swap");
    long x = 0L;
    int i = 0;
    int j = 0;
    int n = 0;
    long expResult = 0L;
    long result = Bit.swap(x, i, j, n);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toggle method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testToggle_int_int() {
    System.out.println("toggle");
    int x = 0;
    int i = 0;
    int expResult = 0;
    int result = Bit.toggle(x, i);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toggle method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testToggle_long_int() {
    System.out.println("toggle");
    long x = 0L;
    int i = 0;
    long expResult = 0L;
    long result = Bit.toggle(x, i);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toggleAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testToggleAs_int_int() {
    System.out.println("toggleAs");
    int x = 0;
    int m = 0;
    int expResult = 0;
    int result = Bit.toggleAs(x, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toggleAs method, of class Bit.
   */
  @org.junit.jupiter.api.Test
  public void testToggleAs_long_long() {
    System.out.println("toggleAs");
    long x = 0L;
    long m = 0L;
    long expResult = 0L;
    long result = Bit.toggleAs(x, m);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
