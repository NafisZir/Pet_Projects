package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    // Указываем на сайт, который надо парсить
    Document doc = Jsoup.connect("https://www.google.com/search?newwindow=1&sxsrf=ALeKk00vkHzYQsP59u8-6_XJWPQKyY8ydA%3A1601454680314&ei=WEJ0X7jbEq2yrgTWuYXAAg&q=1+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80+%D0%B2+%D1%80%D1%83%D0%B1%D0%BB%D1%8F%D1%85&oq=1+&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMgQIIxAnMgQIIxAnMgUIABCxAzICCAAyBQgAELEDMgUIABCxAzICCAAyBQgAELEDMgUIABCxAzoHCCMQ6gIQJzoICAAQsQMQgwE6BQguELEDULaZJ1icnydg-6gnaAFwAXgAgAFsiAHXAZIBAzAuMpgBAKABAaoBB2d3cy13aXqwAQrAAQE&sclient=psy-ab")
                .get();
    // Находим класс с таким именем и получаем всю строку, в котором он есть
    Elements classElements = doc.getElementsByClass("DFlfde SwHCTb");
    // Получаем значение атрибута
    String attr = classElements.attr("data-value");

    public float usdPrice = Float. parseFloat(attr);
    public float rubPrice = 1/usdPrice;

    public Parser() throws IOException {
    }

    public float getUsdPrice() {
        return usdPrice;
    }

    public float getRubPrice() {
        return rubPrice;
    }
}