package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleToCreateRequest {

    public String data;

    @JsonCreator
    public SampleToCreateRequest(@JsonProperty("data") String data) {
        this.data = data;
    }
}
