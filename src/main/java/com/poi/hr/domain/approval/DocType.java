package com.poi.hr.domain.approval;

import jakarta.persistence.*;

@Entity
@Table(name = "doc_types")
public class DocType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_type_id")
    private int docTypeId;

    @Column(name = "doc_type_code", nullable = false, length = 30)
    private String docTypeCode;

    @Column(name = "doc_type_name", nullable = false, length = 30)
    private String docTypeName;

    public DocType() {
    }

    public DocType(int docTypeId, String docTypeCode, String docTypeName) {
        this.docTypeId = docTypeId;
        this.docTypeCode = docTypeCode;
        this.docTypeName = docTypeName;
    }

    public int getDocTypeId() {
        return docTypeId;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeId(int docTypeId) {
        this.docTypeId = docTypeId;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
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
