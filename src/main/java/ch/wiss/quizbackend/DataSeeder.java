 import org.springframework.core.io.ClassPathResource;
 import tools.jackson.core.type.TypeReference;
 import tools.jackson.databind.ObjectMapper;


 import java.io.InputStream;


/**
* Füllt die Datenbank beim Start mit den Fragen aus questions.json,
* aber nur dann, wenn die Tabelle noch leer ist.
*/
@Component
public class DataSeeder implements CommandLineRunner {


   private final QuestionRepository questionRepository;
   private final ObjectMapper objectMapper;


   /**
    * Neu mit ObjectMapper für das auslesen der Json-Datei
    */
   public DataSeeder(QuestionRepository questionRepository,
                     ObjectMapper objectMapper) {
       this.questionRepository = questionRepository;
       this.objectMapper = objectMapper;
   }


   @Override
   public void run(String... args) throws Exception {
       if (questionRepository.count() == 0) {
           ClassPathResource resource = 
				new ClassPathResource("questions.json");


           try (InputStream inputStream = resource.getInputStream()) {
               List<Question> questions = 
						objectMapper.readValue(inputStream, 
						   new TypeReference<List<Question>>()
               {});


	         // Repository speichert jetzt die questions
               // aus der Json-Datei
               questionRepository.saveAll(questions);               
           }


       } else {
           System.out.println("DataSeeder: DB enthält bereits Daten.");
       }
   }
}
