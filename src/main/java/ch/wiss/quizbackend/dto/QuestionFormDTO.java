package ch.wiss.quizbackend.dto;

import java.util.List;

/**
 * Datentransfer-Objekt für das Erstellen und Ändern einer Frage.
 * Enthält bewusst keine id: Beim Erstellen vergibt der Server die id,
 * beim Ändern kommt sie aus der URL. Der Client kann also keine id setzen.
 */
public record QuestionFormDTO(
                String text,
                String category,
                String difficulty,
                List<String> answers,
                String correctAnswer) {
}