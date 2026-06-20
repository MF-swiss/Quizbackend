package ch.wiss.quizbackend;

import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public DataSeeder(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        if (questionRepository.count() == 0) {
            questionRepository.saveAll(getStartQuestions());
            System.out.println("DataSeeder: " + questionRepository.count()
                    + " Fragen in die DB geschrieben.");
        } else {
            System.out.println("DataSeeder: DB enthält bereits Daten, kein Seeding nötig.");
        }
    }

    private List<Question> getStartQuestions() {
        return List.of(
                new Question(
                        "1",
                        "Welches Protokoll wird für verschlüsselte Webseiten verwendet?",
                        "Technologie",
                        "leicht",
                        List.of("HTTP", "FTP", "SSH", "HTTPS"),
                        "HTTPS"),
                new Question(
                        "2",
                        "Welche Datenbankart ist dokumentenorientiert?",
                        "Technologie",
                        "schwer",
                        List.of("MySQL", "MongoDB", "PostgreSQL", "SQLite"),
                        "MongoDB"),
                new Question(
                        "8",
                        "Was beschreibt die Big-O-Notation?",
                        "Technologie",
                        "schwer",
                        List.of("Die Geschwindigkeit eines Prozessors", "Die Komplexität eines Algorithmus",
                                "Die Größe eines Datensatzes", "Die Anzahl der Threads"),
                        "Die Komplexität eines Algorithmus"));
    }
}