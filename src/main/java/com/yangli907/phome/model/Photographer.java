package com.yangli907.phome.model;

import java.sql.Timestamp;

import com.yangli907.phome.model.enums.PhotographerCategory;

public class Photographer {
    private int id;
    private String userId;
    private String name;
    private PhotographerCategory category;
    private String location;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Photographer(int id, String userId, String name, PhotographerCategory category, String location, Timestamp createdAt,
        Timestamp updatedAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.category = category;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Photographer() {
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public PhotographerCategory getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(PhotographerCategory category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class PhotographerBuilder {
        private int id;
        private String userId;
        private String name;
        private PhotographerCategory category;
        private String location;
        private Timestamp createdAt;
        private Timestamp updatedAt;

        private PhotographerBuilder() {
        }

        public static PhotographerBuilder aPhotographer() {
            return new PhotographerBuilder();
        }

        public PhotographerBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public PhotographerBuilder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public PhotographerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PhotographerBuilder withCategory(PhotographerCategory category) {
            this.category = category;
            return this;
        }

        public PhotographerBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        public PhotographerBuilder withCreatedAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PhotographerBuilder withUpdatedAt(Timestamp updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Photographer build() {
            Photographer photographer = new Photographer();
            photographer.setId(id);
            photographer.setUserId(userId);
            photographer.setName(name);
            photographer.setCategory(category);
            photographer.setLocation(location);
            photographer.setCreatedAt(createdAt);
            photographer.setUpdatedAt(updatedAt);
            return photographer;
        }
    }
}
