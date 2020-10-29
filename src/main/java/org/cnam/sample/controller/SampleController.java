package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.SampleToCreateRequest;
import org.cnam.sample.controller.dto.SampleResponse;
import org.cnam.sample.domain.SampleService;
import org.cnam.sample.domain.entity.Sample;
import org.cnam.sample.domain.entity.SampleToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<SampleResponse> getSample(@PathVariable("id") long id) {
        Sample sampleFound = sampleService.getById(id);

        SampleResponse sampleResponse = new SampleResponse(sampleFound.id, sampleFound.data);

        return new ResponseEntity<>(sampleResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<SampleResponse> createSample(@RequestBody SampleToCreateRequest sampleToCreateRequest) {
        SampleToCreate sampleToCreate = new SampleToCreate(sampleToCreateRequest.data);

        Sample sampleCreated = sampleService.create(sampleToCreate);

        SampleResponse sampleResponse = new SampleResponse(sampleCreated.id, sampleCreated.data);

        return new ResponseEntity<>(sampleResponse, HttpStatus.OK);
    }

}
