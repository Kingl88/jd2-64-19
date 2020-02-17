package by.it.academy.design_bureau;

public class SenderService {
    private Sender sender;

    public SenderService(){}

    public SenderService(Sender sender) {
        this.sender = sender;
    }
    public void sendMessage(String message) {
        sender.send(message);
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
