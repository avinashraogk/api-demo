package com.cs1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs1.services.ContentService;
import com.cs1.validator.ContentValidator;
import com.cs1.viewobjects.ContentRequest;
import com.cs1.viewobjects.ContentResponse;

@RestController
@RequestMapping("/contents")

public class ContentController {

    @Autowired
    private ContentValidator contentValidator;
    
    @Autowired
    private ContentService contentService;
    
    @RequestMapping(method=RequestMethod.POST)
    public ContentResponse createContent(@RequestBody @Validated ContentRequest request) {
        List<String> badWordsUsed = contentValidator.validate(request);
        ContentResponse response = new ContentResponse();
        if(badWordsUsed.isEmpty()) {
            contentService.store(request);
            response.setStatus("content Accepted!");
            return response;
        }
        response.setStatus("content rejected! please dont Use: "+badWordsUsed);
        return response;
    }
}
