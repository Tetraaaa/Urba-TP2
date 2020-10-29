package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Sample;
import org.cnam.sample.domain.entity.SampleToCreate;
import org.cnam.sample.repository.SampleRepository;
import org.cnam.sample.repository.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public Sample getById(Long id) {
        SampleModel sampleModelFound = sampleRepository.getOne(id);

        return new Sample(sampleModelFound.getId(), sampleModelFound.getData());
    }

    public Sample create(SampleToCreate sampleToCreate) {
        SampleModel sampleModelToCreate = new SampleModel(sampleToCreate.data);

        SampleModel sampleModelCreated = sampleRepository.save(sampleModelToCreate);

        return new Sample(sampleModelCreated.getId(), sampleModelCreated.getData());
    }

}
