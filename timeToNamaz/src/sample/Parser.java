package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.String;

import java.io.IOException;

public class Parser {
    // Указываем на сайт, который надо парсить
    Document doc = Jsoup.connect("https://www.vremyanamaza.ru/%D0%9A%D0%B0%D0%B7%D0%B0%D0%BD%D1%8C/%D0%B2%D1%80%D0%B5%D0%BC%D1%8F-%D0%BD%D0%B0%D0%BC%D0%B0%D0%B7%D0%B0-%D0%9A%D0%B0%D0%B7%D0%B0%D0%BD%D1%8C/12848-tat17")
            .get();
    // Получаем содержимое класса
    Elements classElement = doc.getElementsByClass("right floated content prayerTime");
    // Удаляем ненужные символы
    String time = classElement.text().replace(')', ' ');
    String[] t = time.split(" ");
    // Получаем время намазов в виде строки
    String timeFajr = t[0];
    String timeEndFajr = t[1];
    String timeZuhr = t[2];
    String timeAsrKhanafi = t[5];
    String timeAsr = t[7];
    String timeMagrib = t[8];
    String timeIsha = t[17];
    String timeMidNight = t[10];
    String timeThirdPartNight = t[15];

    public String getTimeFajr() {
        return timeFajr;
    }

    public String getTimeEndFajr() {
        return timeEndFajr;
    }

    public String getTimeZuhr() {
        return timeZuhr;
    }

    public String getTimeAsrKhanafi() {
        return timeAsrKhanafi;
    }

    public String getTimeAsr() {
        return timeAsr;
    }

    public String getTimeMagrib() {
        return timeMagrib;
    }

    public String getTimeIsha() {
        return timeIsha;
    }

    public String getTimeMidNight() {
        return timeMidNight;
    }

    public String getTimeThirdPartNight() {
        return timeThirdPartNight;
    }

    public Parser() throws IOException {
    }
}
