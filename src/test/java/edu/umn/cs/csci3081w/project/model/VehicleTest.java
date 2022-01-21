package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.webserver.WebServerSession;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {

  private Vehicle testVehicle;
  private SmallBus testSmallBus;
  private SmallBus testSmallBus2;
  private SmallBus testSmallBus3;
  private LargeBus testLargeBus;
  private DieselTrain testDieselTrain;
  private ElectricTrain testElectricTrain;
  private Route testRouteIn;
  private Route testRouteOut;


  /**
   * Setup operations before each test runs.
   */
  @BeforeEach
  public void setUp() {

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

    testRouteIn = new Route(0, "testRouteIn",
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

    testRouteOut = new Route(1, "testRouteOut",
        stopsOut, distancesOut, generatorOut);

    testVehicle = new VehicleTestImpl(1, new Line(10000, "testLine",
        "VEHICLE_LINE", testRouteOut, testRouteIn,
        new Issue()), 3, 1.0, new PassengerLoader(), new PassengerUnloader(), 0);

    testSmallBus = new SmallBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
            new Issue()), 3, 1.0, 1);

    Issue issue1 = new Issue();
    issue1.createIssue();
    testSmallBus2 = new SmallBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
            new Issue()), 3, -1.0, 1);

    testSmallBus3 = new SmallBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
            issue1), 3, -1.0, 1);

    Passenger pass = new Passenger(5, "jack");
    testSmallBus2.loadPassenger(pass);

    testLargeBus = new LargeBus(1, new Line(10000, "testLine", "BUS", testRouteOut, testRouteIn,
            new Issue()), 3, 1.0, 1);

    testDieselTrain = new DieselTrain(1, new Line(10000, "testLine", "BUS",
            testRouteOut, testRouteIn, new Issue()), 3, 1.0, 3);

    testElectricTrain = new ElectricTrain(1, new Line(10000, "testLine", "BUS",
            testRouteOut, testRouteIn, new Issue()), 3, 1.0, 3);


  }

  /**
   * Tests constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(1, testVehicle.getId());
    assertEquals("testRouteOut1", testVehicle.getName());
    assertEquals(3, testVehicle.getCapacity());
    assertEquals(1, testVehicle.getSpeed());
    assertEquals(testRouteOut, testVehicle.getLine().getOutboundRoute());
    assertEquals(testRouteIn, testVehicle.getLine().getInboundRoute());
  }

  /**
   * Tests if testIsTripComplete function works properly.
   */
  @Test
  public void testIsTripComplete() {
    assertEquals(false, testVehicle.isTripComplete());
    testVehicle.move();
    testVehicle.move();
    testVehicle.move();
    testVehicle.move();
    assertEquals(true, testVehicle.isTripComplete());

  }


  /**
   * Tests if loadPassenger function works properly.
   */
  @Test
  public void testLoadPassenger() {

    Passenger testPassenger1 = new Passenger(3, "testPassenger1");
    Passenger testPassenger2 = new Passenger(2, "testPassenger2");
    Passenger testPassenger3 = new Passenger(1, "testPassenger3");
    Passenger testPassenger4 = new Passenger(1, "testPassenger4");

    assertEquals(1, testVehicle.loadPassenger(testPassenger1));
    assertEquals(1, testVehicle.loadPassenger(testPassenger2));
    assertEquals(1, testVehicle.loadPassenger(testPassenger3));
    assertEquals(0, testVehicle.loadPassenger(testPassenger4));
  }


  /**
   * Tests if move function works properly.
   */
  @Test
  public void testMove() {

    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());
    testVehicle.move();

    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals(null, testVehicle.getNextStop());

  }

  /**
   * Tests if move function works properly.
   */
  @Test
  public void testMove2() {

    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());
    testVehicle.move();

    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());

    testVehicle.move();
    assertEquals(null, testVehicle.getNextStop());

    testVehicle.move();
    assertEquals(null, testVehicle.getNextStop());

  }

  /**
   * Tests if move function works properly.
   */
  @Test
  public void testMove1() {

    Passenger pass2 = new Passenger(5, "jack");
    Passenger pass23 = new Passenger(5, "jack");
    Passenger pass233 = new Passenger(5, "jack");
    Passenger pass2333 = new Passenger(5, "jack");
    testSmallBus2.loadPassenger(pass2);
    testSmallBus2.loadPassenger(pass23);
    testSmallBus2.loadPassenger(pass233);
    testSmallBus2.loadPassenger(pass2333);
    testSmallBus2.loadPassenger(pass2);

    assertEquals("test stop 2", testSmallBus2.getNextStop().getName());
    assertEquals(1, testSmallBus2.getNextStop().getId());
    testSmallBus2.move();

    assertEquals("test stop 1", testSmallBus2.getNextStop().getName());
    assertEquals(0, testSmallBus2.getNextStop().getId());

    testSmallBus2.move();
    assertEquals("test stop 1", testSmallBus2.getNextStop().getName());
    assertEquals(0, testSmallBus2.getNextStop().getId());

    testSmallBus2.move();
    assertEquals("test stop 1", testSmallBus2.getNextStop().getName());
    assertEquals(0, testSmallBus2.getNextStop().getId());

    testSmallBus2.move();
    assertNotEquals(null, testSmallBus2.getNextStop());

  }

  /**
   * Tests if update function works properly.
   */
  @Test
  public void testUpdate() {

    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());
    testVehicle.update();

    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.update();
    assertEquals("test stop 1", testVehicle.getNextStop().getName());
    assertEquals(0, testVehicle.getNextStop().getId());

    testVehicle.update();
    assertEquals("test stop 2", testVehicle.getNextStop().getName());
    assertEquals(1, testVehicle.getNextStop().getId());

    testVehicle.update();
    assertEquals(null, testVehicle.getNextStop());

  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testVehicle.setVehicleSubject(vehicleConcreteSubject);
    testVehicle.update();
    testVehicle.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo1() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testSmallBus.setVehicleSubject(vehicleConcreteSubject);
    testSmallBus.update();
    testSmallBus.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo4() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testLargeBus.setVehicleSubject(vehicleConcreteSubject);
    testLargeBus.update();
    testLargeBus.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo2() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testElectricTrain.setVehicleSubject(vehicleConcreteSubject);
    testElectricTrain.update();
    testElectricTrain.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo3() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testDieselTrain.setVehicleSubject(vehicleConcreteSubject);
    testDieselTrain.update();
    testDieselTrain.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo5() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testSmallBus2.setVehicleSubject(vehicleConcreteSubject);
    testSmallBus2.update();
    testSmallBus2.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }

  /**
   * Test to see if observer got attached.
   */
  @Test
  public void testProvideInfo6() {
    WebServerSession mockWebServerSession = mock(WebServerSession.class);
    VehicleConcreteSubject vehicleConcreteSubject =
        new VehicleConcreteSubject(mockWebServerSession);
    testSmallBus3.setVehicleSubject(vehicleConcreteSubject);
    testSmallBus3.update();
    testSmallBus3.provideInfo();
    verify(mockWebServerSession).sendJson(isA(JsonObject.class));
  }



  /**
   * Clean up our variables after each test.
   */
  @AfterEach
  public void cleanUpEach() {
    testVehicle = null;
  }

}
