package com.json.Json_Manager;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {
    // No-Argument Constructor
    public Language() {}

    //------------------------------------------------------------------------------------------------------------

    // All-Argument Constructor
    public Language(String languageName, int scoreOutOf100) {
        this.languageName = languageName;
        this.scoreOutOf100 = scoreOutOf100;
    }

    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("LanguageName")
    private String languageName;

    @JsonProperty("ScoreOutof100")
    private int scoreOutOf100;

    // Getter for languageName
    public String getLanguageName() {
        return languageName;
    }

    // Setter for languageName
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    //------------------------------------------------------------------------------------------------------------

    // Getter for scoreOutOf100
    public int getScoreOutOf100() {
        return scoreOutOf100;
    }

    // Setter for scoreOutOf100
    public void setScoreOutOf100(int scoreOutOf100) {
        this.scoreOutOf100 = scoreOutOf100;
    }

    //------------------------------------------------------------------------------------------------------------

}
