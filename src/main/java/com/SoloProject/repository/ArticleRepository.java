package com.SoloProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SoloProject.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

	@Query("SELECT a from Article a WHERE a.id=?1")
	Article findById(int id);

	@Modifying
	@Query("DELETE from Article a WHERE a.id=?2 AND a.url=?1")
	void deleteByUrlAndUserId(String articleUrl, int id);

}
