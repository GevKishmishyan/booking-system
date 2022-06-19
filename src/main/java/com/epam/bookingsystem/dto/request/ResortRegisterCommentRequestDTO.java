package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;

public class ResortRegisterCommentRequestDTO extends RequestDto {

    @NotBlank
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ResortRegisterCommentRequestDTO{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
