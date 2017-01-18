package com.xix.service;

import com.xix.model.Activity;
import com.xix.service.impl.InMemoryActivityService;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xix on 12/14/16.
 */
public class InMemoryActivityServiceTest {

    private ActivityService activityService = null;

    @Before public void setUp() {
        activityService = new InMemoryActivityService();
        activityService.save(new Activity("Running"));
        activityService.save(new Activity("Swimming"));
    }

    @After public  void tearDown() {

        // TODO: 12/14/16  
    }

    @Test public void testFindOne() {
        Activity activity = activityService.findOne(1L);
        Assert.assertNotNull(activity);
        Assert.assertEquals("Running", activity.getName());
    }

    @Test public void testFindAll() {
        List<Activity> activities = activityService.findAll();
        Assert.assertEquals(2, activities.size());
    }
}
