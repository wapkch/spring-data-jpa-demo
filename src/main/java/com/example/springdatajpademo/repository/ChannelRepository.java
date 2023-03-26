package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.Channel;

import org.springframework.data.repository.ListCrudRepository;

public interface ChannelRepository extends ListCrudRepository<Channel, String> {
}
