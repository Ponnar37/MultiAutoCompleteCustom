package com.autocomplet.multiautocomplete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ponnusamy on 7/27/2017.
 */


@SuppressWarnings("ALL")
public class MultiAutoCompleteCustom extends AppCompatMultiAutoCompleteTextView {

    private static List<String> Values;
    private static ArrayAdapter<String> adapter;
    @SuppressLint("StaticFieldLeak")
    private static AppCompatMultiAutoCompleteTextView multiAutoCompleteTextView;
    private static Seprator seprator;
    public static Character Custom_Token = ',';
    private static String Spliter_Char = "";

    public MultiAutoCompleteCustom(Context context) {
        super(context);
    }

    public MultiAutoCompleteCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiAutoCompleteCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public MultiAutoCompleteCustom setDefaultAdapter(AppCompatMultiAutoCompleteTextView context, List<String> list) {
        multiAutoCompleteTextView = context;
        Values = list;
        adapter = new ArrayAdapter<>(context.getContext(), android.R.layout.simple_dropdown_item_1line, list);
        this.setDefaultToken(Seprator.DEFAULT);
        context.setAdapter(adapter);
        return this;
    }

    public void setAdapter(AppCompatMultiAutoCompleteTextView multiAutoCompleteTextView, List<String> list) {
        MultiAutoCompleteCustom.multiAutoCompleteTextView = multiAutoCompleteTextView;
        Values = list;
        adapter = new ArrayAdapter<>(MultiAutoCompleteCustom.multiAutoCompleteTextView.getContext(), android.R.layout.simple_dropdown_item_1line, list);
        this.setDefaultToken(Seprator.DEFAULT);
        MultiAutoCompleteCustom.multiAutoCompleteTextView.setAdapter(adapter);

    }

    public void setAdapter(AppCompatMultiAutoCompleteTextView multiAutoCompleteTextView, ArrayList<String> list) {
        MultiAutoCompleteCustom.multiAutoCompleteTextView = multiAutoCompleteTextView;
        Values = list;
        adapter = new ArrayAdapter<>(MultiAutoCompleteCustom.multiAutoCompleteTextView.getContext(), android.R.layout.simple_dropdown_item_1line, list);
        this.setDefaultToken(Seprator.DEFAULT);
        MultiAutoCompleteCustom.multiAutoCompleteTextView.setAdapter(adapter);

    }

    public void setAdapter(AppCompatMultiAutoCompleteTextView multiAutoCompleteTextView, LinkedList<String> list) {
        MultiAutoCompleteCustom.multiAutoCompleteTextView = multiAutoCompleteTextView;
        Values = list;
        adapter = new ArrayAdapter<>(MultiAutoCompleteCustom.multiAutoCompleteTextView.getContext(), android.R.layout.simple_dropdown_item_1line, list);
        this.setDefaultToken(Seprator.DEFAULT);
        MultiAutoCompleteCustom.multiAutoCompleteTextView.setAdapter(adapter);

    }

    public MultiAutoCompleteCustom setArrayAdapter(AppCompatMultiAutoCompleteTextView context, List<String> list) {
        multiAutoCompleteTextView = context;
        Values = list;
        adapter = new ArrayAdapter<>(context.getContext(), android.R.layout.simple_dropdown_item_1line, Values);
        return this;
    }

    public MultiAutoCompleteCustom setArrayAdapter(AppCompatMultiAutoCompleteTextView context, String list[]) {
        multiAutoCompleteTextView = context;
        Values = Arrays.asList(list);
        adapter = new ArrayAdapter<>(context.getContext(), android.R.layout.simple_dropdown_item_1line, Values);
        return this;
    }

    public MultiAutoCompleteCustom setDefaultToken() {

        multiAutoCompleteTextView.setTokenizer(new AppCompatMultiAutoCompleteTextView.CommaTokenizer());
        return this;
    }

    public MultiAutoCompleteCustom setCustomToken(Character character) {
        Custom_Token = character;
        Spliter_Char = character.toString();
        multiAutoCompleteTextView.setTokenizer(new com.autocomplet.multiautocomplete.CustomTokenizer());
        return this;
    }

    public MultiAutoCompleteCustom setDefaultToken(Seprator seprator) {
        switch (seprator) {
            case DEFAULT:

                multiAutoCompleteTextView.setTokenizer(new AppCompatMultiAutoCompleteTextView.CommaTokenizer());

                Spliter_Char = ",";
                break;

            case CAMMA:

                multiAutoCompleteTextView.setTokenizer(new com.autocomplet.multiautocomplete.CommaTokenizer());

                Spliter_Char = ",";
                break;

            case DOT:
                multiAutoCompleteTextView.setTokenizer(new com.autocomplet.multiautocomplete.DotTokenizer());
                Spliter_Char = ".";
                break;

            case SPACE:
                Spliter_Char = " ";
                multiAutoCompleteTextView.setTokenizer(new com.autocomplet.multiautocomplete.SpaceTokenizer());
                break;
        }

        return this;
    }

    public MultiAutoCompleteCustom setThreadshold(int value) {

        multiAutoCompleteTextView.setThreshold(value);

        return this;
    }


    public MultiAutoCompleteCustom setFilterType(FilterType filterType) {

        switch (filterType) {
            case HEIGH:
                multiAutoCompleteTextView.setThreshold(1);

                multiAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        setArrayAdapter(multiAutoCompleteTextView, filterValues(charSequence.toString().trim(), Values.toArray(new String[0])));
                        multiAutoCompleteTextView.showDropDown();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
                break;

            case MEDIUM:
                multiAutoCompleteTextView.setThreshold(1);
                multiAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });


                break;

            case LOW:

                multiAutoCompleteTextView.setThreshold(2);
                multiAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });


                break;
        }


        return this;
    }


    @SuppressWarnings({"UnusedAssignment", "StringEquality", "ForLoopReplaceableByForEach"})
    private String[] filterValues(String filtervalue, String[] filter) {
        String[] nevalue;
        String OrigionalFilterValue = null;
        int starts = filtervalue.lastIndexOf(Spliter_Char) + 1;
        //Origional FilterValue
        OrigionalFilterValue = filtervalue.substring(starts, filtervalue.length()).trim();
        //Filter Value is not Empty
        if (!OrigionalFilterValue.isEmpty() || OrigionalFilterValue != "") {
            int j = 0;
            for (int i = 0; i < filter.length; i++) {
                if (filter[i].toLowerCase().trim().startsWith(OrigionalFilterValue)) {
                    ++j;
                }
            }

            nevalue = new String[j];
            j = 0;
            for (int i = 0; i < filter.length; i++) {
                if (filter[i].toLowerCase().trim().startsWith(OrigionalFilterValue)) {
                    nevalue[j] = filter[i];
                    ++j;
                }
            }
            return nevalue;
        }
        return filter;
    }

    public void build() {
        multiAutoCompleteTextView.setAdapter(adapter);
    }


}
