package com.example.whiteboard.services;
import com.example.whiteboard.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    List<Widget> widgetList = new ArrayList<Widget>();

    {
        Widget w1 = new Widget("123", "WA", "HEADING","New Content", 2);
        Widget w2 = new Widget("234", "WB", "PARAGRAPH","New Content",2);
        Widget w3 = new Widget("345", "WC","HEADING","New Content",3);
        Widget w4 = new Widget("456", "WD", "PARAGRAPH","New Content",6);
        Widget w5 = new Widget("567", "WE","HEADING","New Content",1);

        w1.setTopicId("111");
        w2.setTopicId("111");

        w3.setTopicId("222");
        w4.setTopicId("222");
        w5.setTopicId("222");

        widgetList.add(w1);
        widgetList.add(w2);
        widgetList.add(w3);
        widgetList.add(w4);
        widgetList.add(w5);
    }

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
