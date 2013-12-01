/**
 * Package: com.example.matrixCalculator
 * File: MainTest.scala
 * Created Date: October 26, 2013
 * Status: Completed
 * Programmer: Ka-Son Chan
 * Description: This MainTest.scala file contains test cases.
 */
package com.example.matrixcalculator.test

import android.test.ActivityInstrumentationTestCase2
import com.example.matrixcalculator._
import android.app.Activity
import android.content.Intent
import com.jayway.android.robotium.solo.Solo
import junit.framework.Assert._

class TestCases extends ActivityInstrumentationTestCase2[Main]("com.example.matrixcalculator", classOf[Main]) {
  private var solo: Solo = null
  private var myActivity: Activity = null
  private var myIntent: Intent = null

  override def setUp() {
    super.setUp()
    solo = new Solo(getInstrumentation(), getActivity())
    myActivity = getActivity
    myIntent = new Intent(myActivity, myActivity.getClass());
  }

  override def tearDown() {
    solo.finishOpenedActivities();
  }

  def testADTC01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("2")) // Enter 2
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("2"))
  }

  def testADTC02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(9) // Enter 2
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast = solo.searchText("Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.")
    assertEquals("Toast message appeared- Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.", toast, true)
  }

  def testADTC03() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(7) // Enter 0
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast = solo.searchText("Empty matrix row or column size. Enter size range between 1 to 5.")
    assertEquals("Toast message appeared- Empty matrix row or column size. Enter size range between 1 to 5.", toast, true)
  }

  def testADTC04() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(69) // Enter -
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast = solo.searchText("Invalid matrix data \"-\".")
    assertEquals("Toast message appeared- Invalid matrix data \"-\".", toast, true)
  }

  def testADTC05() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)
    val toast = solo.searchText("Empty matrix.")
    assertEquals("Toast message appeared- Empty matrix.", toast, true)
  }

  def testFSMTC01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(2, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.enterText(3, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("3")) // Enter 3
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("4")) // Enter 4
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("12"))
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.clickOnButton(1)

    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
  }

  def testFSMTC02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("1"))
    solo.enterText(2, String.valueOf("2"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.")
    assertEquals("Toast message appeared- Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.", toast1, true)
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(66) // Enter enter
    solo.sendKey(112) // Enter delete
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Matrix activity is launched", classOf[Matrix])
    solo.clickOnButton(1)

    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Matrix activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("3")) // Enter 3
    solo.sendKey(66) // Enter enter
    solo.sendKey(69) // Enter -
    solo.clickOnButton(0)
    val toast2 = solo.searchText("Invalid matrix data \"-\".")
    assertEquals("Toast message appeared- Invalid matrix data \"-\".", toast2, true)
  }

  def testSDTC01() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1")) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("3")) // Enter 3
    solo.sendKey(66) // Enter enter
    solo.enterText(1, String.valueOf("4")) // Enter 4
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Result])
    assertTrue(solo.searchText("12"))
  }

  def testSDTC02() {
    solo.assertCurrentActivity("Main activity is launched", classOf[Main])
    solo.enterText(0, String.valueOf("1"))
    solo.enterText(1, String.valueOf("2"))
    solo.enterText(2, String.valueOf("1"))
    solo.enterText(3, String.valueOf("1"))
    solo.clickOnButton(0)
    val toast1 = solo.searchText("Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.")
    assertEquals("Toast message appeared- Matrix Multiplication: Matrix 1 column size should be equal to Matrix 2 row size.", toast1, true)
    solo.enterText(0, String.valueOf("1"))
    solo.sendKey(66) // Enter enter
    solo.sendKey(112) // Enter delete
    solo.sendKey(8) // Enter 1
    solo.sendKey(66) // Enter enter
    solo.sendKey(66) // Enter enter
    solo.sendKey(66) // Enter enter
    solo.clickOnButton(0)

    solo.assertCurrentActivity("Main activity is launched", classOf[Matrix])
    solo.enterText(0, String.valueOf("3")) // Enter 3
    solo.sendKey(66) // Enter enter
    solo.sendKey(69) // Enter -
    solo.clickOnButton(0)
    val toast2 = solo.searchText("Invalid matrix data \"-\".")
    assertEquals("Toast message appeared- Invalid matrix data \"-\".", toast2, true)
  }
}