package com.poi.hr.domain.approval;

import jakarta.persistence.*;

@Entity
@Table(name = "doc_types")
public class DocType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_type_id")
    private int docTypeId;

    @Column(name = "doc_type_name", nullable = false, length = 50)
    private String docTypeName;

    public int getDocTypeId() {
        return docTypeId;
    }

    public String getDocTypeName() {
        return docTypeName;
    }
}
