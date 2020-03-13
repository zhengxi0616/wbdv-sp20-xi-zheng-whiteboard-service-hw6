package com.example.whiteboard.services;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.TopicRepository;
import com.example.whiteboard.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public List<Topic> findAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }

    public Topic findTopicById(int tid) {
        return (Topic) topicRepository.findById(tid).get();
    }

    public int deleteTopic(int tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public int updateTopic(int tid, Topic newTopic) {
        newTopic.setId(tid);
        topicRepository.save(newTopic);
        return 1;
    }
    
    public Topic createTopic(String lid, Topic topic){
        topic.setLessonId(lid);
        return topicRepository.save(topic);
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }
}
