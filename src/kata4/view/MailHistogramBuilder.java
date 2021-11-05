package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> (List<Mail> mails){
        Histogram histo = new Histogram();
        int index = 0;
        while(mails.get(index) != null){
            histo.increment(mails.get(index));
        }
        return histo;
    }
}
