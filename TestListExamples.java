import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge2() {
    List<String> left = Arrays.asList("a", "d", "z");
    List<String> right = Arrays.asList("b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "d", "z");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge3() {
    List<String> left = Arrays.asList("a", "b");
    List<String> right = Arrays.asList("c", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter() {
    List<String> input = Arrays.asList("Hello", "Hi", "moon");
    IsMoon s = new IsMoon();
    List<String> filtered = ListExamples.filter(input, s);
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, filtered);
  }

  @Test
  public void testFilter2() {
    List<String> input = Arrays.asList("Hello", "Hi");
    IsMoon s = new IsMoon();
    List<String> filtered = ListExamples.filter(input, s);
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test
  public void testFilter3() {
    List<String> input = Arrays.asList("moon", "Hi", "moon");
    IsMoon s = new IsMoon();
    List<String> filtered = ListExamples.filter(input, s);
    List<String> expected = Arrays.asList("moon", "moon");
    assertEquals(expected, filtered);
  }
}
