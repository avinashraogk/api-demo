package com.cs1.viewobjects;

import javax.validation.constraints.NotNull;

public class ContentRequest {

    @NotNull(message="content should not be null")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
