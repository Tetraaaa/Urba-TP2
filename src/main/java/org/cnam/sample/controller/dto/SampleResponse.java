package org.cnam.sample.controller.dto;

public class SampleResponse {

    public long id;

    public String data;

    public SampleResponse(long id, String data) {
        this.id = id;
        this.data = data;
    }
}
