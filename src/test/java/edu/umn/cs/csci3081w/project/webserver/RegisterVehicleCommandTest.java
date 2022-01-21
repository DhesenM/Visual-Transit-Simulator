package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class RegisterVehicleCommandTest {
  /**
   * Test execute with a mock WebServerSession.
   */
  @Test
  public void testExecute() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    List<Vehicle> vehicles = new ArrayList();
    vehicles.add(mock(Vehicle.class));
    vehicles.add(mock(Vehicle.class));
    VisualTransitSimulator visualTransitSimulator =
        mock(VisualTransitSimulator.class);
    when(visualTransitSimulator.getActiveVehicles()).thenReturn(vehicles);
    RegisterVehicleCommand registerVehicleCommand =
        new RegisterVehicleCommand(visualTransitSimulator);

    JsonObject command = new JsonObject();
    command.addProperty("id", 0);
    registerVehicleCommand.execute(webServerSession, command);
    verify(visualTransitSimulator).addObserver(isA(Vehicle.class));
  }

  /**
   * Test execute with a mock WebServerSession,
   * while not registering a vehicle.
   */
  @Test
  public void testExecuteNotRegistered() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    List<Vehicle> vehicles = new ArrayList();
    vehicles.add(mock(Vehicle.class));
    vehicles.add(mock(Vehicle.class));
    VisualTransitSimulator visualTransitSimulator =
        mock(VisualTransitSimulator.class);
    when(visualTransitSimulator.getActiveVehicles()).thenReturn(vehicles);
    RegisterVehicleCommand registerVehicleCommand =
        new RegisterVehicleCommand(visualTransitSimulator);

    JsonObject command = new JsonObject();
    command.addProperty("id", -1);
    registerVehicleCommand.execute(webServerSession, command);
    verify(visualTransitSimulator, times(0)).addObserver(isA(Vehicle.class));
  }
}
