package edu.umn.cs.csci3081w.project.webserver;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Line;
import edu.umn.cs.csci3081w.project.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LineIssueCommandTest {
  /**
   * Test execute with a mock WebServerSession.
   */
  @Test
  public void testExecute() {
    WebServerSession webServerSession = mock(WebServerSession.class);
    List<Line> lines = new ArrayList();
    lines.add(mock(Line.class));
    VisualTransitSimulator visualTransitSimulator =
        mock(VisualTransitSimulator.class);
    when(visualTransitSimulator.getLines()).thenReturn(lines);
    LineIssueCommand lineIssueCommand =
        new LineIssueCommand(visualTransitSimulator);

    JsonObject command = new JsonObject();
    command.addProperty("id", 0);
    lineIssueCommand.execute(webServerSession, command);
    verify(lines.get(0)).createIssue();
  }
}
