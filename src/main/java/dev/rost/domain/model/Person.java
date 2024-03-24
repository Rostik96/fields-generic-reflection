package dev.rost.domain.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Set;

@Value
@Builder
@Accessors(fluent = true)
public class Person {
    int id;
    String name;
    String email;
    Set<String> hobbies;
}
