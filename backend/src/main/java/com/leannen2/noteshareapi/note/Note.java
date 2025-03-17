package com.leannen2.noteshareapi.note;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="note")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private String className;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
