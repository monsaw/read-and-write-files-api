package com.example.readingfileapi.controller;


import com.example.readingfileapi.service.ConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ConverterController {

   private final ConverterService converterService;

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/convert")
    public ResponseEntity<List<String>> readFiles(@ModelAttribute MultipartFile file){
      return ResponseEntity.ok(converterService.readFile(file));
    }
}
