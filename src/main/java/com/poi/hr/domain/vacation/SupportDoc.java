package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Support_docs")
public class SupportDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_doc_id")
    private int supportDocId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_doc_id")
    private ApprovalDoc approvalDoc;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "exist_file_path", nullable = false, length = 255)
    private String existFilePath;

    @Column(name = "file_save_path", nullable = false, length = 255)
    private String fileSavePath;

    @Column(name = "upload_date", nullable = false, insertable = false, updatable = false)
    private LocalDateTime uploadDate;

    public SupportDoc() {

    }

    public SupportDoc(ApprovalDoc approvalDoc, String fileName, String existFilePath, String fileSavePath) {
        this.approvalDoc = approvalDoc;
        this.fileName = fileName;
        this.existFilePath = existFilePath;
        this.fileSavePath = fileSavePath;
    }

    public int getSupportDocId() {
        return supportDocId;
    }

    public ApprovalDoc getApprovalDoc() {
        return approvalDoc;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExistFilePath() {
        return existFilePath;
    }

    public String getFileSavePath() {
        return fileSavePath;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setApprovalDoc(ApprovalDoc approvalDoc) {
        this.approvalDoc = approvalDoc;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setExistFilePath(String existFilePath) {
        this.existFilePath = existFilePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    @Override
    public String toString() {
        return "SupportDoc{" +
                "supportDocId=" + supportDocId +
                ", approvalDocId=" + (approvalDoc != null ? approvalDoc.getApprovalDocId() : null) +
                ", fileName='" + fileName + '\'' +
                ", existFilePath='" + existFilePath + '\'' +
                ", fileSavePath='" + fileSavePath + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}