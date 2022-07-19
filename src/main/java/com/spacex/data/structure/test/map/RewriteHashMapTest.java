package com.spacex.data.structure.test.map;

import com.spacex.data.structure.map.jdk.RewriteHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RewriteHashMapTest {

    private RewriteHashMap<String, String> rewriteHashMap;

    @BeforeEach
    public void init() {
        this.rewriteHashMap = new RewriteHashMap<>();
    }

    @Test
    public void test() {
        String uuid = UUID.randomUUID().toString();
        rewriteHashMap.put(UUID.randomUUID().toString(), uuid);
    }
}
