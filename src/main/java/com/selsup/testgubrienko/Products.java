package com.selsup.testgubrienko;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class Products {
    private final String certificateDocument;
    private final String certificateDocumentDate;
    private final String certificateDocumentNumber;
    private final String ownerInn;
    private final String producerInn;
    private final String productionDate;
    private final String tnvedCode;
    private final String uitCode;
    private final String uituCode;

    @JsonCreator
    public Products(@JsonProperty("certificate_document") String certificateDocument,
                    @JsonProperty("certificate_document_date") String certificateDocumentDate,
                    @JsonProperty("certificate_document_number") String certificateDocumentNumber,
                    @JsonProperty("owner_inn") String ownerInn,
                    @JsonProperty("producer_inn") String producerInn,
                    @JsonProperty("production_date") String productionDate,
                    @JsonProperty("tnved_code") String tnvedCode,
                    @JsonProperty("uit_code") String uitCode,
                    @JsonProperty("uitu_code") String uituCode) {
        this.certificateDocument = certificateDocument;
        this.certificateDocumentDate = certificateDocumentDate;
        this.certificateDocumentNumber = certificateDocumentNumber;
        this.ownerInn = ownerInn;
        this.producerInn = producerInn;
        this.productionDate = productionDate;
        this.tnvedCode = tnvedCode;
        this.uitCode = uitCode;
        this.uituCode = uituCode;
    }
}