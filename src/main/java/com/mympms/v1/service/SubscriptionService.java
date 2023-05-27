package com.mympms.v1.service;

import com.mympms.v1.entity.Subscription;
import com.mympms.v1.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class SubscriptionService implements BaseServiceInterface<Subscription> {

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    @Override
    public Subscription create(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void update(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    @Override
    public void deleteMany(List<Subscription> subscriptions) {
        subscriptionRepository.deleteAll(subscriptions);
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> getOneById(int id) {
        return subscriptionRepository.findById(id);
    }
}
