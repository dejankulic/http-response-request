package app;

import http.Request;
import http.response.HtmlResponse;
import http.response.RedirectResponse;
import http.response.Response;

public class NewsletterController extends Controller {

    public NewsletterController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        String htmlBody = "" +
                "<form method=\"POST\" action=\"/apply\">" +
                "<label>Author: </label><br><input name=\"author\" type=\"text\"><br><br>" +
                "<label>Quote: </label><br><input name=\"quote\" type=\"text\"><br><br>" +
                "<button>Save quote</button>" +
                "</form>" +
                "<h2>Quote of the day:</h2><br>" +

                request.getQuoteOOD()
                +
                "<br>" +
                "<h2>Saved quotes</h2><br>" +
                request.getQuotes()
                ;

        String content = "<html><head><title>Odgovor servera</title></head>\n";
        content += "<body>" + htmlBody + "</body></html>";

        return new HtmlResponse(content);
    }

    @Override
    public Response doPost() {


        return new RedirectResponse("/newsletter");
    }
}
