package com.alharbi.mealmate.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "meal")
public class Meal implements Parcelable {

    @PrimaryKey
    @NonNull
    @SerializedName("idMeal")
    private String idMeal;
    @SerializedName("strMeal")
    private String strMeal;
    @SerializedName("strDrinkAlternate")
    private String strDrinkAlternate;
    @SerializedName("strCategory")
    private String strCategory;
    @SerializedName("strArea")
    private String strArea;
    @SerializedName("strInstructions")
    private String strInstructions;
    @SerializedName("strMealThumb")
    private String strMealThumb;
    @SerializedName("strTags")
    private String strTags;
    @SerializedName("strYoutube")
    private String strYoutube;
    @SerializedName("strIngredient1")
    private String strIngredient1;
    @SerializedName("strIngredient2")
    private String strIngredient2;
    @SerializedName("strIngredient3")
    private String strIngredient3;
    @SerializedName("strIngredient4")
    private String strIngredient4;
    @SerializedName("strIngredient5")
    private String strIngredient5;
    @SerializedName("strIngredient6")
    private String strIngredient6;
    @SerializedName("strIngredient7")
    private String strIngredient7;
    @SerializedName("strIngredient8")
    private String strIngredient8;
    @SerializedName("strIngredient9")
    private String strIngredient9;
    @SerializedName("strIngredient10")
    private String strIngredient10;
    @SerializedName("strIngredient11")
    private String strIngredient11;
    @SerializedName("strIngredient12")
    private String strIngredient12;
    @SerializedName("strIngredient13")
    private String strIngredient13;
    @SerializedName("strIngredient14")
    private String strIngredient14;
    @SerializedName("strIngredient15")
    private String strIngredient15;
    @SerializedName("strIngredient16")
    private String strIngredient16;
    @SerializedName("strIngredient17")
    private String strIngredient17;
    @SerializedName("strIngredient18")
    private String strIngredient18;
    @SerializedName("strIngredient19")
    private String strIngredient19;
    @SerializedName("strIngredient20")
    private String strIngredient20;
    @SerializedName("strMeasure1")
    private String strMeasure1;
    @SerializedName("strMeasure2")
    private String strMeasure2;
    @SerializedName("strMeasure3")
    private String strMeasure3;
    @SerializedName("strMeasure4")
    private String strMeasure4;
    @SerializedName("strMeasure5")
    private String strMeasure5;
    @SerializedName("strMeasure6")
    private String strMeasure6;
    @SerializedName("strMeasure7")
    private String strMeasure7;
    @SerializedName("strMeasure8")
    private String strMeasure8;
    @SerializedName("strMeasure9")
    private String strMeasure9;
    @SerializedName("strMeasure10")
    private String strMeasure10;
    @SerializedName("strMeasure11")
    private String strMeasure11;
    @SerializedName("strMeasure12")
    private String strMeasure12;
    @SerializedName("strMeasure13")
    private String strMeasure13;
    @SerializedName("strMeasure14")
    private String strMeasure14;
    @SerializedName("strMeasure15")
    private String strMeasure15;
    @SerializedName("strMeasure16")
    private String strMeasure16;
    @SerializedName("strMeasure17")
    private String strMeasure17;
    @SerializedName("strMeasure18")
    private String strMeasure18;
    @SerializedName("strMeasure19")
    private String strMeasure19;
    @SerializedName("strMeasure20")
    private String strMeasure20;
    @SerializedName("strSource")
    private String strSource;
    @SerializedName("strImageSource")
    private String strImageSource;
    @SerializedName("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;
    public final static Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return (new Meal[size]);
        }
    };

    @Ignore
    protected Meal(Parcel in) {
        this.idMeal = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeal = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkAlternate = ((String) in.readValue((String.class.getClassLoader())));
        this.strCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.strArea = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructions = ((String) in.readValue((String.class.getClassLoader())));
        this.strMealThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.strTags = ((String) in.readValue((String.class.getClassLoader())));
        this.strYoutube = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient1 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient2 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient3 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient4 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient5 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient6 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient7 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient8 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient9 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient10 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient11 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient12 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient13 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient14 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient15 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient16 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient17 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient18 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient19 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient20 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure1 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure2 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure3 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure4 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure5 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure6 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure7 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure8 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure9 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure10 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure11 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure12 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure13 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure14 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure15 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure16 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure17 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure18 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure19 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure20 = ((String) in.readValue((String.class.getClassLoader())));
        this.strSource = ((String) in.readValue((String.class.getClassLoader())));
        this.strImageSource = ((String) in.readValue((String.class.getClassLoader())));
        this.strCreativeCommonsConfirmed = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Meal() {
        idMeal = "";
    }

    @Ignore
    public Meal(String idMeal, String strMeal, String strDrinkAlternate, String strCategory,
                String strArea, String strInstructions, String strMealThumb, String strTags,
                String strYoutube, String strIngredient1, String strIngredient2,
                String strIngredient3, String strIngredient4, String strIngredient5,
                String strIngredient6, String strIngredient7, String strIngredient8,
                String strIngredient9, String strIngredient10, String strIngredient11,
                String strIngredient12, String strIngredient13, String strIngredient14,
                String strIngredient15, String strIngredient16, String strIngredient17,
                String strIngredient18, String strIngredient19, String strIngredient20,
                String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4,
                String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8,
                String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12,
                String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16,
                String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20,
                String strSource, String strImageSource, String strCreativeCommonsConfirmed) {
        super();
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
        this.strSource = strSource;
        this.strImageSource = strImageSource;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public void setStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public void setStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public void setStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public void setStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public void setStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idMeal);
        dest.writeValue(strMeal);
        dest.writeValue(strDrinkAlternate);
        dest.writeValue(strCategory);
        dest.writeValue(strArea);
        dest.writeValue(strInstructions);
        dest.writeValue(strMealThumb);
        dest.writeValue(strTags);
        dest.writeValue(strYoutube);
        dest.writeValue(strIngredient1);
        dest.writeValue(strIngredient2);
        dest.writeValue(strIngredient3);
        dest.writeValue(strIngredient4);
        dest.writeValue(strIngredient5);
        dest.writeValue(strIngredient6);
        dest.writeValue(strIngredient7);
        dest.writeValue(strIngredient8);
        dest.writeValue(strIngredient9);
        dest.writeValue(strIngredient10);
        dest.writeValue(strIngredient11);
        dest.writeValue(strIngredient12);
        dest.writeValue(strIngredient13);
        dest.writeValue(strIngredient14);
        dest.writeValue(strIngredient15);
        dest.writeValue(strIngredient16);
        dest.writeValue(strIngredient17);
        dest.writeValue(strIngredient18);
        dest.writeValue(strIngredient19);
        dest.writeValue(strIngredient20);
        dest.writeValue(strMeasure1);
        dest.writeValue(strMeasure2);
        dest.writeValue(strMeasure3);
        dest.writeValue(strMeasure4);
        dest.writeValue(strMeasure5);
        dest.writeValue(strMeasure6);
        dest.writeValue(strMeasure7);
        dest.writeValue(strMeasure8);
        dest.writeValue(strMeasure9);
        dest.writeValue(strMeasure10);
        dest.writeValue(strMeasure11);
        dest.writeValue(strMeasure12);
        dest.writeValue(strMeasure13);
        dest.writeValue(strMeasure14);
        dest.writeValue(strMeasure15);
        dest.writeValue(strMeasure16);
        dest.writeValue(strMeasure17);
        dest.writeValue(strMeasure18);
        dest.writeValue(strMeasure19);
        dest.writeValue(strMeasure20);
        dest.writeValue(strSource);
        dest.writeValue(strImageSource);
        dest.writeValue(strCreativeCommonsConfirmed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Meal.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idMeal");
        sb.append('=');
        sb.append(((this.idMeal == null) ? "<null>" : this.idMeal));
        sb.append(',');
        sb.append("strMeal");
        sb.append('=');
        sb.append(((this.strMeal == null) ? "<null>" : this.strMeal));
        sb.append(',');
        sb.append("strDrinkAlternate");
        sb.append('=');
        sb.append(((this.strDrinkAlternate == null) ? "<null>" : this.strDrinkAlternate));
        sb.append(',');
        sb.append("strCategory");
        sb.append('=');
        sb.append(((this.strCategory == null) ? "<null>" : this.strCategory));
        sb.append(',');
        sb.append("strArea");
        sb.append('=');
        sb.append(((this.strArea == null) ? "<null>" : this.strArea));
        sb.append(',');
        sb.append("strInstructions");
        sb.append('=');
        sb.append(((this.strInstructions == null) ? "<null>" : this.strInstructions));
        sb.append(',');
        sb.append("strMealThumb");
        sb.append('=');
        sb.append(((this.strMealThumb == null) ? "<null>" : this.strMealThumb));
        sb.append(',');
        sb.append("strTags");
        sb.append('=');
        sb.append(((this.strTags == null) ? "<null>" : this.strTags));
        sb.append(',');
        sb.append("strYoutube");
        sb.append('=');
        sb.append(((this.strYoutube == null) ? "<null>" : this.strYoutube));
        sb.append(',');
        sb.append("strIngredient1");
        sb.append('=');
        sb.append(((this.strIngredient1 == null) ? "<null>" : this.strIngredient1));
        sb.append(',');
        sb.append("strIngredient2");
        sb.append('=');
        sb.append(((this.strIngredient2 == null) ? "<null>" : this.strIngredient2));
        sb.append(',');
        sb.append("strIngredient3");
        sb.append('=');
        sb.append(((this.strIngredient3 == null) ? "<null>" : this.strIngredient3));
        sb.append(',');
        sb.append("strIngredient4");
        sb.append('=');
        sb.append(((this.strIngredient4 == null) ? "<null>" : this.strIngredient4));
        sb.append(',');
        sb.append("strIngredient5");
        sb.append('=');
        sb.append(((this.strIngredient5 == null) ? "<null>" : this.strIngredient5));
        sb.append(',');
        sb.append("strIngredient6");
        sb.append('=');
        sb.append(((this.strIngredient6 == null) ? "<null>" : this.strIngredient6));
        sb.append(',');
        sb.append("strIngredient7");
        sb.append('=');
        sb.append(((this.strIngredient7 == null) ? "<null>" : this.strIngredient7));
        sb.append(',');
        sb.append("strIngredient8");
        sb.append('=');
        sb.append(((this.strIngredient8 == null) ? "<null>" : this.strIngredient8));
        sb.append(',');
        sb.append("strIngredient9");
        sb.append('=');
        sb.append(((this.strIngredient9 == null) ? "<null>" : this.strIngredient9));
        sb.append(',');
        sb.append("strIngredient10");
        sb.append('=');
        sb.append(((this.strIngredient10 == null) ? "<null>" : this.strIngredient10));
        sb.append(',');
        sb.append("strIngredient11");
        sb.append('=');
        sb.append(((this.strIngredient11 == null) ? "<null>" : this.strIngredient11));
        sb.append(',');
        sb.append("strIngredient12");
        sb.append('=');
        sb.append(((this.strIngredient12 == null) ? "<null>" : this.strIngredient12));
        sb.append(',');
        sb.append("strIngredient13");
        sb.append('=');
        sb.append(((this.strIngredient13 == null) ? "<null>" : this.strIngredient13));
        sb.append(',');
        sb.append("strIngredient14");
        sb.append('=');
        sb.append(((this.strIngredient14 == null) ? "<null>" : this.strIngredient14));
        sb.append(',');
        sb.append("strIngredient15");
        sb.append('=');
        sb.append(((this.strIngredient15 == null) ? "<null>" : this.strIngredient15));
        sb.append(',');
        sb.append("strIngredient16");
        sb.append('=');
        sb.append(((this.strIngredient16 == null) ? "<null>" : this.strIngredient16));
        sb.append(',');
        sb.append("strIngredient17");
        sb.append('=');
        sb.append(((this.strIngredient17 == null) ? "<null>" : this.strIngredient17));
        sb.append(',');
        sb.append("strIngredient18");
        sb.append('=');
        sb.append(((this.strIngredient18 == null) ? "<null>" : this.strIngredient18));
        sb.append(',');
        sb.append("strIngredient19");
        sb.append('=');
        sb.append(((this.strIngredient19 == null) ? "<null>" : this.strIngredient19));
        sb.append(',');
        sb.append("strIngredient20");
        sb.append('=');
        sb.append(((this.strIngredient20 == null) ? "<null>" : this.strIngredient20));
        sb.append(',');
        sb.append("strMeasure1");
        sb.append('=');
        sb.append(((this.strMeasure1 == null) ? "<null>" : this.strMeasure1));
        sb.append(',');
        sb.append("strMeasure2");
        sb.append('=');
        sb.append(((this.strMeasure2 == null) ? "<null>" : this.strMeasure2));
        sb.append(',');
        sb.append("strMeasure3");
        sb.append('=');
        sb.append(((this.strMeasure3 == null) ? "<null>" : this.strMeasure3));
        sb.append(',');
        sb.append("strMeasure4");
        sb.append('=');
        sb.append(((this.strMeasure4 == null) ? "<null>" : this.strMeasure4));
        sb.append(',');
        sb.append("strMeasure5");
        sb.append('=');
        sb.append(((this.strMeasure5 == null) ? "<null>" : this.strMeasure5));
        sb.append(',');
        sb.append("strMeasure6");
        sb.append('=');
        sb.append(((this.strMeasure6 == null) ? "<null>" : this.strMeasure6));
        sb.append(',');
        sb.append("strMeasure7");
        sb.append('=');
        sb.append(((this.strMeasure7 == null) ? "<null>" : this.strMeasure7));
        sb.append(',');
        sb.append("strMeasure8");
        sb.append('=');
        sb.append(((this.strMeasure8 == null) ? "<null>" : this.strMeasure8));
        sb.append(',');
        sb.append("strMeasure9");
        sb.append('=');
        sb.append(((this.strMeasure9 == null) ? "<null>" : this.strMeasure9));
        sb.append(',');
        sb.append("strMeasure10");
        sb.append('=');
        sb.append(((this.strMeasure10 == null) ? "<null>" : this.strMeasure10));
        sb.append(',');
        sb.append("strMeasure11");
        sb.append('=');
        sb.append(((this.strMeasure11 == null) ? "<null>" : this.strMeasure11));
        sb.append(',');
        sb.append("strMeasure12");
        sb.append('=');
        sb.append(((this.strMeasure12 == null) ? "<null>" : this.strMeasure12));
        sb.append(',');
        sb.append("strMeasure13");
        sb.append('=');
        sb.append(((this.strMeasure13 == null) ? "<null>" : this.strMeasure13));
        sb.append(',');
        sb.append("strMeasure14");
        sb.append('=');
        sb.append(((this.strMeasure14 == null) ? "<null>" : this.strMeasure14));
        sb.append(',');
        sb.append("strMeasure15");
        sb.append('=');
        sb.append(((this.strMeasure15 == null) ? "<null>" : this.strMeasure15));
        sb.append(',');
        sb.append("strMeasure16");
        sb.append('=');
        sb.append(((this.strMeasure16 == null) ? "<null>" : this.strMeasure16));
        sb.append(',');
        sb.append("strMeasure17");
        sb.append('=');
        sb.append(((this.strMeasure17 == null) ? "<null>" : this.strMeasure17));
        sb.append(',');
        sb.append("strMeasure18");
        sb.append('=');
        sb.append(((this.strMeasure18 == null) ? "<null>" : this.strMeasure18));
        sb.append(',');
        sb.append("strMeasure19");
        sb.append('=');
        sb.append(((this.strMeasure19 == null) ? "<null>" : this.strMeasure19));
        sb.append(',');
        sb.append("strMeasure20");
        sb.append('=');
        sb.append(((this.strMeasure20 == null) ? "<null>" : this.strMeasure20));
        sb.append(',');
        sb.append("strSource");
        sb.append('=');
        sb.append(((this.strSource == null) ? "<null>" : this.strSource));
        sb.append(',');
        sb.append("strImageSource");
        sb.append('=');
        sb.append(((this.strImageSource == null) ? "<null>" : this.strImageSource));
        sb.append(',');
        sb.append("strCreativeCommonsConfirmed");
        sb.append('=');
        sb.append(((this.strCreativeCommonsConfirmed == null) ? "<null>" : this.strCreativeCommonsConfirmed));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
