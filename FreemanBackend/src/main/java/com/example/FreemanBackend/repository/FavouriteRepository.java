package com.example.FreemanBackend.repository;

import com.example.FreemanBackend.model.Favourite;
import com.example.FreemanBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    Favourite findByUser(User user);

}
