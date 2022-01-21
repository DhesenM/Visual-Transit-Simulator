package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class InitLinesCommandTest {
  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    VisualTransitSimulator visualTransitSimulator = mock(VisualTransitSimulator.class);
    InitLinesCommand initLinesCommand = new InitLinesCommand(visualTransitSimulator);
  }
}
