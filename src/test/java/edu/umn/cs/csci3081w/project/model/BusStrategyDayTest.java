package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusStrategyDayTest {

  /**
   * Test constructor normal.
   */
  @Test
  public void testConstructor() {
    BusStrategyDay busStrategyDay = new BusStrategyDay();
    assertEquals(0, busStrategyDay.getCounter());
  }

  /**
   * Testing to get correct vehicle according to the strategy.
   */
  @Test
  public void testGetTypeOfVehicle() {
    StorageFacility storageFacility = new StorageFacility(1, 2, 0, 0);
    BusStrategyDay busStrategyDay = new BusStrategyDay();
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = busStrategyDay.getTypeOfVehicle(storageFacility);
      assertEquals(LargeBus.LARGE_BUS_VEHICLE, strToCmpr);
      strToCmpr = busStrategyDay.getTypeOfVehicle(storageFacility);
      assertEquals(LargeBus.LARGE_BUS_VEHICLE, strToCmpr);
      strToCmpr = busStrategyDay.getTypeOfVehicle(storageFacility);
      assertEquals(SmallBus.SMALL_BUS_VEHICLE, strToCmpr);
    }
  }

  /**
   * Testing to hit more branches.
   */
  @Test
  public void testGetTypeOfVehicle1() {
    StorageFacility storageFacility1 = new StorageFacility(0, 0, 0, 0);
    BusStrategyDay busStrategyDay1 = new BusStrategyDay();
    //    TrainStrategyNight trainStrategyDay = mock(TrainStrategyNight.class);
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = busStrategyDay1.getTypeOfVehicle(storageFacility1);
      assertEquals(null, strToCmpr);
      strToCmpr = busStrategyDay1.getTypeOfVehicle(storageFacility1);
      assertEquals(null, strToCmpr);
    }
  }

  /**
   * Testing to hit even more branches.
   */
  @Test
  public void testGetTypeOfVehicle2() {
    StorageFacility storageFacility2 = new StorageFacility(0, 2, 0, 0);
    BusStrategyDay busStrategyDay2 = new BusStrategyDay();
    //    TrainStrategyNight trainStrategyDay = mock(TrainStrategyNight.class);
    String strToCmpr;
    for (int i = 0; i < 1; i++) {
      strToCmpr = busStrategyDay2.getTypeOfVehicle(storageFacility2);
      assertEquals(LargeBus.LARGE_BUS_VEHICLE, strToCmpr);
      strToCmpr = busStrategyDay2.getTypeOfVehicle(storageFacility2);
      assertEquals(LargeBus.LARGE_BUS_VEHICLE, strToCmpr);
      strToCmpr = busStrategyDay2.getTypeOfVehicle(storageFacility2);
      assertEquals(null, strToCmpr);
    }
  }
}
