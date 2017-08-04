package com.dusty.belt2.services;

import com.dusty.belt2.models.Subscription;
import com.dusty.belt2.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    SubscriptionRepository subscriptionRepository;
    public SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }
    public void save(Subscription subscription){
        subscriptionRepository.save(subscription);
    }
}
