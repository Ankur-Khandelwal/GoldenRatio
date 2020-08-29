package com.example.secondprototype;

/*This is the Model class*/

public class Model {
    private String Name;                             //For the name stored in Firebase Database
    private String imgURL;                           //For the image URL in Firebase Databse
    private String vidURL;                           //For the video URL in Firebase Database

    public Model() {                                 //Empty Constructor
    }

    public Model(String name, String imgURL, String vidURL) {           //Parameterised constructor for initializing the variables
        Name = name;
        this.imgURL = imgURL;
        this.vidURL = vidURL;
    }

    public String getName() {                           //Getter for name
        return Name;
    }

    public void setName(String name) {                 //Setter for name
        Name = name;
    }


    public String getImgURL() {                         //Getter for image URL
        return imgURL;
    }

    public void setImgURL(String imgURL) {               //Setter for image URL
        this.imgURL = imgURL;
    }

    public String getVidURL() {                         //Getter for video URL
        return vidURL;
    }

    public void setVidURL(String vidURL) {              //Setter for video URL
        this.vidURL = vidURL;
    }
}
