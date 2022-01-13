package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.sundr.builder.annotations.Buildable;

import java.util.Map;

@Buildable
@JsonPropertyOrder({ "name", "metadata" })
public record BuildPlanRequire(String name, Map<String, Object> metadata) {}