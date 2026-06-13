package ch.wiss.quizbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @GetMapping("/api/questions")
    public List<Question> getQuestions() {
        return List.of(
                new Question(
                        "1",
                        "Welches Land hat die meisten FIFA-WMs gewonnen?",
                        "Sport",
                        "leicht",
                        List.of("Brasilien", "Italien", "Frankreich", "Deutschland"),
                        "Brasilien"
                ),
                new Question(
                        "2",
                        "Wofür steht die Abkürzung CPU?",
                        "Technologie",
                        "leicht",
                        List.of("Central Processing Unit", "Computer Power Unit", "Central Program Utility", "Core Performance Unit"),
                        "Central Processing Unit"
                ),
                new Question(
                        "3",
                        "Welche Programmiersprache wird hauptsächlich für Android-Apps verwendet?",
                        "Technologie",
                        "mittel",
                        List.of("Kotlin", "Swift", "Ruby", "C#"),
                        "Kotlin"
                ),
                new Question(
                        "4",
                        "Welches Protokoll wird für verschlüsselte Webseiten verwendet?",
                        "Technologie",
                        "leicht",
                        List.of("HTTP", "FTP", "SSH", "HTTPS"),
                        "HTTPS"
                ),
                new Question(
                        "5",
                        "Welche Datenstruktur arbeitet nach dem LIFO-Prinzip?",
                        "Technologie",
                        "mittel",
                        List.of("Queue", "Array", "Stack", "Linked List"),
                        "Stack"
                ),
                new Question(
                        "6",
                        "Welche Firma entwickelte das Betriebssystem Windows?",
                        "Technologie",
                        "leicht",
                        List.of("Apple", "Microsoft", "IBM", "Google"),
                        "Microsoft"
                ),
                new Question(
                        "7",
                        "Welche Datenbankart ist dokumentenorientiert?",
                        "Technologie",
                        "schwer",
                        List.of("MySQL", "MongoDB", "PostgreSQL", "SQLite"),
                        "MongoDB"
                ),
                new Question(
                        "8",
                        "Was beschreibt die Big-O-Notation?",
                        "Technologie",
                        "schwer",
                        List.of("Die Geschwindigkeit eines Prozessors", "Die Komplexität eines Algorithmus", "Die Größe eines Datensatzes", "Die Anzahl der Threads"),
                        "Die Komplexität eines Algorithmus"
                )
        );
    }
}
