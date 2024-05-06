package com.ashaipi.controller;

import com.ashaipi.model.Color;
import com.ashaipi.model.State;
import com.ashaipi.service.ColorService;
import com.ashaipi.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping("/allstates")
    public ResponseEntity<List<State>> getStates(){
        List<State> stateList = stateService.getAllStates();
        return ResponseEntity.ok(stateList);
    }
}
