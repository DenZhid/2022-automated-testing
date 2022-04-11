package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({GroupTest.class, MusicTest.class, PhotoTest.class})
public class AllTests {
}
