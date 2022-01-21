package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Vehicle;
import edu.umn.cs.csci3081w.project.model.VehicleConcreteSubject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VisualTransitSimulatorTest {
  private String config;
  private WebServerSession webServerSession;
  private List<Integer> vehicleStartTimes;

  /**
   * Set up before each test.
   */
  @BeforeEach
  public void setUp() {
    try {
      config = URLDecoder.decode(getClass().getClassLoader()
          .getResource("config.txt").getFile(), "UTF-8");
      vehicleStartTimes = new ArrayList<Integer>();
      vehicleStartTimes.add(0);
      vehicleStartTimes.add(2);
    } catch (UnsupportedEncodingException uee) {
      uee.printStackTrace();
    }
  }

  /**
   * Test the update function.
   */
  @Test
  public void testUpdate() {
    webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator =
        new VisualTransitSimulator(config, webServerSession);
    visualTransitSimulator.setLogging(true);
    visualTransitSimulator.setVehicleFactories(0);
    visualTransitSimulator.start(vehicleStartTimes, 50);
    visualTransitSimulator.update();
    assertEquals(2, visualTransitSimulator.getActiveVehicles().size());
  }

  /**
   * Test the update function when complete.
   */
  @Test
  public void testUpdateDone() {
    webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator =
        new VisualTransitSimulator(config, webServerSession);
    visualTransitSimulator.setLogging(true);
    visualTransitSimulator.setVehicleFactories(0);
    visualTransitSimulator.start(vehicleStartTimes, 0);
    visualTransitSimulator.update();
    assertEquals(0, visualTransitSimulator.getActiveVehicles().size());
  }

  /**
   * Test the update function for a completed vehicle.
   */
  @Test
  public void testUpdateCompleteVehicle() {
    try {
      config = config = URLDecoder.decode(getClass().getClassLoader()
          .getResource("configNoStorageFacility.txt").getFile(), "UTF-8");
      webServerSession = mock(WebServerSession.class);
      VisualTransitSimulator visualTransitSimulator =
          new VisualTransitSimulator(config, webServerSession);
      visualTransitSimulator.setVehicleFactories(0);
      visualTransitSimulator.start(vehicleStartTimes, 50);
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      assertEquals(39, visualTransitSimulator.getActiveVehicles().size());
    } catch (UnsupportedEncodingException uee) {
      uee.printStackTrace();
    }
  }

  /**
   * Test attaching observer to vehicle.
   */
  @Test
  public void testAddObserver() {
    webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator =
        new VisualTransitSimulator(config, webServerSession);
    visualTransitSimulator.setLogging(true);
    Vehicle vehicle = mock(Vehicle.class);
    visualTransitSimulator.addObserver(vehicle);
    verify(vehicle).setVehicleSubject(isA(VehicleConcreteSubject.class));
  }

  /**
   * Test without a storage facility.
   */
  @Test
  public void testUpdateNoSF() {
    try {
      config = config = URLDecoder.decode(getClass().getClassLoader()
          .getResource("configNoStorageFacility.txt").getFile(), "UTF-8");
      webServerSession = mock(WebServerSession.class);
      VisualTransitSimulator visualTransitSimulator =
          new VisualTransitSimulator(config, webServerSession);
      visualTransitSimulator.setLogging(true);
      visualTransitSimulator.setVehicleFactories(0);
      visualTransitSimulator.start(vehicleStartTimes, 50);
      visualTransitSimulator.update();
      assertEquals(2, visualTransitSimulator.getActiveVehicles().size());
    } catch (UnsupportedEncodingException uee) {
      uee.printStackTrace();
    }
  }

  /**
   * Test with line issues.
   */
  @Test
  public void testUpdateIssue() {
    webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator =
        new VisualTransitSimulator(config, webServerSession);
    visualTransitSimulator.setVehicleFactories(0);
    visualTransitSimulator.start(vehicleStartTimes, 50);
    visualTransitSimulator.update();
    LineIssueCommand lineIssueCommand = new LineIssueCommand(visualTransitSimulator);
    JsonObject command = new JsonObject();
    command.addProperty("id", 10000);
    lineIssueCommand.execute(webServerSession, command);
    visualTransitSimulator.update();
    command.addProperty("id", 10001);
    visualTransitSimulator.update();
    assertEquals(3, visualTransitSimulator.getActiveVehicles().size());
  }

}
