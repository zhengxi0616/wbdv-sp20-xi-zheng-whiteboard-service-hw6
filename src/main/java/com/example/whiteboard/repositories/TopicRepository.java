package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

//    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
//    public Topic findTopicById(
//            @Param("topicId") int tid);
//
//    @Query("SELECT Topic FROM Topic topic")
//    public List<Topic> findAllTopics();

    // "SELECT * FROM widgets WHERE topic_id=topicId
//    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    @Query(value = "SELECT * FROM topics WHERE topics.lesson_id=:lessonId", nativeQuery = true)
    public List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);
}