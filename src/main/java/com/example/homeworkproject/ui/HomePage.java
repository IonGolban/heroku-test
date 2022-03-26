package com.example.homeworkproject.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class HomePage extends VerticalLayout {

    public HomePage() {
        TextField name = new TextField("Name");
        Paragraph greeting = new Paragraph("");

        Button sayHello = new Button("Greet");
        sayHello.addClickListener(e -> {
            greeting.setText(name.getValue());
        });

        add(name, sayHello, greeting);
    }


}
