package br.funkollection.webapi.domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public class FunkoDTO {
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String serie;

    @NotBlank
    private String category;

    @NotBlank
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
