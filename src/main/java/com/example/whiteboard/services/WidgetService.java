package com.example.whiteboard.services;
import com.example.whiteboard.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    List<Widget> widgetList = new ArrayList<Widget>();

    public List<Widget> findAllWidgets() {
        return widgetList;
    }

    public Widget findWidgetById(String wid){
        for (Widget w: widgetList){
            if(w.getId().equals(wid)){
                return w;
            }
        }
        return null;
    }

    public Widget createWidget(String tid, Widget newWidget) {
        newWidget.setTopicId(tid
        );
        widgetList.add(newWidget);
        return newWidget;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> resultWidgets = new ArrayList<Widget>();
        for(Widget w: widgetList) {
            if(topicId.equals(w.getTopicId())) {
                resultWidgets.add(w);
            }
        }
        return resultWidgets;
    }

    public int deleteWidget(String widgetId) {
        widgetList = widgetList.stream()
                .filter(w -> !w.getId().equals(widgetId)).collect(Collectors.toList());
        return 1;
    }

    public int updateWidget(String widgetId, Widget updateWidget) {
        for(int i=0; i<widgetList.size(); i++) {
            Widget widget = widgetList.get(i);
            if(widget.getId().equals(widgetId)) {
                widgetList.set(i, updateWidget);
                return 1;
            }
        }
        return 0;
    }


}
