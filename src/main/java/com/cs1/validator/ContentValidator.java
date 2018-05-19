package com.cs1.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cs1.viewobjects.ContentRequest;


@Component
public class ContentValidator {

    @Value("${app.list.badwords}")
    private String[] badWords ;
    
    private List<String> badWordsList ;
    
    @PostConstruct
    public void init() {
        badWordsList =Arrays.stream(badWords).collect(Collectors.toList());
    }
    
    public List<String>  validate(ContentRequest request) {
        String[] contentToken = request.getContent().split("\\s+");
        
        List<String>  badWordsUsed= Arrays.stream(contentToken)
                .filter(s->  badWordsList.contains(s))
                .collect(Collectors.toList());
        return badWordsUsed;
    }
    
    
}
