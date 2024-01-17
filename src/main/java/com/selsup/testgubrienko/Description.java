package com.selsup.testgubrienko;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class Description {
    private final String participantInn;

    @JsonCreator
    public Description(@JsonProperty("participantInn") String participantInn) {
        this.participantInn = participantInn;
    }
}