package com.xix.web.controller;

import com.xix.model.Activity;
import com.xix.service.ActivityService;
import com.xix.support.ActivityDTOToActivity;
import com.xix.support.ActivityToActivityDTO;
import com.xix.web.dto.ActivityDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/activities")
public class ApiActivityController {
    @Autowired private ActivityService activityService;
    @Autowired private ActivityToActivityDTO toDTO;
    @Autowired private ActivityDTOToActivity toActivity;

    @RequestMapping(method = RequestMethod.GET) ResponseEntity<List<ActivityDTO>> getActivities() {

        List<Activity> activities = activityService.findAll();

        if (activities == null || activities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDTO.convert(activities), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = "name") ResponseEntity<List<ActivityDTO>> getActivities(
        @RequestParam String name) {

        List<Activity> activities = activityService.findByName(name);

        if (activities == null || activities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDTO.convert(activities), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id) {
        Activity activity = activityService.findOne(id);
        if (activity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDTO.convert(activity), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) ResponseEntity<ActivityDTO> delete(@PathVariable Long id) {
        if (activityService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Activity deleted = activityService.delete(id);

        return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
    }

    /**
     * Add new  Activity.
     *
     * @param activityDto the new activity
     * @return created activity
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json") public ResponseEntity<ActivityDTO> add(
        @RequestBody ActivityDTO activityDto) {
        Activity savedActivity = activityService.save(toActivity.convert(activityDto));

        return new ResponseEntity<>(toDTO.convert(savedActivity), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
    public ResponseEntity<ActivityDTO> edit(@RequestBody ActivityDTO activityDTO, @PathVariable Long id) {

        if (id != activityDTO.getId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Activity persisted = activityService.save(toActivity.convert(activityDTO));

        return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
    }
}
