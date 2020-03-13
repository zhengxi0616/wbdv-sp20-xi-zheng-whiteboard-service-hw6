package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.WidgetRepository;
import com.example.whiteboard.services.WidgetService;
import com.example.whiteboard.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")

public class WidgetController {
    @Autowired
    WidgetService widgetService;

    @Autowired
    TopicService topicService;

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") int widgetId,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") int widgetId) {
        return widgetService.deleteWidget(widgetId);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") Integer topicId,
            @RequestBody Widget newWidget) {
        return widgetService.createWidget(topicId, newWidget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") int wid) {
        return widgetService.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") int tid) {
        return widgetService.findWidgetsForTopic(tid);
    }
}
