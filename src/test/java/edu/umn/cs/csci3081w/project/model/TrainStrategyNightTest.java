package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class TrainStrategyNightTest {

  /**
   * Test constructor normal.
   */
  @Test
  public void testConstructor() {
    TrainStrategyNight trainStrategyNight = new TrainStrategyNight();
    assertEquals(0, trainStrategyNight.getCounter());
  }

  /**
   * Testing to get correct vehicle according to the strategy.
   */
  @Test
  public void testGetTypeOfVehicle() {
    StorageFacility storageFacility = new StorageFacility(0, 0, 1, 1);
    TrainStrategyNight trainStrategyDay = new TrainStrategyNight();
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = trainStrategyDay.getTypeOfVehicle(storageFacility);
      assertEquals(ElectricTrain.ELECTRIC_TRAIN_VEHICLE, strToCmpr);
      strToCmpr = trainStrategyDay.getTypeOfVehicle(storageFacility);
      assertEquals(DieselTrain.DIESEL_TRAIN_VEHICLE, strToCmpr);
    }
  }

  /**
   * Testing to hit more branches.
   */
  @Test
  public void testGetTypeOfVehicle1() {
    StorageFacility storageFacility1 = new StorageFacility(0, 0, 0, 0);
    TrainStrategyNight trainStrategyDay1 = new TrainStrategyNight();
    //    TrainStrategyNight trainStrategyDay = mock(TrainStrategyNight.class);
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = trainStrategyDay1.getTypeOfVehicle(storageFacility1);
      assertEquals(null, strToCmpr);
      strToCmpr = trainStrategyDay1.getTypeOfVehicle(storageFacility1);
      assertEquals(null, strToCmpr);
    }
  }

  /**
   * Testing to hit even more branches.
   */
  @Test
  public void testGetTypeOfVehicle2() {
    StorageFacility storageFacility2 = new StorageFacility(0, 0, 1, 0);
    TrainStrategyNight trainStrategyDay2 = new TrainStrategyNight();
    //    TrainStrategyNight trainStrategyDay = mock(TrainStrategyNight.class);
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = trainStrategyDay2.getTypeOfVehicle(storageFacility2);
      assertEquals(ElectricTrain.ELECTRIC_TRAIN_VEHICLE, strToCmpr);
      strToCmpr = trainStrategyDay2.getTypeOfVehicle(storageFacility2);
      assertEquals(null, strToCmpr);
    }
  }
}
