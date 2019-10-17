package org.improving.tag.database;

import org.improving.tag.items.UniqueItems;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class itemsConverter implements AttributeConverter<UniqueItems, String> {

    public String convertToDatabaseColumn(UniqueItems item) {
        if (item != null) {
            return item.getName();
        } else return null;
    }
    public UniqueItems convertToEntityAttribute(String string ) {
        if (string != null) {
            return Stream.of(UniqueItems.values()).filter(i -> i.getName().equalsIgnoreCase(string)).findFirst().orElse(null);
        } return UniqueItems.NOTHING;

    }
}
