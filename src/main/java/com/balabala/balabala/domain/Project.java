package com.balabala.balabala.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "companyId")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "designerId")
    private Technician designer;
    public enum Type{
        一居,二居,三居,四居,复式;//枚举中常量结束位置要有分号
        public static List<String> toList(){
            Project.Type[] types= Project.Type.values();
            List<String> list=new ArrayList<>();
            for(Project.Type t:types){
                list.add(t.name());
            }
            return list;
        }
    };
    private Type houseType;
    public enum Style{
        简约,现代,中式,简欧,美式,北欧;//枚举中常量结束位置要有分号
        public static List<String> toList(){
            Project.Style[] styles= Project.Style.values();
            List<String> list=new ArrayList<>();
            for(Project.Style s:styles){
                list.add(s.name());
            }
            return list;
        }
    };
    private Style style;
    private double area;
    private double price;
    public enum Method{
        简约,现代,中式,简欧,美式,北欧;//枚举中常量结束位置要有分号
        public static List<String> toList(){
            Project.Method[] methods= Project.Method.values();
            List<String> list=new ArrayList<>();
            for(Project.Method m:methods){
                list.add(m.name());
            }
            return list;
        }
    };
    private Method method;
    private Integer time;//工期
    private String address;
    @ManyToMany(cascade = {CascadeType.ALL})
    @Nullable
    @JoinTable(name = "technicianProject", joinColumns = @JoinColumn(name = "projectId"),inverseJoinColumns = @JoinColumn(name = "technicianId"))
    private Set<Technician> technicians=new HashSet<>();

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", company=" + company +
                ", designer=" + designer +
                ", houseType=" + houseType +
                ", style=" + style +
                ", area=" + area +
                ", price=" + price +
                ", method=" + method +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", technicians=" + technicians +
                '}';
    }

    public Set<Technician> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(Set<Technician> technicians) {
        this.technicians = technicians;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Technician getDesigner() {
        return designer;
    }

    public void setDesigner(Technician designer) {
        this.designer = designer;
    }

    public Type getHouseType() {
        return houseType;
    }

    public void setHouseType(Type houseType) {
        this.houseType = houseType;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
