package com.practice.web.soccer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {



//    tm프링 데이터 JPA에서는 다음과 같이 JpaRepository 인터페이스를 상속하는 인터페이스를 정의하면 이 인터페이스를 통해
//    RDBMS, NoSQL 등의 Repository와 데이터를 주고받을 수 있는 빈을 자동적으로 등록하는 기능을 제공합니다.
//    빈을 자동적 생성

}
