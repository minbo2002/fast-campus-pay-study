package com.example.paekaempay.infrastructure.payment;

import com.example.paekaempay.domain.payment.entity.Payment;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.paekaempay.domain.payment.entity.QPayment.payment;
import static com.example.paekaempay.domain.user.entity.QUser.user;

@RequiredArgsConstructor
public class PaymentRepositoryCustomImpl implements PaymentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Payment findByUserId(Long userId) {
        return queryFactory.selectFrom(payment)
                .where(eqUserId(userId))
                .fetchOne();
    }

    private BooleanExpression eqUserId(Long userId) {
        if (userId == null) return null;
        return user.id.eq(userId);
    }
}
