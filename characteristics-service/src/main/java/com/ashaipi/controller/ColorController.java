package com.ashaipi.controller;

import com.ashaipi.model.Color;
import com.ashaipi.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @RequestMapping("/allcolors")
    public ResponseEntity<List<Color>> getColors(){
        List<Color> colorList = colorService.getAllColors();
        return ResponseEntity.ok(colorList);
    }
}
