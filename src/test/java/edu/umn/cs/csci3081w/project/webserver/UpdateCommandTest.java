package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

public class UpdateCommandTest {
  /**
   * Test execute.
   */
  @Test
  public void testExecute() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    VisualTransitSimulator visualTransitSimulator = mock(VisualTransitSimulator.class);
    UpdateCommand updateCommand = new UpdateCommand(visualTransitSimulator);
    JsonObject jsonObject = new JsonObject();
    updateCommand.execute(webServerSession, jsonObject);
    verify(visualTransitSimulator).update();
  }
}
