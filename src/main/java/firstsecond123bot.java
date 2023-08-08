import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class firstsecond123bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getText());

        String command = update.getMessage().getText();





        

        SendMessage message = new SendMessage();

        if(command.equals("/myname")){

            System.out.println(update.getMessage().getFrom().getFirstName());

            message.setText(update.getMessage().getFrom().getFirstName());
        }
        if(command.equals("/mylastname")){

            System.out.println(update.getMessage().getFrom().getLastName());

            message.setText(update.getMessage().getFrom().getLastName());
        }
        if(command.equals("/myfullname")) {
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());

            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }
            message.setChatId(update.getMessage().getChatId());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "Your Bot User Name";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "Your Bot Token";
    }
}
