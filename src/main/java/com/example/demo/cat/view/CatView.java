package com.example.demo.cat.view;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.example.demo.cat.Cat;

@EntityView(Cat.class)
public interface CatView {

    @IdMapping
    Integer getId();

    Integer getAge();
}
