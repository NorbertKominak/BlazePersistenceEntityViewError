package com.example.demo.cat;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.BlazeCriteriaBuilderRenderer;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.blazebit.persistence.querydsl.JPQLNextTemplates;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.example.demo.cat.view.CatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CatRepository {

    @PersistenceContext
    private EntityManager em;

    private CriteriaBuilderFactory cbf;

    private EntityViewManager evm;


    public CatView find(@NonNull Integer id) {
        QCat model = QCat.cat;

        BlazeJPAQuery<Cat> query = new BlazeJPAQuery<Cat>(em, cbf)
                .from(model)
                .where(model.id.eq(id));

        BlazeCriteriaBuilderRenderer<Cat> criteriaBuilderRenderer = new BlazeCriteriaBuilderRenderer<>(cbf, em, JPQLNextTemplates.DEFAULT);
        CriteriaBuilder<Cat> criteriaBuilder = (CriteriaBuilder<Cat>) criteriaBuilderRenderer.render(query);

        CriteriaBuilder<CatView> viewBuilder = evm.applySetting(EntityViewSetting.create(CatView.class), criteriaBuilder);

        return viewBuilder.getSingleResult();
    }

    @Transactional
    public Cat save(Cat cat) {
        return em.merge(cat);
    }


    @Autowired
    public void setCbf(CriteriaBuilderFactory cbf) {
        this.cbf = cbf;
    }

    @Autowired
    public void setEvm(EntityViewManager evm) {
        this.evm = evm;
    }
}
