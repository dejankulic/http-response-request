package http;

import http.HttpMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Request {

    private final HttpMethod httpMethod;

    private final String path;

    private static ArrayList<String> citati_temp = new ArrayList<String>();
    private static ArrayList<String> autori_temp = new ArrayList<String>();

    public Request(HttpMethod httpMethod, String path, ArrayList<String> citati_temp, ArrayList<String> autori_temp) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.citati_temp = citati_temp;
        this.autori_temp = autori_temp;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getPath() {
        return path;
    }

    public String getQuoteOOD(){
        if(citati_temp.size()>= 1) {
            Random r = new Random();
            int br = r.nextInt(citati_temp.size());
            return citati_temp.get(br);
        }
        return "Nema citata";
    }

    public String getQuotes(){
        StringBuilder str = new StringBuilder();

        str.append("<ul class=\"list-group\">\n");
        for(int i = 0 ; i < citati_temp.size() ;i++){
            str.append(" <li class=\"list-group-item\">");
            str.append(autori_temp.get(i) + ": " + citati_temp.get(i));
            str.append("</li>");
        }
        str.append("</ul>");
        return str.toString();
    }
    public void dodaj(String citat, String autor){
        citati_temp.add(citat);
        autori_temp.add(autor);
    }
}
