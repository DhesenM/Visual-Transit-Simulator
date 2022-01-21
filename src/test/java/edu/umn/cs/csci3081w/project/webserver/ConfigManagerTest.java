package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ConfigManagerTest {
  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    ConfigManager configManager = new ConfigManager();
    assertNull(configManager.getStorageFacility());
  }
}
