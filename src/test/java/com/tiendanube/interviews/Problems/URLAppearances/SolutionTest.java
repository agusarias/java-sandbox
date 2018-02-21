package com.tiendanube.interviews.Problems.URLAppearances;

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

    private static final String resourcesPath = "/src/test/java/com/tiendanube/interviews/Problems/URLAppearances/";
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
        long expectedResult = 10;
        List<String> urls = this.readURLsFromFile("10_equal");
        String url = urls.get(0);
        Solution solution = new Solution(urls);

        measureStart();
        long result = solution.solve(url);
        measureStop("testTenEqualUrls");

        assertEquals(expectedResult, result);
    }

    @Test
    public void testTenDifferentUrls() {
        long expectedResult = 1;
        List<String> urls = this.readURLsFromFile("10_different");
        String url = urls.get(0);
        Solution solution = new Solution(urls);

        measureStart();
        long result = solution.solve(url);
        measureStop("testTenDifferentUrls");

        assertEquals(expectedResult, result);
    }

    @Test
    public void testLargeAndTargetManyTimes() {
        long expectedResult = 635;
        List<String> urls = this.readURLsFromFile("10000");
        String url = "https://www.example.com/";
        Solution solution = new Solution(urls);

        measureStart();
        long result = solution.solve(url);
        measureStop("testLargeAndTargetManyTimes");

        assertEquals(expectedResult, result);
    }


    @Test
    public void testLargeAndTwoTargets() {
        long expectedResultOne = 655,
                expectedResultTwo = 635;
        List<String> urls = this.readURLsFromFile("10000");
        String targetOne = "http://www.example.com/";
        String targetTwo = "https://www.example.com/";
        Solution solution = new Solution(urls);

        measureStart();
        long resultOne = solution.solve(targetOne);
        long resultTwo = solution.solve(targetTwo);
        measureStop("testLargeAndTwoTargets");

        assertEquals(expectedResultOne, resultOne);
        assertEquals(expectedResultTwo, resultTwo);
    }

    @Test
    public void testLargeAndTenTargets() {
        List<String> urls = this.readURLsFromFile("10000");
        Solution solution = new Solution(urls);

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
                    solution.solve(target.url));
        });
        measureStop("testLargeAndTenTargets");
    }


    @Test
    public void testLargeAndOneHundredTargets() {
        List<String> urls = this.readURLsFromFile("10000");
        Solution solution = new Solution(urls);
        List<Target> targets = new ArrayList<>();

        // Multiply input up to 100
        for (int i = 0; i < 10; i++) {
            targets.add(new Target("https://www.example.com/", 635));
            targets.add(new Target("http://www.example.com/", 655));
            targets.add(new Target("https://example.com/", 392));
            targets.add(new Target("http://agreement.example.com/", 4));
            targets.add(new Target("https://www.example.net/?art=bit", 1));
            targets.add(new Target("https://example.org/", 61));
            targets.add(new Target("http://appliance.example.net/?argument=ball", 1));
            targets.add(new Target("http://brake.example.com/", 7));
            targets.add(new Target("http://example.com/#argument", 3));
            targets.add(new Target("https://example.com/army/birds", 1));
        }

        measureStart();
        targets.forEach(target -> {
            assertEquals("Asserting " + target.url + " failed",
                    target.expectedOccurences,
                    solution.solve(target.url));
        });

        measureStop("testLargeAndOneHundredTargets");
    }


    @Test
    public void testLargeAndOneThousandTargets() {
        List<String> urls = this.readURLsFromFile("10000");
        Solution solution = new Solution(urls);
        List<Target> targets = new ArrayList<>();

        // Multiply input up to 1000
        for (int i = 0; i < 100; i++) {
            targets.add(new Target("https://www.example.com/", 635));
            targets.add(new Target("http://www.example.com/", 655));
            targets.add(new Target("https://example.com/", 392));
            targets.add(new Target("http://agreement.example.com/", 4));
            targets.add(new Target("https://www.example.net/?art=bit", 1));
            targets.add(new Target("https://example.org/", 61));
            targets.add(new Target("http://appliance.example.net/?argument=ball", 1));
            targets.add(new Target("http://brake.example.com/", 7));
            targets.add(new Target("http://example.com/#argument", 3));
            targets.add(new Target("https://example.com/army/birds", 1));
        }

        measureStart();
        targets.forEach(target -> {
            assertEquals("Asserting " + target.url + " failed",
                    target.expectedOccurences,
                    solution.solve(target.url));
        });

        measureStop("testLargeAndOneThousandTargets");
    }

    @Test
    public void testTargetNotFound() {
        long expectedResult = 0;
        List<String> urls = this.readURLsFromFile("20_target_not_found");
        String url = "http://google.com";
        Solution solution = new Solution(urls);

        measureStart();
        long result = solution.solve(url);
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

