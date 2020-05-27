package com.practice.web.soccer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Player,Long> {
}
