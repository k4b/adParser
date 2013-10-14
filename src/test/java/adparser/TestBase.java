package adparser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestBase {
  
  @Before
  public void beforeTestBase() {
    System.out.println(TestBase.class + " beforeTestBase() Done");
  }
  
  @After
  public void afterTestBase() {
    System.out.println(TestBase.class + " afterTestBase() Done");
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println(TestBase.class + " setUpClass() Done");
  }
  
  @AfterClass
  public static void tearDownClass() {
    System.out.println(TestBase.class + " tearDownClass() Done");
  }
}
