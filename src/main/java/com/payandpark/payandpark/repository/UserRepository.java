package com.payandpark.payandpark.repository;

import com.payandpark.payandpark.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;


@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {
    public abstract ArrayList<UserModel> findByPhone(String phone);

}
