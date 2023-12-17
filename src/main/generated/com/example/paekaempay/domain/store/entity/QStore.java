package com.example.paekaempay.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 118681094L;

    public static final QStore store = new QStore("store");

    public final com.example.paekaempay.domain.QBaseEntity _super = new com.example.paekaempay.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    public final StringPath location = createString("location");

    public final StringPath name = createString("name");

    public final ListPath<com.example.paekaempay.domain.payment.entity.Payment, com.example.paekaempay.domain.payment.entity.QPayment> payments = this.<com.example.paekaempay.domain.payment.entity.Payment, com.example.paekaempay.domain.payment.entity.QPayment>createList("payments", com.example.paekaempay.domain.payment.entity.Payment.class, com.example.paekaempay.domain.payment.entity.QPayment.class, PathInits.DIRECT2);

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

