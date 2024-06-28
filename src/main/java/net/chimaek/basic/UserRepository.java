package net.chimaek.basic;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryInterface{

    @Override
    public void save(User user){
        System.out.println("UserRepository.save");
    }

    @Override
    public void delete(User user) {
        System.out.println("User delete");
    }
}
