package EX1428;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Answer20 extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton toEnglishButton;
    private JButton toSMSButton;

    private Map<String, String> smsToEnglish = new HashMap<>();
    private Map<String, String> englishToSms = new HashMap<>();

    public Answer20() {
        setTitle("SMS Language Translator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialize translation maps
        initializeDictionaries();

        inputTextArea = new JTextArea("Enter your message here...");
        outputTextArea = new JTextArea("Translation appears here...");
        outputTextArea.setEditable(false);

        toEnglishButton = new JButton("Translate to English");
        toSMSButton = new JButton("Translate to SMS");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toEnglishButton);
        buttonPanel.add(toSMSButton);

        add(new JScrollPane(inputTextArea), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);

        // Action listeners
        toEnglishButton.addActionListener(_ -> translateToEnglish());
        toSMSButton.addActionListener(_ -> translateToSMS());

        setVisible(true);
    }

    private void initializeDictionaries() {
        // SMS to English
        smsToEnglish.put("imo", "in my opinion");
        smsToEnglish.put("brb", "be right back");
        smsToEnglish.put("lol", "laugh out loud");
        smsToEnglish.put("idk", "I don't know");
        smsToEnglish.put("ttyl", "talk to you later");
        smsToEnglish.put("btw", "by the way");
        smsToEnglish.put("omg", "oh my god");
        smsToEnglish.put("ttfn", "ta ta for now");
        smsToEnglish.put("bff", "best friends forever");
        smsToEnglish.put("smh", "shaking my head");
        smsToEnglish.put("fyi", "for your information");
        smsToEnglish.put("np", "no problem");
        smsToEnglish.put("jk", "just kidding");
        smsToEnglish.put("gtg", "got to go");
        smsToEnglish.put("asap", "as soon as possible");

        // Build reverse dictionary
        for (Map.Entry<String, String> entry : smsToEnglish.entrySet()) {
            englishToSms.put(entry.getValue(), entry.getKey());
        }
    }

    private void translateToEnglish() {
        String input = inputTextArea.getText().toLowerCase();
        for (Map.Entry<String, String> entry : smsToEnglish.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }
        outputTextArea.setText(input);
    }

    private void translateToSMS() {
        String input = inputTextArea.getText().toLowerCase();
        for (Map.Entry<String, String> entry : englishToSms.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }
        outputTextArea.setText(input);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Answer20::new);
    }
}