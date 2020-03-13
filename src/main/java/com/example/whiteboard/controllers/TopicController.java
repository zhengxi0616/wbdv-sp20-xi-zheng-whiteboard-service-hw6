package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.TopicRepository;
import com.example.whiteboard.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopic(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic newTopic
    ) {
        newTopic.setLessonId(lessonId);
        return topicService.createTopic(lessonId,newTopic);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") String lessonId) {
        return topicService.findTopicsForLesson(lessonId);
    }

    @PutMapping("/api/topics/{tid}")
    public int updateTopic(@PathVariable("tid") int topicId,
                            @RequestBody Topic topic) {
        return topicService.updateTopic(topicId, topic);
    }

    @DeleteMapping("/api/topics/{tid}")
    public int deleteTopic(@PathVariable("tid") int topicId) {
        return topicService.deleteTopic(topicId);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") int topicId) {
        return topicService.findTopicById(topicId);
    }
}
