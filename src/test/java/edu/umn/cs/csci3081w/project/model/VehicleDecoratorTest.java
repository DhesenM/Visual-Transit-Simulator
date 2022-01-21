package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VehicleDecoratorTest {

  private VehicleDecorator decorator;

  /**
   * Tests color maroon.
   */
  @Test
  public void testMaroon() {
    decorator = new VehicleDecorator(0);
    assertEquals(122, decorator.getRed());
    assertEquals(0, decorator.getGreen());
    assertEquals(25, decorator.getBlue());
    assertEquals(255, decorator.getAlpha());
  }

  /**
   * Tests color pink.
   */
  @Test
  public void testPink() {
    decorator = new VehicleDecorator(1);
    assertEquals(239, decorator.getRed());
    assertEquals(130, decorator.getGreen());
    assertEquals(238, decorator.getBlue());
    assertEquals(255, decorator.getAlpha());
  }

  /**
   * Tests color green.
   */
  @Test
  public void testGreen() {
    decorator = new VehicleDecorator(2);
    assertEquals(60, decorator.getRed());
    assertEquals(179, decorator.getGreen());
    assertEquals(113, decorator.getBlue());
    assertEquals(255, decorator.getAlpha());
  }

  /**
   * Tests color yellow.
   */
  @Test
  public void testYellow() {
    decorator = new VehicleDecorator(3);
    assertEquals(255, decorator.getRed());
    assertEquals(204, decorator.getGreen());
    assertEquals(51, decorator.getBlue());
    assertEquals(255, decorator.getAlpha());
  }

  /**
   * Tests method updateIssue and updateBack.
   */
  @Test
  public void testUpdateIssue() {
    decorator = new VehicleDecorator(0);
    decorator.updateIssue();
    assertEquals(155, decorator.getAlpha());
    decorator.updateBack();
    assertEquals(255, decorator.getAlpha());
  }
}
