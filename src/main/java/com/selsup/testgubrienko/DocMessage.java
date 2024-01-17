package com.selsup.testgubrienko;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class DocMessage {
    private final Description description;
    private final String docId;
    private final String docStatus;
    private final String docType;
    private final Boolean importRequest;
    private final String ownerInn;
    private final String participantInn;
    private final String producerInn;
    private final String productionDate;
    private final String productionType;
    private final Products[] products;
    private final String regDate;
    private final String regNumber;

    @JsonCreator
    public DocMessage(@JsonProperty("description") Description description,
                      @JsonProperty("doc_id") String docId,
                      @JsonProperty("doc_status") String docStatus,
                      @JsonProperty("doc_type") String docType,
                      @JsonProperty("importRequest") Boolean importRequest,
                      @JsonProperty("owner_inn") String ownerInn,
                      @JsonProperty("participant_inn") String participantInn,
                      @JsonProperty("producer_inn") String producerInn,
                      @JsonProperty("production_date") String productionDate,
                      @JsonProperty("production_type") String productionType,
                      @JsonProperty("products") Products[] products,
                      @JsonProperty("reg_date") String regDate,
                      @JsonProperty("reg_number") String regNumber) {

        this.description = description;
        this.docId = docId;
        this.docStatus = docStatus;
        this.docType = docType;
        this.importRequest = importRequest;
        this.ownerInn = ownerInn;
        this.participantInn = participantInn;
        this.producerInn = producerInn;
        this.productionDate = productionDate;
        this.productionType = productionType;
        this.products = products;
        this.regDate = regDate;
        this.regNumber = regNumber;
    }
}
