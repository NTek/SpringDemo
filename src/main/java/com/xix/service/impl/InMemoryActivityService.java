package com.xix.service.impl;

import com.xix.model.Activity;
import com.xix.service.ActivityService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Created by xix on 12/14/16.
 */
@Service
public class InMemoryActivityService implements ActivityService {

    private Map<Long, Activity> activities = new HashMap<>();
    private long nextId = 1L;

    @Override public Activity findOne(long id) {

        return activities.get(id);
    }

    @Override public List<Activity> findAll() {
        return new ArrayList<>(activities.values());
    }

    @Override public Activity save(Activity activity) {
        if (activity.getId() == null) {
            activity.setId(nextId++);
        }
        activities.put(activity.getId(), activity);
        return activity;
    }


    @Override public Activity delete(Long id) {
        if (!activities.containsKey(id)) {
            throw new IllegalArgumentException("Tried to remove non existent activity.");
        }

        Activity activity = activities.remove(id);
        return activity;
    }

    @Override public List<Activity> findByName(String name) {
        List<Activity> ret = new ArrayList<>();

        for (Activity a : activities.values()) {
            if (name.contains(a.getName())) {
                ret.add(a);
            }
        }

        return ret;
    }

    @Override public List<Activity> save(List<Activity> activities) {
        List<Activity> ret = new ArrayList<>();

        for (Activity a : activities) {
            //za svaku prosleđenu aktivnost pozivamo save
            //metodu koju smo već napravili i testirali -
            //ona će sepobrinuti i za dodelu ID-eva
            //ako je to potrebno
            Activity saved = save(a);

            //uspešno snimljene dodajemo u listu za vraćanje
            if (saved != null) {
                ret.add(saved);
            }
        }

        return ret;
    }
}
