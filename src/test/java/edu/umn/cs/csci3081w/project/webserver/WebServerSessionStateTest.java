package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

public class WebServerSessionStateTest {
  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    VisualTransitSimulator visualTransitSimulator =
        mock(VisualTransitSimulator.class);
    WebServerSessionState webServerSessionState = new WebServerSessionState();
    webServerSessionState.getCommands().put("update",
        new UpdateCommand(visualTransitSimulator));
    JsonObject jsonObject = new JsonObject();
    webServerSessionState.getCommands()
        .get("update").execute(mock(WebServerSession.class), jsonObject);
    verify(visualTransitSimulator).update();
  }
}
