package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class GetRoutesCommandTest {
  /**
   * Test execute with mock WebServerSession.
   */
  @Test
  public void testExexute() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator = mock(VisualTransitSimulator.class);
    GetRoutesCommand getRoutesCommand = new GetRoutesCommand(visualTransitSimulator);
    JsonObject command = new JsonObject();
    getRoutesCommand.execute(webServerSession, command);
    verify(webServerSession).sendJson(isA(JsonObject.class));
  }


  /**
   * Test execute with a real WebServerSession.
   */
  @Test
  public void testExecuteReal() {
    String config;
    try {
      config = URLDecoder.decode(getClass().getClassLoader()
          .getResource("config.txt").getFile(), "UTF-8");
      WebServerSession webServerSession = mock(WebServerSession.class);
      VisualTransitSimulator visualTransitSimulator =
          new VisualTransitSimulator(config, webServerSession);
      List<Integer> vehicleStartTimes = new ArrayList<Integer>();
      vehicleStartTimes.add(0);
      vehicleStartTimes.add(1);
      visualTransitSimulator.start(vehicleStartTimes, 50);
      visualTransitSimulator.setVehicleFactories(0);
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      visualTransitSimulator.update();
      GetRoutesCommand getRoutesCommand = new GetRoutesCommand(visualTransitSimulator);
      JsonObject command = new JsonObject();
      getRoutesCommand.execute(webServerSession, command);
      verify(webServerSession).sendJson(isA(JsonObject.class));
    } catch (UnsupportedEncodingException uee) {
      uee.printStackTrace();
    }
  }

}