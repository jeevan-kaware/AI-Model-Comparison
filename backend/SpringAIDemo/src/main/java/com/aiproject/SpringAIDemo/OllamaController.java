package com.aiproject.SpringAIDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin(origins = "http://localhost:5173/")
public class OllamaController {

    private ChatClient chatClient;
    public OllamaController(OllamaChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }
    @GetMapping("{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

        String response = chatClient
                .prompt(message)
                .call()
                .content();
       // String response = chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
