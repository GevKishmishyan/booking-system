package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ResortRegisterCommentRequestDTO extends RequestDto {

    @NotBlank
    private String comment;

    @NotNull
    Long resortRegisterId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getResortRegisterId() {
        return resortRegisterId;
    }

    public void setResortRegisterId(Long resortRegisterId) {
        this.resortRegisterId = resortRegisterId;
    }

    @Override
    public String toString() {
        return "ResortRegisterCommentRequestDTO{" +
                "comment='" + comment + '\'' +
                ", resortRegisterId=" + resortRegisterId +
                '}';
    }

}
