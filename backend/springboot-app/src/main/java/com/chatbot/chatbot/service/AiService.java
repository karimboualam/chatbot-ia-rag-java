/*package com.chatbot.chatbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AiService {

    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    
    public String getResponse(String userMessage) {
    try {
        // 🔹 Construire la requête
        String body = """
            {
                "model": "gpt-3.5-turbo",
                "messages": [{"role": "user", "content": "%s"}]
            }
            """.formatted(userMessage);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 🔹 Vérifie le code HTTP
        if (response.statusCode() != 200) {
            System.err.println("❌ Erreur API: " + response.body());
            return "Erreur API (" + response.statusCode() + "): " + response.body();
        }

        // 🔹 Parse la réponse JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(response.body());

        // 🔹 Vérifie si OpenAI a renvoyé une erreur
        if (jsonResponse.has("error")) {
            return "Erreur OpenAI: " + jsonResponse.get("error").get("message").asText();
        }

        // 🔹 Vérifie si 'choices' existe
        if (!jsonResponse.has("choices") || !jsonResponse.get("choices").isArray()) {
            return "Erreur: format inattendu de la réponse OpenAI → " + response.body();
        }

        // 🔹 Récupère la réponse du modèle
        return jsonResponse
                .get("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();

    } catch (Exception e) {
        e.printStackTrace();
        return "Erreur serveur : " + e.getMessage();
    }
}

}*/

package com.chatbot.chatbot.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    private final RestTemplate restTemplate;
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public AiService() {
        this.restTemplate = new RestTemplate();
    }

    public String getResponse(String userMessage) {
        try {
            // Corps de la requête JSON à Ollama
            Map<String, Object> body = new HashMap<>();
            body.put("model", "phi3"); // ou "llama3" si tu préfères
            body.put("prompt", userMessage);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

            // Appel à Ollama
            ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, entity, Map.class);

            if (response.getBody() != null && response.getBody().get("response") != null) {
                return response.getBody().get("response").toString();
            } else {
                return "⚠️ Aucune réponse renvoyée par le modèle.";
            }

        } catch (Exception e) {
            return "⚠️ Erreur lors de la communication avec Ollama : " + e.getMessage();
        }
    }
}


