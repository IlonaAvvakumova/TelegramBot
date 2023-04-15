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
@Table(name = "binary_content")
public class BinaryContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] fileAsArrayOfBytes;
}
