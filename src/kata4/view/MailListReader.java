package kata4.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

public class MailListReader {
    public List<Mail> read(String fileName) throws FileNotFoundException, IOException{
        List<Mail> mails = new ArrayList<Mail>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if(line.contains("@")){
                    mails.add(new Mail(line));
                }
            }
        }
        return mails;
    }
}
