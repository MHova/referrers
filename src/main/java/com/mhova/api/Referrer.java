package com.mhova.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Referrer {
    @NotNull
    public final String url;

    @JsonCreator
    public Referrer(@JsonProperty("url") final String url) {
        this.url = url;
    }
}
