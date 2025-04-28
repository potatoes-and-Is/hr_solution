package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

@Entity
@Table(name = "Doc_types")
public class DocType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_type_id")
    private int docTypeId;

    @Column(name = "doc_type_name", nullable = false, length = 30)
    private String docTypeName;

    public DocType() {

    }

    public DocType(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public int getDocTypeId() {
        return docTypeId;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    @Override
    public String toString() {
        return "DocType{" +
                "docTypeId=" + docTypeId +
                ", docTypeName='" + docTypeName + '\'' +
                '}';
    }
}
