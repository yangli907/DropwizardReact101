package com.yangli907.phome.model;

import java.sql.Timestamp;

public class Review {
    private int id;
    private String fromUser;
    private String toUser;
    private int score;
    private String text;
    private boolean isActive;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    public Review() {
    }

    public Review(int id, String fromUser, String toUser, int score, String text, boolean isActive, Timestamp createdTime,
        Timestamp updatedTime) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.score = score;
        this.text = text;
        this.isActive = isActive;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public static final class ReviewBuilder {
        private int id;
        private String fromUser;
        private String toUser;
        private int score;
        private String text;
        private boolean isActive;
        private Timestamp createdTime;
        private Timestamp updatedTime;

        public ReviewBuilder() {
        }

        public static ReviewBuilder aReview() {
            return new ReviewBuilder();
        }

        public ReviewBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder withFromUser(String fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        public ReviewBuilder withToUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public ReviewBuilder withScore(int score) {
            this.score = score;
            return this;
        }

        public ReviewBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public ReviewBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ReviewBuilder withCreatedTime(Timestamp createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public ReviewBuilder withUpdatedTime(Timestamp updatedTime) {
            this.updatedTime = updatedTime;
            return this;
        }

        public Review build() {
            return new Review(id, fromUser, toUser, score, text, isActive, createdTime, updatedTime);
        }
    }
}
