package cs151_rps;

public class Message {
    
    Message( String lang )
    {
        language = lang;
    }
    
    private String language;
    

    public String getMessage( MessageType type )
    {
        return type.getText();
    }
    
}
