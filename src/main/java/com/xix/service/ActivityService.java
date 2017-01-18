package com.xix.service;

import com.xix.model.Activity;
import java.util.List;

/**
 * Created by xix on 12/14/16.
 */
public interface ActivityService {

    /**
     * Find one activity.
     *
     * @param id the id
     * @return the activity
     */
    Activity findOne(long id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Activity> findAll();

    /**
     * Save activity.
     *
     * @param activity the activity
     * @return the activity
     */
    Activity save(Activity activity);

    /**
     * Find Activities by name list.
     *
     * @param name the name
     * @return the list
     */
    List<Activity> findByName(String name);

    /**
     * Delete activity.
     *
     * @param id the id
     * @return the activity
     */
    Activity delete(Long id);

    /**
     * Save list.
     *
     * @param activities the activities
     * @return the list
     */
    List<Activity> save(List<Activity> activities);
}
