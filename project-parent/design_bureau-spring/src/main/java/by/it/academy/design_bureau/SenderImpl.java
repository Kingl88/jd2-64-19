package by.it.academy.design_bureau;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderImpl implements Sender {
    @Override
    public void send(String message) {
        log.info(message);
    }
}
