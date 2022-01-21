package edu.umn.cs.csci3081w.project.model;

public class VehicleDecorator {
  private int red;
  private int blue;
  private int green;
  private int alpha;

  public VehicleDecorator(int color) {
    this.updateColor(color);
  }

  /**
   * Update the color of the bus.
   *
   * @param color value (maroon or pink)
   * @return decorated bus after update
   */
  public VehicleDecorator updateColor(int color) {
    if (color == 0) {
      this.red = 122;
      this.green = 0;
      this.blue = 25;
      this.alpha = 255;
    } else if (color == 1) {
      this.red = 239;
      this.green = 130;
      this.blue = 238;
      this.alpha = 255;
    } else if (color == 2) {
      this.red = 60;
      this.green = 179;
      this.blue = 113;
      this.alpha = 255;
    } else {
      this.red = 255;
      this.green = 204;
      this.blue = 51;
      this.alpha = 255;
    }
    return this;
  }

  public void updateBack() {
    this.alpha = 255;
  }

  public void updateIssue() {
    this.alpha = 155;
  }

  public int getRed() {
    return this.red;
  }

  public int getGreen() {
    return this.green;
  }

  public int getBlue() {
    return this.blue;
  }

  public int getAlpha() {
    return this.alpha;
  }

}
