package edu.umn.cs.csci3081w.project.model;

public abstract class Train extends Vehicle {
  public static final String TRAIN_VEHICLE = "TRAIN_VEHICLE";

  /**
   * Constructor for a train.
   *
   * @param id       train identifier
   * @param line     route of in/out bound
   * @param capacity capacity of the train
   * @param speed    speed of the train
   * @param color    color of train
   */
  public Train(int id, Line line, int capacity, double speed, int color) {
    super(id, line, capacity, speed, new PassengerLoader(), new PassengerUnloader(), color);
  }
}
