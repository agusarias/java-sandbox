package com.tiendanube.interviews.Problems.RepeatedURLs;
import java.util.List;

class Solution {

    long solve(List<String> urls, String targetUrl) {
        return urls.stream()
                .filter(url -> url.equals(targetUrl))
                .count();
    }

}
