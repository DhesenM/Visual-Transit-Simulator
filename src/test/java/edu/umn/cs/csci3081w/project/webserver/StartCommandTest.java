package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StartCommandTest {
  /**
   * Test execute with a mock WebServerSession.
   */
  @Test
  public void testExecute() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator =
        mock(VisualTransitSimulator.class);
    StartCommand startCommand = new StartCommand(visualTransitSimulator);
    JsonObject command = new JsonObject();
    JsonArray vehicleStartTimesJson = new JsonArray();
    command.addProperty("numTimeSteps", 50);
    vehicleStartTimesJson.add(0);
    vehicleStartTimesJson.add(1);
    command.add("timeBetweenVehicles", vehicleStartTimesJson);
    startCommand.execute(webServerSession, command);
    verify(visualTransitSimulator).start(isA(List.class), isA(Integer.class));
  }
}
