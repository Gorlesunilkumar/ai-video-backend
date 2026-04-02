package com.sunil.video_generator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {

    // 🔥 EXISTING METHOD (if you already have API call logic, keep it here)
    public String callAI(String prompt) {

        // 👉 Replace this with your actual OpenAI / API logic
        // For now dummy response (for testing)

        return "1. AI means machines that think like humans\n" +
               "2. It helps in automation\n" +
               "3. It is used in apps and robots\n" +
               "4. It learns from data\n" +
               "5. It improves over time";
    }

    // 🔥 NEW METHOD (STEP 1 MAIN FEATURE)
    public List<String> generateEducationalScenes(String topic) {

        List<String> scenes = new ArrayList<>();

        try {

            String prompt = "Explain the topic in very simple English for beginners. " +
                    "Give exactly 5 short sentences. Each sentence should be one line. Topic: " + topic;

            String response = callAI(prompt);

            String[] lines = response.split("\\n");

            for (String line : lines) {
                if (!line.trim().isEmpty()) {

                    // remove numbering (1. 2. etc)
                    String clean = line.replaceAll("^[0-9]+\\.\\s*", "").trim();

                    scenes.add(clean);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scenes;
    }

    // OPTIONAL (if already exists in your code)
    public String generateScript(String text) {
        return callAI(text);
    }
}