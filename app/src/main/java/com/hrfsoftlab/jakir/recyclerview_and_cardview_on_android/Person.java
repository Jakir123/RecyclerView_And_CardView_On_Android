package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android;

/**
 * @author Jakir Hossain
 * @version 1.3.0
 * @desc description of the class
 * @link n/a
 * @created on 21-Oct-15
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class Person {
    private String name;
    private String age;
    private int photoId;

    public Person(String name, String age, int photoId) {
        setName(name);
        setAge(age);
        setPhotoId(photoId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
