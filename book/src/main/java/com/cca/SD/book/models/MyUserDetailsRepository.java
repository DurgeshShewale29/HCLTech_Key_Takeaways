package com.cca.SD.book.models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cca.SD.book.models.AppUser;

@Repository
public interface MyUserDetailsRepository extends JpaRepository<AppUser,Long> {
	AppUser getAppUserByEmail(String userName);
}