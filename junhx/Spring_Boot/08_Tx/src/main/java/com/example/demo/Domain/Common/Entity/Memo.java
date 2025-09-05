package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "memo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024)
    private String text;
    @Column(length = 100, nullable = false)
    private String writer;
    private LocalDateTime createAt;
}
