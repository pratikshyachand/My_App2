package com.example.myapp;

public class CustomViewBind {

    private int imgId;
    private String titleText;
    private String detailText;

    public CustomViewBind(int imgId,String titleText,String detailText)
    {
        this.imgId=imgId;
        this.titleText=titleText;
        this.detailText=detailText;
    }

    public int getImgId(){
        return  imgId;
    }
    public String getTitleText(){
        return  titleText;
    }
    public String getDetailText(){
        return  detailText;
    }

    public void setImgId(int imgId)
    {
        this.imgId= imgId;
    }
    public void setTitleText(String titleText)
    {
        this.titleText= titleText;
    }
    public void setDetailText(String detailText)
    {
        this.detailText=detailText ;
    }
}
