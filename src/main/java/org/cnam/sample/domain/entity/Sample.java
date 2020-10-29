package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Sample {

    public Long id;

    public String data;

    public Sample(Long id, String data) {
        this.id = id;
        this.data = data;
    }

}
