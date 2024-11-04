package org.example.springboot.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseEntity {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;


@Column(name = "created_at")
@Temporal(TemporalType.DATE)
private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;


    @PrePersist
    public void onCreate(){
        this.createdAt= new Date();
    }


    @PostPersist
    public void onUpdate(){
        this.createdAt=  new Date();
    }

}
