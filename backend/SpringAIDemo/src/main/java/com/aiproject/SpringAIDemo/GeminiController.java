package com.aiproject.SpringAIDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://ai-model-comparison-gamma.vercel.app"
})
@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    private final ChatClient chatClient;

    public GeminiController(GoogleGenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {

        String response = chatClient
                .prompt(message)
                .call()
                .content();

        return ResponseEntity.ok(response);
    }
}
