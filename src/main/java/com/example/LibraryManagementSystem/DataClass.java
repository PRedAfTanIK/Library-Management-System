package com.example.LibraryManagementSystem;

public class DataClass {

    public class Fields {
        public static final String BOOK_COUNT = "Book Count";
        public static final String RATING = "Rating";
        public static final String BOOK = "Book";
        public static final String AUTHOR = "Author";
        public static final String SOLD_COUNT = "Sold Count";
        public static final String BASE_LANGUAGE = "Base language";
        public static final String GENRE = "Genre";
    }
    public class ReturnMessages {
        public final static String ITEM_EXISTS = " Field Already Exists.Do you mean to update the field??";
        public final static String ADD_SUCCESS = " Added Successfully.";
        public final static String ITEM_DOESNT_EXIST = " Doesn't exist.";
        public final static String UPDATE_SUCCESS = " Field updated successfully.";
        public final static String UPDATE_FAILED = " Field updation failed.";
        public final static String DELETE_SUCCESS = " Field deleted successfully.";
        public final static String NO_ENTRIES_PRESENT = "Found 0 entries for the field ";
    }
    public class Genre {
        public final static String FICTION = "Fiction";
        public final static String HORROR = "Horror";
        public final static String HORROR_FICTION = "Horror Fiction";
        public final static String BIOGRAPHY = "Biography";
        public final static String AUTO_BIOGRAPHY = "Auto Biography";
        public final static String EDUCATIONAL = "Educational";
        public final static String HISTORY = "Historic";
        public final static String PREHISTORIC = "Pre-Historic";
        public final static String SCIENTIFIC = "Scientific";
        public final static String INFORMATIONAL = "Informational";
        public final static String ENCYCLOPEDIA = "Encyclopedia";
        public final static String DICTIONARY = "Dictionary";
        public final static String RELIGIOUS = "Religious";
        public final static String POETRY = "Poetry";
        public final static String MOTIVATIONAL = "Motivational";
    }
}
