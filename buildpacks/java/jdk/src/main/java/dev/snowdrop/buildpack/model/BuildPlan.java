package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.sundr.builder.annotations.Buildable;

import java.util.List;

@JsonIgnoreProperties
@Buildable
public record BuildPlan(@JsonIgnore String path, List<BuildPlanRequire> requires, List<BuildPlanProvide> provides) {}
