package com.example.entity;

import lombok.*;

import javax.persistence.*;
@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_document")
public class AppDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telegramFileId;
    private String docName;
    @OneToOne
    private BinaryContent binaryContent;
    private String mimeType;
    private Long fileSize;
}
