package com.example.paekaempay.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1414907222L;

    public static final QUser user = new QUser("user");

    public final com.example.paekaempay.domain.QBaseEntity _super = new com.example.paekaempay.domain.QBaseEntity(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    public final StringPath password = createString("password");

    public final ListPath<com.example.paekaempay.domain.payment.entity.Payment, com.example.paekaempay.domain.payment.entity.QPayment> payments = this.<com.example.paekaempay.domain.payment.entity.Payment, com.example.paekaempay.domain.payment.entity.QPayment>createList("payments", com.example.paekaempay.domain.payment.entity.Payment.class, com.example.paekaempay.domain.payment.entity.QPayment.class, PathInits.DIRECT2);

    public final EnumPath<com.example.paekaempay.domain.user.UserRoleType> roleType = createEnum("roleType", com.example.paekaempay.domain.user.UserRoleType.class);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

