package com.mendess.View;

import java.util.ArrayList;
import java.util.List;

class OutputChangeEvents {
    interface OutputChangeEvent {
        void update();
    }
    private static final List<OutputChangeEvent> listeners = new ArrayList<>();
    static void register(OutputChangeEvent e) {
        listeners.add(e);
    }
    static void fireEvents() {
        listeners.forEach(OutputChangeEvent::update);
    }
}
