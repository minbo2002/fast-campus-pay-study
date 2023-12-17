package com.example.paekaempay.domain.payment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -1177150106L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final com.example.paekaempay.domain.QBaseEntity _super = new com.example.paekaempay.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    public final EnumPath<com.example.paekaempay.domain.payment.PaymentType> paymentType = createEnum("paymentType", com.example.paekaempay.domain.payment.PaymentType.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final com.example.paekaempay.domain.store.entity.QStore store;

    public final com.example.paekaempay.domain.user.entity.QUser user;

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new com.example.paekaempay.domain.store.entity.QStore(forProperty("store")) : null;
        this.user = inits.isInitialized("user") ? new com.example.paekaempay.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

