package ru.mail.L_chr93.logic.textReader;

import ru.mail.L_chr93.domain.Sentence;

public interface TextReader {
    Sentence readSentence();
    boolean hasNext();
}
