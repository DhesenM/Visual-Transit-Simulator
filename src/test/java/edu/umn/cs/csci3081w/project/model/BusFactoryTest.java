package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusFactoryTest {
  private StorageFacility storageFacility;
  private StorageFacility storageFacility1;
  private StorageFacility storageFacility2;
  private BusFactory busFactory;
  private BusFactory busFactory1;
  private BusFactory busFactory2;
  private BusFactory busFactory3;
  private BusFactory busFactory4;

  /**
   * Set up for each test.
   */
  @BeforeEach
  public void setUp() {
    storageFacility = new StorageFacility(2, 1, 0, 0);
    storageFacility1 = new StorageFacility(0, 0, 0, 0);
    storageFacility2 = new StorageFacility(0, 0, 1, 1);
    busFactory = new BusFactory(storageFacility, new Counter(), 9);
    busFactory1 = new BusFactory(storageFacility, new Counter(), 16);
    busFactory2 = new BusFactory(storageFacility, new Counter(), 8);
    busFactory3 = new BusFactory(storageFacility1, new Counter(), 8);
    busFactory4 = new BusFactory(storageFacility2, new Counter(), 8);
  }

  /**
   * Testing the constructor.
   */
  @Test
  public void testConstructor() {
    assertTrue(busFactory.getGenerationStrategy() instanceof BusStrategyDay);
  }

  /**
   * Testing the second constructor.
   */
  @Test
  public void testConstructor1() {
    assertTrue(busFactory1.getGenerationStrategy() instanceof BusStrategyNight);
  }

  /**
   * Testing the second constructor.
   */
  @Test
  public void testConstructor2() {

    assertTrue(busFactory2.getGenerationStrategy() instanceof BusStrategyDay);
    //assertNull(busFactory2.getGenerationStrategy());
  }

  /**
   * Testing if generated vehicle is working according to strategy.
   */
  @Test
  public void testGenerateVehicle() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Line line = new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue());

    Vehicle vehicle = busFactory.generateVehicle(line);
    assertTrue(vehicle instanceof LargeBus);
  }

  /**
   * Testing more branches.
   */
  @Test
  public void testGenerateVehicle1() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Line line = new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue());

    Vehicle vehicle = busFactory1.generateVehicle(line);
    assertTrue(vehicle instanceof SmallBus);

  }

  /**
   * Testing more branches.
   */
  @Test
  public void testGenerateVehicle2() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Line line = new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue());

    Vehicle vehicle = busFactory3.generateVehicle(line);
    assertFalse(vehicle instanceof SmallBus);

  }

  /**
   * Testing more branches.
   */
  @Test
  public void testGenerateVehicle3() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Line line = new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue());

    Vehicle vehicle = busFactory4.generateVehicle(line);
    assertFalse(vehicle instanceof SmallBus);

  }

  /**
   * Testing if vehicle got returned.
   */
  @Test
  public void testReturnVehicleLargeBus() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Bus testBus = new LargeBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue()), 3, 1.0, 1);

    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());
    busFactory.returnVehicle(testBus);
    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(2, busFactory.getStorageFacility().getLargeBusesNum());

  }

  /**
   * Testing if vehicle got returned.
   */
  @Test
  public void testReturnVehicleSmallBus() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Bus testBus = new SmallBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue()), 3, 1.0, 1);

    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());
    busFactory.returnVehicle(testBus);
    assertEquals(3, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());

  }

  /**
   * Testing if vehicle got returned.
   */
  @Test
  public void testReturnBoth() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Bus testBus = new SmallBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue()), 3, 1.0, 1);
    Bus testBus1 = new LargeBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
        new Issue()), 3, 1.0, 1);

    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());
    busFactory.returnVehicle(testBus);
    busFactory.returnVehicle(testBus1);
    assertEquals(3, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(2, busFactory.getStorageFacility().getLargeBusesNum());

  }

  /**
   * Testing if vehicle got returned.
   */
  @Test
  public void testReturnNeither() {
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, "test stop 1", new Position(-93.243774, 44.972392));
    Stop stop2 = new Stop(1, "test stop 2", new Position(-93.235071, 44.973580));
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.843774422231134);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(stopsIn, probabilitiesIn);

    Route testRouteIn = new Route(0, "testRouteIn",
        stopsIn, distancesIn, generatorIn);

    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.843774422231134);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.025);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(stopsOut, probabilitiesOut);

    Route testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    Train testTrain = new ElectricTrain(1, new Line(10000, "testLine", "BUS",
        testRouteOut, testRouteIn, new Issue()), 3, 1.0, 3);
    Train tock = mock(Train.class);

    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());
    busFactory.returnVehicle(tock);
    assertEquals(2, busFactory.getStorageFacility().getSmallBusesNum());
    assertEquals(1, busFactory.getStorageFacility().getLargeBusesNum());

  }
}
