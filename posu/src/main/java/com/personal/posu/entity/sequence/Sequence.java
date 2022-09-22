package com.personal.posu.entity.sequence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Sequences")
public class Sequence {
    @Id
    private String id;
    private int seq;
}
