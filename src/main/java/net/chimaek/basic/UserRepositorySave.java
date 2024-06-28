package net.chimaek.basic;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositorySave implements UserRepositoryInterface{

    @Override
    public void save(User user){
        System.out.println("User1 save");
    }

    @Override
    public void delete(User user) {
        System.out.println("User1 delete");
    }
}
