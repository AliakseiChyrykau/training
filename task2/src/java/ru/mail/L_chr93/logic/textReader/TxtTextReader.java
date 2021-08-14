package ru.mail.L_chr93.logic.textReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.mail.L_chr93.domain.Sentence;

public class TxtTextReader implements TextReader {
    private BufferedReader br = null;
    private StringBuilder sb = null;

    public TxtTextReader(String filePath) {
        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
            sb = new StringBuilder("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readLine() {
        try {
            sb.append(br.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        try {
            return br.ready();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sentence readSentence() {
        Pattern patterm = Pattern.compile("[.!?]");
        Matcher matcher = patterm.matcher(sb);
        String tempStr;
        int idx;

        while (!matcher.find()) {
            readLine();
            matcher = patterm.matcher(sb);
        }

        idx = matcher.end();
        tempStr = sb.substring(0, idx);
        sb.delete(0, idx + 1);
        tempStr = tempStr.replaceAll("\\s+", " ");

        return new Sentence(tempStr);
    }
}