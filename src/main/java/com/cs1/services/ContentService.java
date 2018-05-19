package com.cs1.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cs1.viewobjects.ContentRequest;

@Service
public class ContentService {

    private Set<String> contents = new HashSet<>();
    public void store(ContentRequest request) {
        contents.add(request.getContent());
    }
}
