package org.improving.tag.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter(autoApply = true)
public class ConverterForStrings implements AttributeConverter<ListOfStrings, String> {

    public String convertToDatabaseColumn(ListOfStrings listOfStrings) {
//        if (listOfStrings != null) {
//            return listOfStrings.
//        } else return "";
return "";
    }

    public ListOfStrings convertToEntityAttribute(String string) {
        if (string != null) {
            String[] exitAlias = (string.split(", "));
            var listy = new ListOfStrings();
            for (String alias : exitAlias) {
                listy.add(alias);

            }
            return listy;
        } return null;
    }
}
