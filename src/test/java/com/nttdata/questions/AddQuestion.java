package com.nttdata.questions;

import com.nttdata.pages.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class AddQuestion {

    public static Question<String> errorMessage(){
        return actor -> TextContent.of(HomePage.ERROR_TEXT).answeredBy(actor);
    }
}
