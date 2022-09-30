package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectStateAndCityComponent {

    public SelectStateAndCityComponent setStateAndCity(String state, String city){
        $("#state").click();
        $(byText(state)).click();

        $("#city").click();
        $(byText(city)).click();
        return this;
    }


}
