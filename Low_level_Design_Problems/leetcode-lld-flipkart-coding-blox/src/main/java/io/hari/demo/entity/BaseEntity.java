package io.hari.demo.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@ToString
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
