package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link LRUCache}
 *
 * @author Milan Rathod
 */
public class LRUCacheTest {

    @Test
    public void testRefer() {
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(15);
        lruCache.refer(10);
        lruCache.refer(12);
        lruCache.refer(15);
        lruCache.refer(10);
        lruCache.refer(16);

        Assert.assertEquals(2, lruCache.getPageHit());

        Assert.assertEquals(5, lruCache.getPageFault());
    }
}