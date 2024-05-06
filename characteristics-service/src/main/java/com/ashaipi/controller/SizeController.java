package com.ashaipi.controller;

import com.ashaipi.model.Color;
import com.ashaipi.model.Size;
import com.ashaipi.service.ColorService;
import com.ashaipi.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SizeController {

    private final SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @RequestMapping("/allsizes")
    public ResponseEntity<List<Size>> getSizes(){
        List<Size> sizeList = sizeService.getAllSizes();
        return ResponseEntity.ok(sizeList);
    }
}
