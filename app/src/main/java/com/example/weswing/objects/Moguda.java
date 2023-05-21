package com.example.weswing.objects;

public class Moguda {

    String dataTop;

    String title;

    int imageID;

    String organitzat;

    String lloc;

    String duracio;

    String assistents;

    public Moguda(String dataTop, String title, int imageID, String organitzat, String lloc, String duracio, String assistents) {
        this.dataTop = dataTop;
        this.title = title;
        this.imageID = imageID;
        this.organitzat = organitzat;
        this.lloc = lloc;
        this.duracio = duracio;
        this.assistents = assistents;
    }

    public Moguda() {
    }

    public String getDataTop() {
        return dataTop;
    }

    public void setDataTop(String dataTop) {
        this.dataTop = dataTop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getOrganitzat() {
        return organitzat;
    }

    public void setOrganitzat(String organitzat) {
        this.organitzat = organitzat;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getAssistents() {
        return assistents;
    }

    public void setAssistents(String assistents) {
        this.assistents = assistents;
    }

    public String getDuracio() {
        return duracio;
    }

    public void setDuracio(String duracio) {
        this.duracio = duracio;
    }
}

