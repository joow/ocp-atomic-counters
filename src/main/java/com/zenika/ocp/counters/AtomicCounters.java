package com.zenika.ocp.counters;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static spark.Spark.port;
import static spark.Spark.post;

public class AtomicCounters {
    private static final Map<String, AtomicLong> COUNTERS = new HashMap<>();

    public static void main(String[] args) {
        final int port = Integer.valueOf(Optional.ofNullable(System.getenv("PORT")).orElse("4567"));
        port(port);
        post("/:counter", (request, response) -> incrementAndGet(request.params("counter")));
    }

    private static long incrementAndGet(final String counterName) {
        AtomicLong counter = Optional.ofNullable(COUNTERS.get(counterName)).orElseGet(() -> newCounter(counterName));
        return counter.incrementAndGet();
    }

    private static AtomicLong newCounter(final String counterName) {
        COUNTERS.put(counterName, new AtomicLong());
        return COUNTERS.get(counterName);
    }
}
