package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;

public abstract class BasePage<T>{

    protected String baseUrl = "http://localhost:3000";

    private String getUrlPath() {
        UrlPath urlPath = getClass().getAnnotation(UrlPath.class);
        if(urlPath != null) {
            return urlPath.value();
        }

        return "";
    }

    public T open() {
        Selenide.open(baseUrl + getUrlPath());

        return (T)this;
    }
}
