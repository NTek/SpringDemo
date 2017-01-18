package com.xix.support;

import com.xix.model.Activity;
import com.xix.service.ActivityService;
import com.xix.web.dto.ActivityDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by xix on 12/15/16.
 */
@Component
public class ActivityDTOToActivity implements Converter<ActivityDTO, Activity> {
    @Autowired private ActivityService activityService;

    @Override public Activity convert(ActivityDTO dto) {
        Activity activity = null;
        if (dto.getId() != null) {
            activity = activityService.findOne(dto.getId());
        }

        if (activity == null) {
            activity = new Activity();
        }
        activity.setId(dto.getId());
        activity.setName(dto.getName());

        return activity;
    }

    public List<Activity> convert(List<ActivityDTO> dtos) {
        List<Activity> activities = new ArrayList<>();

        for (ActivityDTO dto : dtos) {
            activities.add(convert(dto));
        }
        return activities;
    }
}
