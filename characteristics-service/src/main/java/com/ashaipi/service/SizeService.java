package com.ashaipi.service;

import com.ashaipi.model.Size;
import com.ashaipi.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository){
        this.sizeRepository = sizeRepository;
    }

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
}
