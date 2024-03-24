package dev.rost;

import dev.rost.domain.model.Person;
import dev.rost.util.Fields;
import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import lombok.experimental.ExtensionMethod;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static dev.rost.util.Fields.FieldDescription;
import static org.assertj.core.api.Assertions.assertThat;

@ExtensionMethod(Fields.class)
@ExtendWith(RandomBeansExtension.class)
class FieldsTest {

    static FieldDescription<Integer> id = FieldDescription.of("id");
    static FieldDescription<String> name = FieldDescription.of("name");
    static FieldDescription<Set<String>> hobbies = FieldDescription.of("hobbies");


    @Test
    void fieldDescriptionTest(@Random Person person) {
        assertThat(person.get(id))
                .isEqualTo(person.id());
        assertThat(person.get(name))
                .isEqualTo(person.name());
        assertThat(Fields.<String>get(person, "email"))
                .isEqualTo(person.email());
        assertThat(person.get(hobbies))
                .isEqualTo(person.hobbies());
    }
}
