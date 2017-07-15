package com.testbook.mvc.dto;

/**
 * Created by Alexey on 15.07.2017.
 */
public class BookSearch {

    private String parameter;
    private String searchBy;


    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    @Override
    public String toString() {
        return "BookSearch{" +
                "parameter='" + parameter + '\'' +
                ", searchBy='" + searchBy + '\'' +
                '}';
    }
}
