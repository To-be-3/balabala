package com.balabala.balabala.domain;

import javax.persistence.*;
import java.awt.*;

@Entity
public class ProjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pdId;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;
    private String title;
    private String image;
    private String introduction;

    @Override
    public String toString() {
        return "ProjectDetail{" +
                "pdId=" + pdId +
                ", project=" + project +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
