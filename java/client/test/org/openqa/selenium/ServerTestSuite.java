/*
 * Created on May 18, 2006
 *
 */
package org.openqa.selenium;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.server.LinuxHTMLRunnerFunctionalTest;
import org.openqa.selenium.server.WindowsHTMLRunnerFunctionalTest;


public class ServerTestSuite extends TestSuite {

  public static Test suite() {
    TestSuite suite = new TestSuite(ServerTestSuite.class.getName());
    if (WindowsUtils.thisIsWindows()) {
      suite.addTestSuite(WindowsHTMLRunnerFunctionalTest.class);
    } else {
      suite.addTestSuite(LinuxHTMLRunnerFunctionalTest.class);
    }
    return suite;
  }
}
