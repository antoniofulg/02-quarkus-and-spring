package org.antoniofulg;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Pessoa extends PanacheEntity {

  public String name;
  public int yearOfBirth;

  public static List<Pessoa> findByYearOfBirth(int yearOfBirth) {
    return find("yearOfBirth", yearOfBirth).list();
  }
}
