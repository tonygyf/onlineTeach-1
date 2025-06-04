package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Result;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {
    @Resource
    private OpenAiChatModel openAiChatModel;

    private final List<Message> chatHistoryList = new ArrayList<>();

    @PostConstruct
    public void init() {
        chatHistoryList.add(new SystemMessage("你是一个AI助教，目的是为学生提供指定课程相关内容的导航，包括资料索引、课件索引和课程内容的提问."));
    }

    @GetMapping("/chat")
    public ChatResponse test(String message){
        chatHistoryList.add(new SystemMessage(message));
        Prompt prompt = new Prompt(chatHistoryList);
        ChatResponse chatResponse = openAiChatModel.call(prompt);

        if(chatResponse.getResult() != null && chatResponse.getResult().getOutput() != null){
            chatHistoryList.add(chatResponse.getResult().getOutput());
        }

        return chatResponse;
    }
}

