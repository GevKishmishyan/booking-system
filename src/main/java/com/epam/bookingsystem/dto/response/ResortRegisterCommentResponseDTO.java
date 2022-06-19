package com.epam.bookingsystem.dto.response;

public class ResortRegisterCommentResponseDTO extends ResponseDTO{

    long id;

    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ResortRegisterCommentResponseDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
