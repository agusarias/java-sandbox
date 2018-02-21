package com.tiendanube.interviews.Problems.RepeatedURLs;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private static final String resourcesPath = "/src/test/java/com/tiendanube/interviews/Problems/RepeatedURLs/";
    private long startTime = 0;

    private void measureStart() {
        startTime = System.nanoTime();
    }

    private void measureStop(String name) {
        long duration = (System.nanoTime() - startTime) / 1000; // microseconds
        System.out.println(name + " duration: " + duration);
    }

    @Test
    public void testTenEqualUrls() {
        Solution solution = new Solution();
        long expectedResult = 10;
        List<String> urls = this.readURLsFromFile("10_equal");
        String url = urls.get(0);

        long result = solution.solve(urls, url);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testTenDifferentUrls() {
        Solution solution = new Solution();
        long expectedResult = 1;
        List<String> urls = this.readURLsFromFile("10_different");
        String url = urls.get(0);

        measureStart();
        long result = solution.solve(urls, url);
        measureStop("measureStart");

        assertEquals(expectedResult, result);
    }

    @Test
    public void testLargeAndTargetManyTimes() {
        Solution solution = new Solution();
        long expectedResult = 635;
        List<String> urls = this.readURLsFromFile("10000");
        String url = "https://www.example.com/";

        measureStart();
        long result = solution.solve(urls, url);
        measureStop("testLargeAndTargetManyTimes");

        assertEquals(expectedResult, result);
    }


    @Test
    public void testLargeAndTwoTargets() {
        Solution solution = new Solution();
        long expectedResultOne = 655,
                expectedResultTwo = 635;
        List<String> urls = this.readURLsFromFile("10000");
        String targetOne = "http://www.example.com/";
        String targetTwo = "https://www.example.com/";

        measureStart();
        long resultOne = solution.solve(urls, targetOne);
        long resultTwo = solution.solve(urls, targetTwo);
        measureStop("testLargeAndTwoTargets");

        assertEquals(expectedResultOne, resultOne);
        assertEquals(expectedResultTwo, resultTwo);
    }

    @Test
    public void testLargeAndTenTargets() {
        Solution solution = new Solution();
        List<String> urls = this.readURLsFromFile("10000");
        List<Target> targets = Arrays.asList(
                new Target("https://www.example.com/", 635),
                new Target("http://www.example.com/", 655),
                new Target("https://example.com/", 392),
                new Target("http://agreement.example.com/", 4),
                new Target("https://www.example.net/?art=bit", 1),
                new Target("https://example.org/", 61),
                new Target("http://appliance.example.net/?argument=ball", 1),
                new Target("http://brake.example.com/", 7),
                new Target("http://example.com/#argument", 3),
                new Target("https://example.com/army/birds", 1));


        measureStart();
        targets.forEach(target -> {
            assertEquals("Asserting " + target.url + " failed",
                    target.expectedOccurences,
                    solution.solve(urls, target.url));
        });
        measureStop("testLargeAndTenTargets");
    }

    @Test
    public void testTargetNotFound() {
        Solution solution = new Solution();
        long expectedResult = 0;
        List<String> urls = this.readURLsFromFile("20_target_not_found");
        String url = "http://google.com";

        measureStart();
        long result = solution.solve(urls, url);
        measureStop("testTargetNotFound");

        assertEquals(expectedResult, result);
    }

    private List<String> readURLsFromFile(String fileName) {
        List<String> urls = new ArrayList<>();
        String path = System.getProperty("user.dir") + resourcesPath;

        try (Stream<String> stream = Files.lines(Paths.get(path + fileName))) {
            stream.forEach(urls::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urls;
    }

    private class Target {
        String url;
        long expectedOccurences;

        Target(String url, long expected) {
            this.url = url;
            this.expectedOccurences = expected;
        }
    }
}

