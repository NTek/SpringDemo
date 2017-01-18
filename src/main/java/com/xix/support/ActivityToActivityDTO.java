package com.xix.support;

import com.xix.model.Activity;
import com.xix.web.dto.ActivityDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by xix on 12/15/16.
 */
@Component
public class ActivityToActivityDTO implements Converter<Activity,ActivityDTO> {

    @Override
    public ActivityDTO convert(Activity activity) {
        if(activity==null){
            return null;
        }

        ActivityDTO dto = new ActivityDTO();

        dto.setId(activity.getId());
        dto.setName(activity.getName());

        return dto;
    }

    public List<ActivityDTO> convert(List<Activity> activities){
        List<ActivityDTO > dtos = new ArrayList<>();

        for(Activity a : activities){
            dtos.add(convert(a));
        }

        return dtos;
    }
}
