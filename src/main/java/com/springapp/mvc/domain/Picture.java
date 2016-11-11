package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Entity
@Table(name="pictures")
public class Picture {
    @Id
    @GeneratedValue
    @Column(name="picture_id")
    private int pictureId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    public Picture() {
    }

    public Picture(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
