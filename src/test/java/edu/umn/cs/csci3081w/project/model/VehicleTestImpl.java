package edu.umn.cs.csci3081w.project.model;

import java.io.PrintStream;

public class VehicleTestImpl extends Vehicle {

  public VehicleTestImpl(int id, Line line, int capacity, double speed, PassengerLoader loader,
                         PassengerUnloader unloader, int color) {
    super(id, line, capacity, speed, loader, unloader, color);
  }

  /**
   * Method created for testing purposes.
   *
   * @param out output stream
   */
  @Override
  public void report(PrintStream out) {

  }

  /**
   * Method created for testing purposes.
   *
   * @return
   */
  @Override
  public int getCurrentCO2Emission() {
    return 0;
  }
}
