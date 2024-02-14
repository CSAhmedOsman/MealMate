package com.alharbi.mealmate.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable {

    @SerializedName("idCategory")
    private String idCategory;
    @SerializedName("strCategory")
    private String strCategory;
    @SerializedName("strCategoryThumb")
    private String strCategoryThumb;
    @SerializedName("strCategoryDescription")
    private String strCategoryDescription;
    public final static Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return (new Category[size]);
        }
    };

    protected Category(Parcel in) {
        this.idCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.strCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.strCategoryThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.strCategoryDescription = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Category() {
    }

    public Category(String idCategory, String strCategory, String strCategoryThumb, String strCategoryDescription) {
        super();
        this.idCategory = idCategory;
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
        this.strCategoryDescription = strCategoryDescription;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Category.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idCategory");
        sb.append('=');
        sb.append(((this.idCategory == null) ? "<null>" : this.idCategory));
        sb.append(',');
        sb.append("strCategory");
        sb.append('=');
        sb.append(((this.strCategory == null) ? "<null>" : this.strCategory));
        sb.append(',');
        sb.append("strCategoryThumb");
        sb.append('=');
        sb.append(((this.strCategoryThumb == null) ? "<null>" : this.strCategoryThumb));
        sb.append(',');
        sb.append("strCategoryDescription");
        sb.append('=');
        sb.append(((this.strCategoryDescription == null) ? "<null>" : this.strCategoryDescription));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idCategory);
        dest.writeValue(strCategory);
        dest.writeValue(strCategoryThumb);
        dest.writeValue(strCategoryDescription);
    }

    public int describeContents() {
        return 0;
    }
}