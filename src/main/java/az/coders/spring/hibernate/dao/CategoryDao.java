package az.coders.spring.hibernate.dao;

import az.coders.spring.hibernate.domains.Category;

import java.util.List;

public interface CategoryDao  {
      List<Category> findByName(String name);
}
