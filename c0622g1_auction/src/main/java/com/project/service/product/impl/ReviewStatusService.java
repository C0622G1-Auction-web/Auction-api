package com.project.service.product.impl;

import com.project.repository.product.IReviewStatusRepository;
import com.project.service.product.IReviewStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewStatusService implements IReviewStatusService {
    @Autowired
    private IReviewStatusRepository reviewStatusRepository;
}
