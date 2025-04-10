package com.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "author")
public class AuthorDeep extends BaseAuthor {
    
    private static final long serialVersionUID = 1L;
    
    @Column(columnDefinition = "LONGBLOB")
	@Lob
    private byte[] avatar;
}
