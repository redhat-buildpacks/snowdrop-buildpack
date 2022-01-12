package dev.snowdrop.buildpack.model;

import io.sundr.builder.annotations.Buildable;

import java.util.List;

@Buildable
public record BuildPackPlan(List<Entries> entries) {}
