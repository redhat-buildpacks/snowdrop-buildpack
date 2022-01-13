package dev.snowdrop.buildpack.model;

import io.sundr.builder.annotations.Buildable;

@Buildable
public record BuildPlanProvide(String Name) {}