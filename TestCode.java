//Unit Code (MessageSearchService.java):
import java.util.List;
import java.util.stream.Collectors;

public class MessageSearchService {
    public List<String> searchMessages(List<String> messages, String query) {
        if (query == null || query.isEmpty()) {
            return messages;
        }
        return messages.stream()
                .filter(msg -> msg.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}

//Automated Test Results (JUnit 5):
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class MessageSearchTest {
    @Test
    public void testSearchFunctionality() {
        MessageSearchService service = new MessageSearchService();
        List<String> chatHistory = Arrays.asList("Meeting at 5pm", "Project due Sunday", "Hello world");

        // Test Case: True Result
        List<String> result = service.searchMessages(chatHistory, "Project");
        assertEquals(1, result.size());
        
        // Test Case: False Result
        List<String> emptyResult = service.searchMessages(chatHistory, "Pizza");
        assertTrue(emptyResult.isEmpty());
    }
}

