package com.example.readingfileapi.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class ConverterService {
    Logger logger = LoggerFactory.getLogger(ConverterService.class);

    public List<String> readFile(MultipartFile file){

        String name = "/Users/decagon/Downloads/" + file.getOriginalFilename();
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(name))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("result : {}",  result);
        String output = String.join(" ", result);

        List<String[]> rrr = new ArrayList<>();

        String[] b = output.split(" ");
//        logger.info("results : {}", b);

        for(var i : b){
            rrr.add(i.split(","));
        }
        List<String[]> finalResult = new ArrayList<>();
        for(var c : rrr){
            Arrays.sort(c);
            finalResult.add(c);
        }

        List<String> toStringResult = new ArrayList<>();
        for(var t : finalResult){
            toStringResult.add(String.join(",", t));
        }
        logger.info("results : {}", toStringResult);

        return toStringResult;
    }
}
