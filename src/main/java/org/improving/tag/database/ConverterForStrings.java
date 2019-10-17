//package org.improving.tag.database;
//
//import org.improving.tag.items.UniqueItems;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//@Converter(autoApply = true)
//public class ConverterForStrings implements AttributeConverter<ListOfStrings, String> {
//
//    public String convertToDatabaseColumn(ListOfStrings listOfStrings) {
//        if (listOfStrings != null) {
//            return listOfStrings.
//        } else return "";
//
//    }
//
//    public ListOfStrings convertToEntityAttribute(String string) {
//        if (string != null) {
//            String[] exitAlias = (string.split(", "));
//            var listy = new ListOfStrings();
//            for (String alias : exitAlias) {
//                listy.add(alias);
//
//            }
//            return listy;
//        } return null;
//    }
//}
