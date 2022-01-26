package http.response;

public class RedirectResponse extends Response{

    private String location;

    public RedirectResponse(String location){
        this.location = location;
    }

    @Override
    public String getResponseString() {
        return "HTTP/1.1 301 Redirect\r\n"  + "Location: " + this.location + "\r\n\r\n";

    }
}
