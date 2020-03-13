package com.example.whiteboard.repositories;
import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WidgetRepository
    extends CrudRepository<Widget, Integer> {

//        @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId")
//        public Widget findWidgetById(
//        @Param("widgetId") int wid);
//
//        @Query("SELECT widget FROM Widget widget")
//        public List<Widget> findAllWidgets();

        @Query(value = "SELECT * FROM widgets WHERE widgets.topic_id=:topicId", nativeQuery = true)
        public List<Widget> findWidgetsForTopic(@Param("topicId") int topicId);

}
